package snod.com.cn.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import snod.com.cn.hystrix.SchedualServiceHiHystric;

@FeignClient(value = "service-web",fallback = SchedualServiceHiHystric.class)
public interface TestService {
	 @RequestMapping(value = "/hi",method = RequestMethod.GET)
	 String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
