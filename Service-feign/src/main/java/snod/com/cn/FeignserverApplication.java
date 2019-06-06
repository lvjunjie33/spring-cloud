package snod.com.cn;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@ComponentScan(basePackages = {"snod.com.cn"})
@EnableDiscoveryClient
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
public class FeignserverApplication extends SpringBootServletInitializer{
		@Bean
		public MultipartConfigElement multipartConfigElement() {
			MultipartConfigFactory factory = new MultipartConfigFactory();
			factory.setMaxFileSize("5MB");
			factory.setMaxRequestSize("5MB");
			return factory.createMultipartConfig();
		}
		public static void main(String[] args) {
	        SpringApplication.run(FeignserverApplication.class);
	    }
		
	  	@Bean
		@LoadBalanced
		RestTemplate restTemplate() {
			return new RestTemplate();
		}
}
