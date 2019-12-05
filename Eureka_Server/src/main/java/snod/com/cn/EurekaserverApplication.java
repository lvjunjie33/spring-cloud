package snod.com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;




@EnableEurekaServer
@ComponentScan(basePackages = {"snod.com.cn"})
@SpringBootApplication
public class EurekaserverApplication {
		
		public static void main(String[] args) {
			SpringApplication.run(EurekaserverApplication.class, args);
	    }
}
