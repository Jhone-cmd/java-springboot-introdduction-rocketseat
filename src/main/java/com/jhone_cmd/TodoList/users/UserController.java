package com.jhone_cmd.TodoList.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public UserModel createUser(@RequestBody UserModel userModel) {

        var emailExists = this.userRepository.findByEmail(userModel.getEmail());
        if (emailExists != null) {
            System.out.println("Email already exists");
            return null;
        }

        var userCreated = this.userRepository.save(userModel);
        return userCreated;
    }

}
