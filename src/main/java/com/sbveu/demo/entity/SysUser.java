package com.sbveu.demo.entity;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 王天阳
 * @since 2019-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId("id")
    private Long id;

    /**
     * 人员信息表id
     */
    @TableField("tbse02_id")
    private Long tbse02Id;

    /**
     * 用户名称
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户昵称
     */
    @TableField("cname")
    private String cname;

    /**
     * 状态：0 停用 1启用
     */
    @TableField("status")
    private Integer status;

    /**
     * 手机
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField("mail")
    private String mail;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 部门id
     */
    @TableField("dept_id")
    private Long deptId;

    /**
     * 是否在APP上可以查看视频 0.否 1.是
     */
    @TableField("video_flag")
    private Integer videoFlag;

    /**
     * 是否在APP上可以查看报表 0.否 1.是
     */
    @TableField("report_flag")
    private Integer reportFlag;

    /**
     * 创建人员
     */
    @TableField(value = "create_emp", fill = FieldFill.INSERT)
    private String createEmp;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新人员
     */
    @TableField(value = "update_emp", fill = FieldFill.UPDATE)
    private String updateEmp;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 乐观锁保留字段
     */
    @TableField(value = "version", fill = FieldFill.INSERT)
    @Version
    private Integer version;


}
