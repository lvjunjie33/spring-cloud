package snod.com.cn.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import snod.com.cn.security.code.UserAuthenticationFilter;
import snod.com.cn.security.code.ValidateCodeFilter;
import snod.com.cn.security.handler.MyAuthenticationAccessDeniedHandler;
import snod.com.cn.security.handler.MyAuthenticationFailureHandler;
import snod.com.cn.security.handler.MyAuthenticationSucessHandler;
import snod.com.cn.security.handler.MyLogOutSuccessHandler;
import snod.com.cn.security.smscode.SmsAuthenticationConfig;
import snod.com.cn.security.smscode.SmsCodeFilter;
import snod.com.cn.service.UserDetailService;
/**
 * @author lvjj
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAuthenticationSucessHandler authenticationSucessHandler;

	@Autowired
	private MyAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private MyAuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;
    
    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Autowired
    private SmsCodeFilter smsCodeFilter;
    
    @Autowired
    private SmsAuthenticationConfig smsAuthenticationConfig;
    
    @Autowired
    private MyLogOutSuccessHandler logOutSuccessHandler;
    
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();// 密码加密方式
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public UserAuthenticationFilter loginAuthenticationFilter() {
		UserAuthenticationFilter filter = new UserAuthenticationFilter();
		try {
			filter.setAuthenticationManager(authenticationManagerBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		filter.setAuthenticationSuccessHandler(authenticationSucessHandler);// 认证成功处理类
		filter.setAuthenticationFailureHandler(authenticationFailureHandler);// 认证失败处理类
		return filter;
	}
	
	 @Override
		public void configure(HttpSecurity http) throws Exception {
	    	 //配置自定义过滤器 增加post json 支持
//	            http.addFilterAt(UserAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class)
	    	http.exceptionHandling()
	        .accessDeniedHandler(authenticationAccessDeniedHandler)//权限不足自定义处理
	        .and()
	    	.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加验证码校验过滤器
	            .addFilterBefore(smsCodeFilter,UsernamePasswordAuthenticationFilter.class)// 添加短信验证码校验过滤器
//	            .addFilterBefore(userAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)// 添加用户获取body数据
//	                .formLogin() // 表单登录
//	                     http.httpBasic() // HTTP Basic
//	                    .loginPage("/login") // 登录跳转 URL
//	                    .loginProcessingUrl("/login") // 处理表单登录 URL
//	                    .successHandler(authenticationSucessHandler) // 处理登录成功
//	                    .failureHandler(authenticationFailureHandler) // 处理登录失败
//	                .and()
	                    .authorizeRequests() // 授权配置
	                    .antMatchers("/login", 
	                    		"/login.html", 
	                    		"/code/image",
	                    		"/code/sms",
	                    		"/v2/api-docs",
	                    		"/configuration/ui", 
	                    		"/swagger-resources", 
	                    		"/configuration/security", 
	                    		"/swagger-ui.html", 
	                    		"/webjars/**",
	                    		"/swagger-resources/configuration/ui",
	                    		"/swagge‌​r-ui.html",
	                    		"/session/invalid",
	                    		"/api",//添加放开api不需要认证
	                    		"/oauth"//添加放开获取token
	                    		).permitAll() // 无需认证的请求路径
	                    .and()
	                    .authorizeRequests()
	                    .antMatchers("/**").authenticated()//所有请求都需要认证
	                    .and()
	                    .sessionManagement() // 添加 Session管理器
//	                    .invalidSessionStrategy(customizeInvalidSessionStrategy)
//	                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//	                    .invalidSessionUrl("/session/invalid") // Session失效后跳转到这个链接
	                    .and()
	                    .logout()
	                    .logoutUrl("/signout")
	                    // .logoutSuccessUrl("/signout/success")
	                    .logoutSuccessHandler(logOutSuccessHandler)//退出登录自定义处理
	                    .deleteCookies("JSESSIONID")
	                .and()
	                    .csrf().disable()
	                .apply(smsAuthenticationConfig); // 将短信验证码认证配置加到 Spring Security 中
//	            http.addFilterAt(UserAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
	    }

}
