package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") 
public class controller {

    @Autowired
    private service s1;


    @PostMapping
    public String createUser(@RequestBody User user)
    {
        if(s1.isallowed()==true){
            s1.createuser(user);
            return "User created successfully inside the ArrayList!";
        }
        return "error";
    }


    @PutMapping("/{id}")
    public String updateUser(@RequestBody User user, @PathVariable int id) {
        if (s1.isallowed() == true) {
            s1.updateuser(user.getName(), user.getAge(), user.getId(), id);
            return "User updated successfully inside the ArrayList!";
        }
        return "error";
    }

    @GetMapping("/{id}")
    public User readUser(@PathVariable int id) {
        if(s1.isallowed()==true){
            return s1.readuser(id);
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        if(s1.isallowed()==true){
            s1.deleteuser(id);
            return "User with ID " + id + " has been deleted.";
        }
        return "User with ID " + id + " has been deleted.";
    }
}