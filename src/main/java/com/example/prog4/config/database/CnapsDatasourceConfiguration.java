package com.example.prog4.config.database;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@EnableJpaRepositories(
    entityManagerFactoryRef = "cnapsEntityManagerFactory",
    transactionManagerRef = "cnapsTransactionManager",
    basePackages = {"com.example.prog4.repository.Cnaps"})
public class CnapsDatasourceConfiguration {
  @Bean(name = "cnapsProperties")
  @ConfigurationProperties("spring.datasource.cnaps")
  public DataSourceProperties dataSourceProperties() {

    return new DataSourceProperties();
  }

  @Bean(name = "cnapsDatasource")
  @ConfigurationProperties(prefix = "spring.datasource.cnaps")
  public DataSource datasource(@Qualifier("cnapsProperties") DataSourceProperties properties) {

    return properties.initializeDataSourceBuilder().build();
  }

  @Bean(name = "cnapsEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
      (EntityManagerFactoryBuilder builder,
       @Qualifier("cnapsDatasource") DataSource dataSource) {

    return builder.dataSource(dataSource)
        .packages("com.example.prog4.entity.Cnaps")
        .persistenceUnit("cnaps").build();
  }

  @Bean(name = "cnapsTransactionManager")
  @ConfigurationProperties("spring.jpa")
  public PlatformTransactionManager transactionManager(
      @Qualifier("cnapsEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

    return new JpaTransactionManager(entityManagerFactory);
  }
}
