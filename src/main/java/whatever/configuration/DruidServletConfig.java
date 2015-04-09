package whatever.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lijc on 15/4/8.
 */
@Configuration
public class DruidServletConfig extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DruidServletConfig.class);
    }

    @Bean
    public StatViewServlet druidServlet(){
        return new StatViewServlet();
    }

    @Bean
    public ServletRegistrationBean druidServletRegistration(){
        ServletRegistrationBean registration = new ServletRegistrationBean(druidServlet());
        registration.addUrlMappings("/druid/*");
        return registration;
    }
}
