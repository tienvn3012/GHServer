package vn.com.nct.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	//com.mysql.jdbc.Driver
	@Value("${jdbc.driverClassName}")
	private String driverClass;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.username}")
	private String username;
	
	@Value("${hibernate.dialect}")
	private String hibernateDialert;
	
	@Value("${jdbc.url}")
	private String url;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("vn.com.nct.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setPassword(password);
		dataSource.setUsername(username);
		dataSource.setUrl(url);
		return dataSource;
	}
	
    @Bean
    public HibernateTransactionManager transactionManager() {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory().getObject());
       return txManager;
    }
    
    @Bean
    public HibernateTemplate hibernateTemplate() {
    	return new HibernateTemplate(sessionFactory().getObject());
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialert);
        properties.put("hibernate.show_sql", false);
        properties.put("hibernate.format_sql", false);
        properties.put("hibernate.enable_lazy_load_no_trans", true);
        
		properties.put("hibernate.hbm2ddl.auto", "create");
		
        return properties;        
    }

}
