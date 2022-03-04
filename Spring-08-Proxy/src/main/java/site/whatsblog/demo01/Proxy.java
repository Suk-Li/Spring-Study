package site.whatsblog.demo01;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/4 11:03</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
    }
    public void seeHouse(){
        System.out.println("帮你看房~");
    }

    public void contract(){
        System.out.println("帮你签合同~");
    }

    public void fee(){
        System.out.println("收你中介费~");
    }
}
