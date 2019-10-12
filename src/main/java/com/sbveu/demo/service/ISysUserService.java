package com.sbveu.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sbveu.demo.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 王天阳
 * @since 2019-10-12
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 分页查询
     * @param page 分页条件
     * @param query 查询条件
     */
    void selectPageList(IPage<SysUser> page, SysUser query);
}
