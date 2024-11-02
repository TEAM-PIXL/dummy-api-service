package teampixl.com.services;

import org.springframework.stereotype.Service;
import teampixl.com.models.Users;
import teampixl.com.models.UsersDTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsersService {

    private final Map<String, Users> usersMap = new HashMap<>();

    public UsersService() {
        Users user1 = new Users("John", "Doe", "johndoe", "password123", "john.doe@example.com", Users.UserRole.WAITER);
        Users user2 = new Users("Jane", "Smith", "janesmith", "password123", "jane.smith@example.com", Users.UserRole.ADMIN);
        usersMap.put("1", user1);
        usersMap.put("2", user2);
    }

    public Users createUser(Users user) {
        String userId = (String) user.getMetadataValue("id");
        usersMap.put(userId, user);
        return user;
    }

    public Users getUser(String id) {
        Users user = usersMap.get(id);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }

    public Collection<Users> getAllUsers() {
        return usersMap.values();
    }

    public Users updateUser(String id, UsersDTO usersDTO) {
        Users user = usersMap.get(id);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.updateMetadata("first_name", usersDTO.getFirstName());
        user.updateMetadata("last_name", usersDTO.getLastName());
        user.updateMetadata("username", usersDTO.getUsername());
        user.updateMetadata("role", usersDTO.getRole());
        user.updateMetadata("updated_at", System.currentTimeMillis());
        user.setDataValue("password", usersDTO.getPassword());
        user.setDataValue("email", usersDTO.getEmail());
        return user;
    }

    public void deleteUser(String id) {
        usersMap.remove(id);
    }
}

