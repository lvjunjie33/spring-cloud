package snod.com.cn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController{
    @Value("${server.port}")
	String port;
    
	@RequestMapping("/fein-test")
	public String home(@RequestParam String name) {
		System.out.println(port);
		return "fein-test"+name+",i am from port:" +port;
	}
	
	@RequestMapping("/test-two")
	public String hometwo(@RequestParam String name) {
		System.out.println(port);
		return "test-two "+name+",i am from port:" +port;
	}
}
