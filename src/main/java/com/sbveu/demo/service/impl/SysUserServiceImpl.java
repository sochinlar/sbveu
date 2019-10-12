package com.sbveu.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sbveu.demo.entity.SysUser;
import com.sbveu.demo.dao.SysUserMapper;
import com.sbveu.demo.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 王天阳
 * @since 2019-10-12
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public void selectPageList(IPage<SysUser> page, SysUser query) {
        IPage<SysUser> iPage = this.baseMapper.selectPage(page, new QueryWrapper<>());
    }
}
