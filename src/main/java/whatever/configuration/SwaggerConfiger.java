package whatever.configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lijc on 15/4/4.
 */
@Configuration
@EnableAutoConfiguration

public class SwaggerConfiger {
    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    // Don't forget the @Bean annotation
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
                apiInfo()).includePatterns(".*?").swaggerGroup("my-group");
    }
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "8mm API",
                "API for 8mm",
                "8mm API terms of service",
                "lijc1990@yeah.net",
                null,
                null);
        return apiInfo;
    }
}
