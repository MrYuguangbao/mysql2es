package com.example.mysql2es.controller;

import com.example.mysql2es.model.User;
import com.example.mysql2es.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: admin
 * @Description: 用户控制器
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.controller
 * @CreateTime: 2020-11-07 22:48
 */
@RestController
@RequestMapping(value = "/demo")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/add")
    public String addUser(@RequestParam String name,
                          @RequestParam String email,
                          @RequestParam String tags) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setTags(tags);
        user.setLast_updated(System.currentTimeMillis());
        userRepository.save(user);
        return "Save Success!";
    }

    @PutMapping(value = "/update")
    public String updateUser(@RequestParam Integer id,
                             @RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String tags) {
        User user = userRepository.findById(id).get();
        user.setName(name);
        user.setEmail(email);
        user.setTags(tags);
        user.setLast_updated(System.currentTimeMillis());
        userRepository.save(user);
        return "Update user id:"+id+"success!";
    }

    @DeleteMapping(value = "/delete")
    public String deleteUser(@RequestParam Integer id){
        User user = userRepository.findById(id).get();
        user.setLast_updated(System.currentTimeMillis());
        user.setIs_deleted(true);
        userRepository.save(user);
        return "Delete user id:"+id+"success!";
    }

    @GetMapping(value = "/all")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }


}
