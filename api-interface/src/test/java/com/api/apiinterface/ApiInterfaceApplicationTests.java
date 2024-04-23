package com.api.apiinterface;

import com.api.sdk.client.ApiClient;
import com.api.sdk.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class ApiInterfaceApplicationTests {

    @Resource
    private ApiClient ApiClient;

    /**
     * 跑通整个流程：
     * ak,sk验证
     * 查询用户及其接口
     * 调用成功+1
     */
    @Test
    void run() {
        // 打印ApiClient
        log.info("ApiClient: " + ApiClient);

        // 这个方法没有签名认证参数, 会报403
        // log.info(ApiClient.getNameByGet("anyName"));

        // 这个方法在请求头添加了签名认证参数, ok
        User user = new User();
        user.setUsername("anyName");
        String usernameByPost = ApiClient.getUsernameByPost(user);
        log.info(usernameByPost);
    }
}
