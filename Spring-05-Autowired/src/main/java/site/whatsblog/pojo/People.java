package site.whatsblog.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/3 16:49</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
@Data

public class People {
    @Resource
    private Cat cat1;
    @Resource(name = "dog2")
    private Dog dog1;
    private String name;

}
