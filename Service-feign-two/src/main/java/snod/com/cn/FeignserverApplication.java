package snod.com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@ComponentScan(basePackages = {"snod.com.cn"})
@EnableHystrix
public class FeignserverApplication extends SpringBootServletInitializer{
	
		public static void main(String[] args) {
	        SpringApplication.run(FeignserverApplication.class);
	    }
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		     return application.sources(FeignserverApplication.class);
		}
		 @Bean
		 @LoadBalanced
		 RestTemplate restTemplate() {
		     return new RestTemplate();
		 }
		@Bean
		public ServletRegistrationBean getServlet(){
			HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
			ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
			registrationBean.setLoadOnStartup(1);
			registrationBean.addUrlMappings("/actuator/hystrix.stream");
			registrationBean.setName("HystrixMetricsStreamServlet");
			return registrationBean;
		}
}
