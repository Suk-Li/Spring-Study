package site.whatsblog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import site.whatsblog.pojo.User;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/3 17:52</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
@Configuration
@ComponentScan("site.whatsblog")
public class AppConfig {
    @Bean
    public User getUser(){
        return new User();
    }
}
