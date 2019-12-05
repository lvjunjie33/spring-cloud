package snod.com.cn.security.browser;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import snod.com.cn.security.code.ValidateCodeFilter;
import snod.com.cn.security.handler.MyAuthenticationAccessDeniedHandler;
import snod.com.cn.security.handler.MyLogOutSuccessHandler;
import snod.com.cn.security.smscode.SmsAuthenticationConfig;
import snod.com.cn.security.smscode.SmsCodeFilter;

/**
 * @author lvjj
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	 @Override
	    public void configure(HttpSecurity http) throws Exception {
	        http
	                .csrf().disable()
	                .exceptionHandling()
	                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
	                .and()
	                .requestMatchers().antMatchers("/**")
	                .and()
	                .authorizeRequests()
	                .antMatchers("/**").authenticated()
	                .and()
	                .httpBasic();
	    }

   
    
   
}
