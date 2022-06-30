package com.chuwa.mongoDBblog.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName CommonConfig
 * @Description TODO
 * @Author wenhu
 * @Date 6/30/2022 1:44 AM
 * @Version 1.0
 **/
@Configuration
public class CommonConfig {

    //"modelmapper" -> new ModelMapper();
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
