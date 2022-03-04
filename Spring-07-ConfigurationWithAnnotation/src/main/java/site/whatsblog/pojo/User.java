package site.whatsblog.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/3 17:51</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
@Data
@Component
public class User {
    @Value("Suk")
    private String name;
}
