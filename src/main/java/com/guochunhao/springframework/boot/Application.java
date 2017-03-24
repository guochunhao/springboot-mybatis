package com.guochunhao.springframework.boot;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.IOException;

/**
 * Created by count on 17/3/23.
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.guochunhao.springframework.boot.mapper")
public class Application
{

    private static Logger logger = Logger.getLogger(Application.class);

    /**
     * dataSource 配置
     * 注解中 ConfigurationProperties prefix 前缀表示的是 application.properties 里的key 值前缀
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.dataSource")
    public DataSource dataSource()
    {
        return new DataSource();
    }

    /**
     * 提供 sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception
    {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));

        return sqlSessionFactoryBean.getObject();

    }

    @Bean
    public PlatformTransactionManager transactionManager()
    {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * main start
     *
     * @param args
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);

        logger.info("==================== spring-boot started success ====================");
    }
}
