package teampixl.com.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teampixl.com.models.Users;
import teampixl.com.models.UsersDTO;
import teampixl.com.services.UsersService;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "Endpoints for managing users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UsersDTO usersDTO) {
        Users user = new Users(
                usersDTO.getFirstName(),
                usersDTO.getLastName(),
                usersDTO.getUsername(),
                usersDTO.getPassword(),
                usersDTO.getEmail(),
                usersDTO.getRole()
        );
        Users createdUser = usersService.createUser(user);
        return ResponseEntity.ok(createdUser.toMap());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by ID")
    public ResponseEntity<Map<String, Object>> getUser(@PathVariable String id) {
        Users user = usersService.getUser(id);
        return ResponseEntity.ok(user.toMap());
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public ResponseEntity<Collection<Map<String, Object>>> getAllUsers() {
        Collection<Users> users = usersService.getAllUsers();
        Collection<Map<String, Object>> result = users.stream()
                .map(Users::toMap)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a user by ID")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable String id, @RequestBody UsersDTO usersDTO) {
        Users updatedUser = usersService.updateUser(id, usersDTO);
        return ResponseEntity.ok(updatedUser.toMap());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user by ID")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

