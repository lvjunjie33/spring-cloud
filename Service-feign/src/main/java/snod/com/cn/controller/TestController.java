package snod.com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import snod.com.cn.service.TestService;

@RestController
public class TestController {
	@Autowired
	TestService testService;
	@RequestMapping(value = "/test")
    public String hi(@RequestParam String name){
        return testService.sayHiFromClientOne(name);
    }
	
	
	@RequestMapping(value = "/test2")
    public String test2(@RequestParam String name){
        return "test2";
    }
}
