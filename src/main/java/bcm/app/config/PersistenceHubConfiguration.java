package bcm.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:datasource-cfg.properties" })
@EnableJpaRepositories(
        basePackages = "bcm.app.repository.hub",
        entityManagerFactoryRef = "hubEntityManager",
        transactionManagerRef = "hubTransactionManager"
)
public class PersistenceHubConfiguration {

    @Autowired
    private Environment env;

    //@Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean hubEntityManager() {
        System.out.println("loading config");
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(hubDataSource());
        em.setPackagesToScan("bcm.app.model.hub");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    //@Primary
    @Bean
    public DataSource hubDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("hub.jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("hub.jdbc.url"));
        dataSource.setUsername(env.getProperty("hub.jdbc.user"));
        dataSource.setPassword(env.getProperty("hub.jdbc.pass"));
        return dataSource;
    }

    //@Primary
    @Bean
    public PlatformTransactionManager hubTransactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(hubEntityManager().getObject());
        return transactionManager;
    }

}
