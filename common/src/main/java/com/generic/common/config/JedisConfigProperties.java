package com.generic.common.config;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "redis.cluster")
public class JedisConfigProperties {
   private int connectionTimeout;
   private int maxTotal;
   private int maxWaitMills;
   private int maxIdle;
   private int minIdle;
   private boolean testOnBorrow;
   private boolean testOnReturn;

   public int getConnectionTimeout() {
      return connectionTimeout;
   }

   public int getMaxTotal() {
      return maxTotal;
   }

   public int getMaxWaitMills() {
      return maxWaitMills;
   }

   public int getMaxIdle() {
      return maxIdle;
   }

   public int getMinIdle() {
      return minIdle;
   }

   public boolean isTestOnBorrow() {
      return testOnBorrow;
   }

   public boolean isTestOnReturn() {
      return testOnReturn;
   }

   public void setConnectionTimeout(int connectionTimeout) {
      this.connectionTimeout = connectionTimeout;
   }

   public void setMaxTotal(int maxTotal) {
      this.maxTotal = maxTotal;
   }

   public void setMaxWaitMills(int maxWaitMills) {
      this.maxWaitMills = maxWaitMills;
   }

   public void setMaxIdle(int maxIdle) {
      this.maxIdle = maxIdle;
   }

   public void setMinIdle(int minIdle) {
      this.minIdle = minIdle;
   }

   public void setTestOnBorrow(boolean testOnBorrow) {
      this.testOnBorrow = testOnBorrow;
   }

   public void setTestOnReturn(boolean testOnReturn) {
      this.testOnReturn = testOnReturn;
   }
}
