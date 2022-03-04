package site.whatsblog.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/3 16:00</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
@Data
public class Student {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbies;
    private Map<String, String> cards;
    private Set<String> games;
    private Properties info;
    private String wife;
}
