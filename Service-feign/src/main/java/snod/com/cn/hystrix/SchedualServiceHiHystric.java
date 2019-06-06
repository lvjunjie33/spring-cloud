package snod.com.cn.hystrix;

import org.springframework.stereotype.Component;

import snod.com.cn.service.TestService;
@Component
public class SchedualServiceHiHystric implements TestService{

	@Override
	public String sayHiFromClientOne(String name) {
		// TODO Auto-generated method stub
		 return "sorry "+name;
	}

}
