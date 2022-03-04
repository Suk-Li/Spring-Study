package site.whatsblog.demo01;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/4 11:02</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class Client {
    public static void main(String[] args) {
        // 房东要租房子
        Host host = new Host();
        // 代理，中介要帮房东租房子，但是一般代理角色会有一些附属操作！
        Proxy proxy = new Proxy(host);
        // 你不用找房东，直接找中介就可以了
        proxy.rent();
    }
}
