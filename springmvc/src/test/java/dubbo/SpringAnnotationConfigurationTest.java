package dubbo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author long.yl.
 * @Date 2016/3/18
 */
@Configuration
public class SpringAnnotationConfigurationTest {

    @Bean
    public Hibernate hibernate(){
        return new Hibernate();
    }

}
class Hibernate{

    @Override
    public String toString() {
        return "Hibernate{}";
    }
}
