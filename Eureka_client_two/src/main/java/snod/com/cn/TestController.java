package snod.com.cn;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
    @Value("${server.port}")
	String port;
    
    
    
	@RequestMapping("/hi")
	public String home(@RequestParam String name) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress();
		System.out.println(port);
		return "本机的IP为"+ip+ "hi"+name+",i am from port:" +port;
	}
}
