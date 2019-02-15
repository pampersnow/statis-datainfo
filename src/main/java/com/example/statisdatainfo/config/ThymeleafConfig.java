package com.example.statisdatainfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/*@Configuration*/
public class ThymeleafConfig {
	
	/**
	 * @Title: viewResolver   
	 * @Description: 设置视图解析器
	 * @param: templateEngine      
	 * @return: ViewResolver      
	 * @throws
	 * @see 方法(Methods)标签
	 */
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine);
		return resolver;	
	}
	
	/**
	 * @Title: templateEngine   
	 * @Description: 设置模板引擎
	 * @param: @param templateResolver   
	 * @return: SpringTemplateEngine      
	 * @throws
	 * @see 方法(Methods)标签
	 */
	@Bean
	public SpringTemplateEngine  templateEngine(TemplateResolver templateResolver) {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver);
		return engine;	
	}
	
	/**
	 * @Title: templateResolver   
	 * @Description: 模板解析引擎
	 * @return: TemplateResolver      
	 * @throws
	 * @see 方法(Methods)标签
	 */
	@Bean
	public TemplateResolver templateResolver() {
		TemplateResolver resolver = new TemplateResolver();
		//设置地址前缀
		resolver.setPrefix("/WEB-INF/template/");
		//设置后缀
		resolver.setSuffix(".html");
		//设置缓存
		resolver.setCacheable(true);
		resolver.setTemplateMode("HTML5");
		return resolver;
	}
}












