package com.prowings.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.prowings")
public class SpringBeansConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/pages/");
		vr.setSuffix(".jsp");
		
		return vr;
	}
	
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring-mvc-schema");
		ds.setUsername("root");
		ds.setPassword("Shubham@057");
		
		return ds;
		
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.prowings");
		sessionFactory.setHibernateProperties(readHibernateProps());
		
		return sessionFactory;
	}
	
	private Properties readHibernateProps()
	{
		Properties props = new Properties();
		props.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.show_sql","true");
		props.put("hibernate.format_sql","true");
		props.put("hibernate.hbm2ddl.auto","update");
		
		return props;
	}
	
	

}
