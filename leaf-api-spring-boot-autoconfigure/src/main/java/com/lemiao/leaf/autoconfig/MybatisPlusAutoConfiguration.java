package com.lemiao.leaf.autoconfig;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.lemiao.leaf.api.LeafApi;
import com.lemiao.leaf.mybatisplus.LeafIdentifierGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Mybatis-plus ID生成器配置类
 *
 * @author lzs
 * @date 2020年08月01日 下午1:06
 */
@Configuration
@Import(LeafAutoConfiguration.class)
public class MybatisPlusAutoConfiguration {

    /**
     * 使用leaf生成ID
     *
     * @return leaf ID生成器
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(MybatisConfiguration.class)
    public IdentifierGenerator identifierGenerator(LeafApi leafApi) {
        return new LeafIdentifierGenerator(leafApi);
    }

}
