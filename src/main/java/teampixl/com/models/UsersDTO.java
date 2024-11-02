package teampixl.com.models;

import teampixl.com.models.Users.UserRole;


/*=========================================================================================================================================
TO-DO:
- Create database transactions to POSTGRES.
- Implement Datastore, DatabaseManager, and DatabaseHelper

RESEARCH:
- Access caching and pooled systems. I.e. Postgres <-> Access API <-> Metadata Service <-> Router <-> Web Server <-> User.

==========================================================================================================================================*/
public class UsersDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private UserRole role;

    public UsersDTO() {}

    public UsersDTO(String firstName, String lastName, String username, String password, String email, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
}
