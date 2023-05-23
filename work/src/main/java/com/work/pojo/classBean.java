package com.work.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class classBean {
    private Integer id; //ID
    private String name; //班级
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
