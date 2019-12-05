package snod.com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import snod.com.cn.service.TestTwoService;

@RestController
public class TestTwoController {
	@Autowired
	TestTwoService testTwoService;
	
	
	@RequestMapping(value = "/test-three")
    public String testTwo(@RequestParam String name){
        return testTwoService.sayHiFromClientOne(name);
    }
	
}
