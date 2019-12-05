package snod.com.cn.hystrix;

import org.springframework.stereotype.Component;

import snod.com.cn.service.TestService;

@Component
public class SchedualServiceHiHystric implements TestService{
//public class SchedualServiceHiHystric{
	@Override
	public String sayHiFromClientOne(String name) {
		// TODO Auto-generated method stub
		 return "sorry "+name;
	}

	@Override
	public String sayHiFromClienttwo(String name) {
		// TODO Auto-generated method stub
		return "sorry two "+name;
	}

}
