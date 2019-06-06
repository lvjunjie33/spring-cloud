package snod.com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import snod.com.cn.service.TestService;
@RestController
public class TestController{
    @Value("${server.port}")
	String port;
    
    @Autowired
    TestService testService;
    
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		System.out.println(port);
		return "hi "+name+",i am from port:" +port;
	}
	
	@RequestMapping("/test")
	public String test(@RequestParam String name) {
		return testService.sayHiFromClientOne(name);
	}
}
