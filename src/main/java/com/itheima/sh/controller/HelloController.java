package com.itheima.sh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: ITHEIMA
 * @Version: V1.0
 */
@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("hello")
    public String hello(HttpServletRequest request) {
        // 获取IP
        String key = request.getRemoteHost();
        // redis自增长
        Long num = redisTemplate.opsForValue().increment(key);
        // 记录日志
        log.info("第{}次访问！", num);

        // 返回字符串
        return "欢迎来到传智播客，您访问了" + num + "次";
    }
}
