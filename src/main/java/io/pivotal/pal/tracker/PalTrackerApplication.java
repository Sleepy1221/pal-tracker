package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean
    public TimeEntryRepository repo(@Value("${spring.datasource.url:not found}") String springDatasourceUrl){
        System.out.println("db: " + springDatasourceUrl);
        DataSource dataSource = DataSourceBuilder
                .create()
                .url(springDatasourceUrl)
                .build();

        return new JdbcTimeEntryRepository(dataSource);
    }

}