package snod.com.cn;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;




@EnableEurekaServer
@ComponentScan(basePackages = {"snod.com.cn"})
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
public class EurekaserverApplication extends SpringBootServletInitializer{
		@Bean
		public MultipartConfigElement multipartConfigElement() {
			MultipartConfigFactory factory = new MultipartConfigFactory();
			factory.setMaxFileSize("5MB");
			factory.setMaxRequestSize("5MB");
			return factory.createMultipartConfig();
		}
		public static void main(String[] args) {
	        SpringApplication.run(EurekaserverApplication.class);
	    }
}
