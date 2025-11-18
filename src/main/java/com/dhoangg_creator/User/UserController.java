// the logic that you have been taking in writing has been taken from a tutorial and you need to be able to do the logic and take out the Spring Boot aspect from the below

// below is also a CRUD service which needs to be fleshed out and put into practice for when you do EDA / CQRS
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userService;
    }
}
