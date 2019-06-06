package snod.com.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {
	
	 @Autowired
	 RestTemplate restTemplate;
	 /**
	  * 熔断机制 @HystrixCommand(fallbackMethod = "hiError")
	  * */
	 @HystrixCommand(fallbackMethod = "hiError")
	 public String test(String s) {
		 return restTemplate.getForObject("http://service-web/hi?name="+s,String.class);
	 }
	 /**
	  * 熔断回调方法
	  * */
	 public String hiError(String name) {
	        return "hi,"+name+",sorry,error!";
	 }
}
