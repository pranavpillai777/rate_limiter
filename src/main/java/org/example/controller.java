package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // Sets a base path for cleaner URLs
public class controller {

    @Autowired
    private service s1;


    @PostMapping
    public String createUser(@RequestBody User user) {
        s1.createuser(user);
        return "User created successfully inside the ArrayList!";
    }


    @PutMapping("/{id}")
    public String updateUser(@RequestBody User user, @PathVariable int id) {
        boolean updated = s1.updateuser(user.getName(),user.getAge(),user.getId(), id);
        if (updated) {
            return "User with ID " + id + " successfully updated!";
        }
        return "Update failed: User ID not found.";
    }

    @GetMapping("/{id}")
    public User readUser(@PathVariable int id) {
        return s1.readuser(id);
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        boolean deleted = s1.deleteuser(id);
        if (deleted) {
            return "User with ID " + id + " has been deleted.";
        }
        return "Delete failed: User ID not found.";
    }
}