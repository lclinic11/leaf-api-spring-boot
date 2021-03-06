package com.lemiao.leaf.autoconfig;

import java.nio.charset.StandardCharsets;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig
 *
 * @author lzs
 * @date 2020年07月29日 下午9:30
 */
@Configuration
@Import(HttpClientAutoConfiguration.class)
public class RestTemplateAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(value = ClientHttpRequestFactory.class)
    public RestTemplate restTemplate(ClientHttpRequestFactory httpRequestFactory) {
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

}
