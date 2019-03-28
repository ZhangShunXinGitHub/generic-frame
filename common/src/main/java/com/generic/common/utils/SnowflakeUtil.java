package com.generic.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
JS语言不支持15位以上的长整型，该工具使用与否要有取舍。
 */
@Slf4j
public class SnowflakeUtil {
    /** 开始时间截 (2015-01-01) */
    private final static long TWEPOCH = 1420041600000L;
    /** 工作机器ID(0~31) */
    private final static long WORKER_ID = getWorkerId();
    /** 数据中心ID(0~31) */
    private final static long DATA_CENTER_ID = getDataCenterId();
    /** 机器id所占的位数 */
    private final static long WORKER_ID_BITS = 8L;
    /** 数据标识id所占的位数 */
    private final static long DATA_CENTER_ID_BITS = 2L;
    /** 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数) */
    private final static long MAX_WORKER_ID = -1L ^ (-1L << WORKER_ID_BITS);
    /** 支持的最大数据标识id，结果是31 */
    private final static long MAX_DATA_CENTER_ID = -1L ^ (-1L << DATA_CENTER_ID_BITS);
    /** 序列在id中占的位数 */
    private final static long SEQUENCE_BITS = 12L;
    /** 机器ID向左移12位 */
    private final static long WORKER_ID_SHIFT = SEQUENCE_BITS;
    /** 数据标识id向左移17位(12+5) */
    private final static long DATA_CENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    /** 时间截向左移22位(5+5+12) */
    private final static long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATA_CENTER_ID_BITS;
    /** 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095) */
    private final static long SEQUENCE_MASK = -1L ^ (-1L << SEQUENCE_BITS);
    /** 毫秒内序列(0~4095) */
    private static long sequence = 0L;
    /** 上次生成ID的时间截 */
    private static long lastTimestamp = -1L;

    /**
     * 获得下一个ID (该方法是线程安全的)
     *
     * @return SnowflakeId
     */
    public static synchronized long nextId() {
        if (WORKER_ID > MAX_WORKER_ID || WORKER_ID < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        if (DATA_CENTER_ID > MAX_DATA_CENTER_ID || DATA_CENTER_ID < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", MAX_DATA_CENTER_ID));
        }
        long timestamp = System.currentTimeMillis();
        // 如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        // 如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            // 毫秒内序列溢出
            if (sequence == 0) {
                // 阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        // 时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }
        // 上次生成ID的时间截
        lastTimestamp = timestamp;
        // 移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - TWEPOCH) << TIMESTAMP_LEFT_SHIFT) //
                | (DATA_CENTER_ID << DATA_CENTER_ID_SHIFT) //
                | (WORKER_ID << WORKER_ID_SHIFT) //
                | sequence;
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param lastTimestamp
     *            上次生成ID的时间截
     * @return 当前时间戳
     */
    private static long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    public static Long getWorkerId() {
        try {
            return Long.parseLong(StringUtils.substringAfterLast(InetAddress.getLocalHost().getHostAddress(), "."));
        } catch (UnknownHostException e) {
            log.error("get loacal ip exception:{}",e);
            throw new IllegalArgumentException("get loacal ip exception");
        }
    }

    public static Long getDataCenterId() {
        return (long) (Math.random() * 3 + 1);
    }
}
