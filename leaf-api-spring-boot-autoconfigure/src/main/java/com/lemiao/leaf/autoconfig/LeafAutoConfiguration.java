package com.lemiao.leaf.autoconfig;

import com.lemiao.leaf.api.LeafApi;
import com.lemiao.leaf.api.RestLeafApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

/**
 * Leaf配置类
 *
 * @author lzs
 * @date 2020年07月29日 下午4:42
 */
@Configuration
@Import(RestTemplateAutoConfiguration.class)
@EnableConfigurationProperties(LeafProperties.class)
public class LeafAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(RestTemplate.class)
    @ConditionalOnProperty(name = "leaf.server.url")
    public LeafApi leafApi(RestTemplate restTemplate, LeafProperties leafProperties) {
        return new RestLeafApi(restTemplate, leafProperties);
    }

}
