package com.javaconcepts.contentcalendar;

import com.javaconcepts.contentcalendar.config.ContentCalendarProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import java.util.LinkedHashMap;
import java.util.Map;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class ContentCalendarApplication implements CommandLineRunner {
    private final Environment env;

    public ContentCalendarApplication(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) {
        SpringApplication.run(ContentCalendarApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("All properties:");
        for (String profile : env.getActiveProfiles()) {
            System.out.println("Active Profile: " + profile);
        }
        System.out.println("================================");

        if (env instanceof ConfigurableEnvironment configurableEnvironment) {
            Map<String, Object> properties = new LinkedHashMap<>();
            for (PropertySource<?> propertySource : configurableEnvironment.getPropertySources()) {
                if (propertySource.getSource() instanceof Map<?, ?> sourceMap) {
                    for (Map.Entry<?, ?> entry : sourceMap.entrySet()) {
                        properties.put(entry.getKey().toString(), entry.getValue());
                    }
                }
            }

            properties.forEach((key, value) -> System.out.println(key + " = " + value));
        }
    }
}

