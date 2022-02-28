package alibaba;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lixiaolong
 * @EnableDiscoveryClient 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
 * @date 2020/12/18 16:05
 * @description 支付服务
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class CloudalibabaConsumerNacosOrder84Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConsumerNacosOrder84Application.class, args);
        System.out.println("启动成功");
    }

}
