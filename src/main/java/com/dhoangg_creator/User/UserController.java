// the logic that you have been taking in writing has been taken from a tutorial and you need to be able to do the logic and take out the Spring Boot aspect from the below

// below is also a CRUD service which needs to be fleshed out and put into practice for when you do EDA / CQRS
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<Response> add(@Valid @RequestBody User user) {
        try {
            userService.addUser(user);
            return new ResponseEntity<>(new Response("User added Successfully", Boolean.TRUE),
                HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage(), Boolean.FALSE), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Response> get() {
        try {
            userService.getUser();
            return new ResponseEntity<>(new Response("Users", Boolean.TRUE),
                HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage(), Boolean.FALSE), HttpStatus.BAD_REQUEST);
        }
    }

    // there is some difficulty with the below update path variable since it doesn't follow conventions
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> update(@PathVariable("id"), Long userId, User user) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>(new Response("Users deleted successfully", Boolean.TRUE),
                HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage(), Boolean.FALSE), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> update(@PathVariable("id"), Long userId, User user) {
        try {
            userService.updateUser(userId, user);
            return new ResponseEntity<>(new Response("Users updated successfully", Boolean.TRUE),
                HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage(), Boolean.FALSE), HttpStatus.BAD_REQUEST);
        }
    }
}
