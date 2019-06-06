package snod.com.cn.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import snod.com.cn.service.TestService;

@RestController
public class TestControler {
	    @Autowired
	    TestService testService;
	    
	    @RequestMapping(value = "/test")
	    public String hi(@RequestParam String name){
	        return testService.test(name);
	    }

}
