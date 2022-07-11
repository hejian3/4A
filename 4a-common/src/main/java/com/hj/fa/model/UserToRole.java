package com.hj.fa.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("T_GE_USER_TO_ROLE")
public class UserToRole {

    /**
     * ID
     */
    @TableId(value = "ID",type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "ROLE_ID")
    private Long roleId;

    /**
     * 用户ID
     */
    @TableField(value = "USER_ID")
    private Long userId;

}
