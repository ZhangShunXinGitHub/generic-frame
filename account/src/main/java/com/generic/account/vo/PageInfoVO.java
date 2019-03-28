package com.generic.account.vo;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfoVO <T>{
    private Integer pageNum;
    private Integer pageSize;
    private Integer pages;
    private Long total;
    private List<T> list;
    public static <T> PageInfoVO<T> build(Page<T> page){
        PageInfoVO<T> pageInfoVO=new PageInfoVO<>();
        BeanUtils.copyProperties(page.toPageInfo(),pageInfoVO);
        return pageInfoVO;
    }
}
