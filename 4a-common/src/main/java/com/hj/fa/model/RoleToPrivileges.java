package com.hj.fa.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("T_GE_ROLE_TO_PRIVILEGE")
public class RoleToPrivileges {

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
     * 权限ID
     */
    @TableField(value = "PRIVILEGE_ID")
    private Long privilegeId;

}
