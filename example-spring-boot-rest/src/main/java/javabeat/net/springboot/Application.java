package javabeat.net.springboot;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource({"classpath:application.properties"})
public class Application extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        
        
        
        
        SpringApplication.run(Application.class, args);
        
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:oracle:thin:@localhost:1521:xe", "szymonTest", "test");
        flyway.setBaselineOnMigrate(true);
        flyway.setValidateOnMigrate(true);
        flyway.migrate();
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
