package site.whatsblog.demo02;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/4 11:17</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class UserServiceProxy implements UserService{
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public UserServiceProxy() {
    }

    public UserServiceProxy(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("query");
        userService.add();
    }

    @Override
    public void update() {
        log("query");
        userService.update();
    }

    @Override
    public void delete() {
        log("query");
        userService.delete();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }
    public void log(String message){
        System.out.println("使用了"+message+"方法~");
    }
}
