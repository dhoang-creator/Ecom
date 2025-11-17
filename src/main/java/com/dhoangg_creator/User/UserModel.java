@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull(message = "Invalid User: User is NULL")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Please enter only string")
    private String userName;

    @Email(message = "Invalid email")
    @NotNull(message = "Email cannot be NULL")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    @NotNull(message = "Invalid Phone Number: Number is NULL")
    private String phoneNumber;
}
