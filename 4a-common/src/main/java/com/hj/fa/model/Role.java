package com.hj.fa.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("T_GE_ROLE")
public class Role implements Serializable {

    private static final long serialVersionUID = -2345891401384008486L;
    /**
     * 角色ID
     */
    @TableId(value = "ROLE_ID",type = IdType.AUTO)
    private Long roleId;


    /**
     * 角色名
     */
    @TableField("ROlE_NAME")
    private String roleName;

    /**
     * 角色Code
     */
    @TableField("ROLE_CODE")
    private String roleCode;


    /**
     * 逻辑删除
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
