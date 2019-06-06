package snod.com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"snod.com.cn"})
@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigserverApplication extends SpringBootServletInitializer{
		public static void main(String[] args) {
	        SpringApplication.run(ConfigserverApplication.class);
	    }
		

}
