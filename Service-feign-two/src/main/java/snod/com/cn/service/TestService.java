package snod.com.cn.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import snod.com.cn.hystrix.SchedualServiceHiHystric;

@FeignClient(value = "service-client",fallback = SchedualServiceHiHystric.class)
//@FeignClient(value = "service-client")
public interface TestService {
	 @RequestMapping(value = "/fein-test",method = RequestMethod.GET)
	 String sayHiFromClientOne(@RequestParam(value = "name") String name);
	 
	 @RequestMapping(value = "/test-two",method = RequestMethod.GET)
	 String sayHiFromClienttwo(@RequestParam(value = "name") String name);
}
