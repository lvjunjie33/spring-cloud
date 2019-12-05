package snod.com.cn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@ComponentScan(basePackages = {"snod.com.cn"})
@SpringBootApplication
@RestController
@RefreshScope
@EnableDiscoveryClient
public class ConfigclientApplication{
		public static void main(String[] args) {
	        SpringApplication.run(ConfigclientApplication.class);
	    }
		
		@Value("${abc.aa}")
		String aa;
		@RequestMapping(value = "/hi")
		public String hi(){
			return aa;
		}
}
