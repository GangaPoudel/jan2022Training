package com.virtusa.calendarapi.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableConfigurationProperties(VaultConfiguration.class)
public class DbConfiguration {

    @Value(("${db_url_4}"))
    private String dbUrl;
    @Value("${db_driver}")
    private String driver;
    private final VaultConfiguration vaultConfiguration;
    private DataSourceBuilder dataSourceBuilder;

    public DbConfiguration(VaultConfiguration vaultConfiguration) {
        this.vaultConfiguration=vaultConfiguration;
    }

    @Bean
    public DataSource createDataSource() {
        dataSourceBuilder=DataSourceBuilder.create();
        dataSourceBuilder.url(dbUrl);
        log.info("UserName"+vaultConfiguration.getUsername());
        log.info("Password"+vaultConfiguration.getPassword());
        dataSourceBuilder.username(vaultConfiguration.getUsername());
        dataSourceBuilder.password(vaultConfiguration.getPassword());
        dataSourceBuilder.driverClassName(driver);
        return dataSourceBuilder.build();
    }

}
