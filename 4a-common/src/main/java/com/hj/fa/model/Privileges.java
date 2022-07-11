package com.hj.fa.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("T_GE_PRIVILEGE")
public class Privileges implements Serializable {

    private static final long serialVersionUID = -5268620763782136756L;
    /**
     * 权限ID
     */
    @TableId(value = "PRIVILEGE_ID",type = IdType.AUTO)
    private Long privilegeId;


    /**
     * 权限名
     */
    @TableField("PRIVILEGE_NAME")
    private String privilegeName;

    /**
     * 编码
     */
    @TableField("PRIVILEGE_CODE")
    private String privilegeCode;


    /**
     * 描述
     */
    @TableField("PRIVILEGE_DESC")
    private String privilegeDesc;

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
