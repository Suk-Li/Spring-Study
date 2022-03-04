package site.whatsblog.diy;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/4 16:38</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class DiyPointCut {
    public void before(){
        System.out.println("======方法执行前=====");
    }
    public void after(){
        System.out.println("======方法执行后=====");
    }
}
