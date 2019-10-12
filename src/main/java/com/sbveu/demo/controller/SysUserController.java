package com.sbveu.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sbveu.demo.entity.SysUser;
import com.sbveu.demo.model.RestResponseEntity;
import com.sbveu.demo.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 王天阳
 * @since 2019-10-12
 */
@Controller
@RequestMapping("/sysUser")
@Slf4j
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @GetMapping("/pageList")
    @ResponseBody
    public Object pageList(IPage<SysUser> page,SysUser query){
        log.info("查询条件：page=【{},{}】,query={}",page.getSize(),page.getCurrent(),query);
        sysUserService.selectPageList(page,query);
        return RestResponseEntity.ok("查询成功",page);
    }
}
