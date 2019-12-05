package snod.com.cn.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import snod.com.cn.hystrix.TwoSchedualServiceHiHystric;

@FeignClient(value = "service-client-three",fallback = TwoSchedualServiceHiHystric.class)
public interface TestTwoService {
	 @RequestMapping(value = "/test-three",method = RequestMethod.GET)
	 String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
