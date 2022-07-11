package com.hj.fa.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("T_GE_USER")
public class User implements Serializable{

    private static final long serialVersionUID = -1737179066991634402L;

    /**
     * 用户ID
     */
    @TableId(value = "USER_ID",type = IdType.AUTO)
    private Long userId;

    /**
     * 客户端id
     */
    @TableField("CLIENT_ID")
    private String clientId;

    /**
     * 账号名
     */
    @TableField("USER_NAME")
    private String username;

    /**
     * 账号描述
     */
    @TableField("USER_DESC")
    private String userDesc;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 手机号
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 性别
     */
    @TableField("GENDER")
    private int gender;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 生日
     */
    @TableField("BIRTHDAY")
    private LocalDate birthday;

    /**
     * 是否可用
     */
    @TableField("ENABLED")
    private Boolean enabled;

    /**
     * 账号未过期
     */
    @TableField("ACCOUNT_NON_EXPIRED")
    private Boolean accountNonExpired;

    /**
     * 账号未锁定
     */
    @TableField("ACCOUNT_NON_LOCKED")
    private Boolean accountNonLocked;

    /**
     * 密码未过期
     */
    @TableField("CREDENTIALS_NON_EXPIRED")
    private Boolean credentialsNonExpired;

    /**
     * 账号未删除(逻辑删除)
     */
    @TableField("IS_DEL")
    private Boolean isDelete;

    /**
     * 创建时间
     */
    @TableField("CREATED_TIME")
    private LocalDateTime createdTime;

    /**
     * 创建人
     */
    @TableField("CREATED_BY")
    private Long createdBy;

    /**
     * 更新时间
     */
    @TableField("UPDATED_TIME")
    private LocalDateTime updatedTime;

    /**
     * 更新人
     */
    @TableField("UPDATED_BY")
    private Long updatedBy;

}
