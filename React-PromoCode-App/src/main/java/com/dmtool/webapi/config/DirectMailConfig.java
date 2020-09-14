
package com.dmtool.webapi.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.dmtool.webapi.repository"},
        entityManagerFactoryRef= "entityManagerFactory",
        transactionManagerRef = "transactionManager")
public class DirectMailConfig {

    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean directMailFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource2") DataSource dataSource2)
    {
        return builder
                .dataSource(dataSource2)
                .packages("com.dmtool.webapi.model")
                .persistenceUnit("webapi")
                .build();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager mailDSTransactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory
                    directMailFactory
    ){
        return new JpaTransactionManager(directMailFactory);
    }

}
