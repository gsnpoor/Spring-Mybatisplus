package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//lombok
@Data
@TableName("user")
public class User {
    private Long id;
    private String name;

    //映射匹配,select = false 表示查询时不显示
    @TableField(value = "pwd", select = false)
    private String password;
    private Integer age;
    private String tel;
    @TableField(exist = false)
    private Integer online;
}
