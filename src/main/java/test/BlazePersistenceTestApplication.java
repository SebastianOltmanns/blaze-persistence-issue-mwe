package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "test")
@EntityScan(basePackages = "test")
@EnableTransactionManagement
public class BlazePersistenceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlazePersistenceTestApplication.class, args);
    }

}
