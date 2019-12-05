package snod.com.cn.hystrix;

import org.springframework.stereotype.Component;

import snod.com.cn.service.TestTwoService;
@Component
public class TwoSchedualServiceHiHystric implements TestTwoService{

	@Override
	public String sayHiFromClientOne(String name) {
		// TODO Auto-generated method stub
		return "TwoSchedualServiceHiHystric"+name;
	}

}
