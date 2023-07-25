package org.tuke.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.tuke.entity.EmployeesTasks;
import org.tuke.exception.CustomSqlErrorCodeTranslator;
import org.tuke.repository.ClienteDAO;
import org.tuke.repository.ClienteDAOImpl;
import org.tuke.repository.EmployeesTasksDAO;
import org.tuke.repository.EmployeesTasksDAOImp;
import org.tuke.repository.TaskDAO;
import org.tuke.repository.TaskDAOImp;

@Configuration
@ComponentScan(basePackages = "org.tuke")
@PropertySource(value = "classpath:application.properties")
@EnableWebMvc
public class ApplicationConfiguration implements WebMvcConfigurer  {
	
	@Value("${jdbc.driver}")
	private String jdbcClassDriver;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.user}")
	private String jdbcUser;
	@Value("${jdbc.password}")
	private String jdbcPassword;
	
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources");
		
	}
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(jdbcClassDriver);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(jdbcUser);
		dataSource.setPassword(jdbcPassword);
		
		return dataSource;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource());
		template.setExceptionTranslator( new  CustomSqlErrorCodeTranslator());
		
		return template;
	}
	
	@Bean 
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	@Bean
	public SimpleJdbcInsert simpleJdbcInsert() {
		
		SimpleJdbcInsert template = new SimpleJdbcInsert(dataSource());
		return template;
	}
	
	@Bean
	public ClienteDAO getClienteDAO() {
		return new ClienteDAOImpl();
	}
	
	@Bean
	public TaskDAO getTaskDAO() {
		return new TaskDAOImp();
	}
	
	@Bean
	public EmployeesTasksDAO getEmployeesTasks() {
		return new EmployeesTasksDAOImp();
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	

}
