package snod.com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class ZuulserverApplication extends SpringBootServletInitializer{

		public static void main(String[] args) {
	        SpringApplication.run(ZuulserverApplication.class,args);
	    }
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		     return application.sources(ZuulserverApplication.class);
		}
}
