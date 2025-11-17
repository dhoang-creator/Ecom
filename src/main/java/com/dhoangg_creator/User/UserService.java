// As we are building out the below service -> think what kind of pattern, we're utilising as we are following the code creation?
// MVC controller looks like first port of call with added repo for DBA
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // builder pattern below
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        User existUserId = userRepository
            .findById(userId)
            .orElseThrow(() ->
                // although the below is a valid return, it doesn't feel intuitive, solider on and alter at a later stage
                new ResourceNotFound(
                    "Employee does not Exist in id : " + userId
                )
            );
        if (existUserId != null) {
            userId.deleteById(userId);
        }
    }

    @Override
    public User updateUser(Long userId, User user) {
        User existUser = userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFound(existUser.getUserName()));
    }
}
