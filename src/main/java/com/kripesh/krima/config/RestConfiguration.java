package com.kripesh.krima.config;

import com.kripesh.krima.property.FileStorageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author kripesh
 *
 */
@Configuration
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class RestConfiguration extends WebMvcConfigurerAdapter {

	//to communicate frontend and backend successfully ever since that both are hosted in different domain
	@Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // you USUALLY want this 
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
