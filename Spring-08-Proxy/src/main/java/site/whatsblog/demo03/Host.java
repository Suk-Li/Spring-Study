package site.whatsblog.demo03;

/**
 * <strong>
 * description : 房东
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/4 11:01</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class Host implements Rent {

    @Override
    public void rent() {
        System.out.println("我要出租房子！");
    }
}
