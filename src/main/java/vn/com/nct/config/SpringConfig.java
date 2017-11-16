package vn.com.nct.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"vn.com.nct"})
@Import({ WebSocketConfig.class , HibernateConfig.class})
public class SpringConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public InternalResourceViewResolver viewResolve(){
		InternalResourceViewResolver views = new InternalResourceViewResolver();
		views.setViewClass(JstlView.class);
		views.setPrefix("/WEB-INF/views/jsp/");
		views.setSuffix(".jsp");
		return views;
	}
	
	@Bean
	public static PropertyPlaceholderConfigurer properties(){
      PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
      ClassPathResource[] resources = new ClassPathResource[ ]
        { new ClassPathResource( "config.properties" )};
      ppc.setLocations( resources );
      ppc.setIgnoreUnresolvablePlaceholders( true );
      return ppc;
    }
	
	@Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}
