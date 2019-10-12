package com.sbveu.demo.servicetest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sbveu.demo.entity.SysUser;
import com.sbveu.demo.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author NieYinjun
 * @date 2019/10/12 13:35
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class SysUserSrvTest {
    @Resource
    private ISysUserService sysUserService;
    @Test
    public void getListTest(){
        List<SysUser> sysUsers = sysUserService.getBaseMapper().selectList(new QueryWrapper<>());
        log.info("查询结果：{}", sysUsers);
    }
}
