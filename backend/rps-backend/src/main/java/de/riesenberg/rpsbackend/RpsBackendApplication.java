package de.riesenberg.rpsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"de.riesenberg.rpsbackend.domain" })
@EnableJpaRepositories(basePackages = {"de.riesenberg.rpsbackend.repository"})
public class RpsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpsBackendApplication.class, args);
    }

}
