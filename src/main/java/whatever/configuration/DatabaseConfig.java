package whatever.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Created by lijc on 15/4/8.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    @Autowired
    private Environment env;

    @Autowired
    private DruidDataSource _dataSource;

    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;

    @Bean
    public DruidDataSource dataSource() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setInitialSize(Integer.parseInt(env.getProperty("initialSize")));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("maxActive")));
        dataSource.setMinIdle(Integer.parseInt(env.getProperty("minIdle")));
        dataSource.setMaxWait(Integer.parseInt(env.getProperty("maxWait")));
        dataSource.setPoolPreparedStatements(Boolean.parseBoolean(env.getProperty("poolPreparedStatements")));
        dataSource.setMaxOpenPreparedStatements(Integer.parseInt(env.getProperty("maxOpenPreparedStatements")));
        dataSource.setValidationQuery(env.getProperty("validationQuery"));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(env.getProperty("testOnBorrow")));
        dataSource.setTestOnReturn(Boolean.parseBoolean(env.getProperty("testOnReturn")));
        dataSource.setTestWhileIdle(Boolean.parseBoolean(env.getProperty("testWhileIdle")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(env.getProperty("timeBetweenEvictionRunsMillis")));
        dataSource.setFilters(env.getProperty("filters"));

        return dataSource;
    }

    /**
     * Declare the JPA entity manager factory.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(_dataSource);

        // Classpath scanning of @Component, @Service, etc annotated class
        entityManagerFactory.setPackagesToScan(
                env.getProperty("entitymanager.packagesToScan"));

        // Vendor adapter
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        // Hibernate properties
        Properties additionalProperties = new Properties();
        additionalProperties.put(
                "hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        additionalProperties.put(
                "hibernate.show_sql",
                env.getProperty("hibernate.show_sql"));
        additionalProperties.put(
                "hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        additionalProperties.put("hibernate.ejb.naming_strategy",
                env.getProperty("hibernate.ejb.naming_strategy"));

        entityManagerFactory.setJpaProperties(additionalProperties);

        return entityManagerFactory;
    }

    /**
     * Declare the transaction manager.
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager =
                new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                entityManagerFactory.getObject());
        return transactionManager;
    }

    /**
     * PersistenceExceptionTranslationPostProcessor is a bean post processor
     * which adds an advisor to any bean annotated with Repository so that any
     * platform-specific exceptions are caught and then rethrown as one
     * Spring's unchecked data access exceptions (i.e. a subclass of
     * DataAccessException).
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
