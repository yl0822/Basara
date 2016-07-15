package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author long.yl.
 * @Date 2016/6/2
 */
@Configuration
public class Config {

    @Bean(initMethod = "init")
    public Student student() {
        return new Student("yl0822", 26);
    }
}
