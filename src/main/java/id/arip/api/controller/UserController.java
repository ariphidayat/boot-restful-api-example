package id.arip.api.controller;

import id.arip.api.exception.ResourceNotFoundException;
import id.arip.api.model.User;
import id.arip.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User inputUser, @PathVariable("id") int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("User not found with id: " + id)));

        user.setName(inputUser.getName());
        user.setEmail(inputUser.getEmail());
        user.setPassword(inputUser.getPassword());

        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

}
