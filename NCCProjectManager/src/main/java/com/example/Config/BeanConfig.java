package com.example.Config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
@Configuration
public class BeanConfig {
  
  @Autowired
  private Environment env;
  
  @Bean(name = "dataSource")
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
    dataSource.setUrl(env.getProperty("spring.datasource.url"));
    dataSource.setUsername(env.getProperty("spring.datasource.username"));
    dataSource.setPassword(env.getProperty("spring.datasource.password"));
    return dataSource;
  }
  @Autowired
  @Bean(name = "sessionFactory")
  public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
    properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
    properties.put("current_session_context_class", //
        env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
    // Package contain entity classes
    factoryBean.setPackagesToScan("com.example.Entity");
    factoryBean.setDataSource(dataSource);
    factoryBean.setHibernateProperties(properties);
    factoryBean.afterPropertiesSet();
    //
    SessionFactory sf = factoryBean.getObject();
    System.out.println("## getSessionFactory: " + sf);
    return sf;
  }
  @Autowired
  @Bean(name = "transactionManager")
  public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
    return transactionManager;
  }
}