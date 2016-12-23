package multiannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by long.yl
 * Created in 2016/12/7
 * Created on Basara_multiannotation
 */
@Component
@ComponentScan("multiannotation")
@EnableAspectJAutoProxy
public class Config {
}
