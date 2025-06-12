package com.easypan.service;

import com.easypan.entity.po.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserInfoService 的单元测试类
 */
@SpringBootTest
@Slf4j
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 测试：根据用户ID查询用户信息
     */
    @Test
    public void testGetUserInfoByUserId() {
        String testUserId = "3178033358"; // ⚠️ 确保数据库里存在这个 ID，否则测试会失败

        UserInfo user = userInfoService.getUserInfoByUserId(testUserId);

        assertNotNull(user, "用户信息为空！");
        assertEquals(testUserId, user.getUserId(), "UserId 不匹配！");
        log.info("查询到用户信息：{}", user);
    }

    /**
     * 测试：根据邮箱查询用户信息
     */
    @Test
    public void testGetUserInfoByEmail() {
        String email = "test@qq.com"; // ⚠️ 这个邮箱要在数据库中存在

        UserInfo user = userInfoService.getUserInfoByEmail(email);

        assertNull(user, "找不到该邮箱用户！");
        assertEquals(email, user.getEmail(), "邮箱不一致！");
    }
}