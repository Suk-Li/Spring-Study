package site.whatsblog.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/3 17:36</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
@Component
@Scope("singleton")
@Data
public class User {
    @Value("小Suk呀！")
    private String name;
}
