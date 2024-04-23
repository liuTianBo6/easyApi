package com.api.gateway;

import com.api.project.provider.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@EnableDubbo
@Service
@Slf4j
public class ApiGatewayApplication {

    @DubboReference
    private DemoService demoService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApiGatewayApplication.class, args);
        ApiGatewayApplication application = context.getBean(ApiGatewayApplication.class);
        log.info("远程调用的结果: " + application.doSayHello("world"));
        log.info("远程调用的结果: " + application.doSayHello2("world"));
        log.info("ApiGatewayApplication test and run successful!");
    }

    public String doSayHello(String name) {
        return demoService.sayHello(name);
    }

    public String doSayHello2(String name) {
        return demoService.sayHello2(name);
    }

    /*
     *     编程式
     *     @Bean
     *     public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
     *         return builder.routes()
     *                 .route("tobaidu", r -> r.path("/baidu")
     *                         .uri("https://www.baidu.com"))
     *                 .route("toapiicu", r -> r.path("/apiicu")
     *                         .uri("http://api.icu"))
     *                 .build();
     *     }
     */


}
