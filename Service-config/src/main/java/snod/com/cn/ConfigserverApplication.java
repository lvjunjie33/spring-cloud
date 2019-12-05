package snod.com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@EnableConfigServer
@SpringBootApplication
@EnableEurekaClient//开启eureka的注册服务
public class ConfigserverApplication extends SpringBootServletInitializer{
		public static void main(String[] args) {
	        SpringApplication.run(ConfigserverApplication.class);
	    }
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		     return application.sources(ConfigserverApplication.class);
		}

}
