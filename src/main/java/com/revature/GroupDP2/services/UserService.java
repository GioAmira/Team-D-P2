package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
    this.userRepository=userRepository;
    }
    /*
    1. check if username is unique
    2. check if email is valid
    3. check if there is a password
     */
    public Optional<User> register(User user) throws Exception {
        if (userRepository.getByUsername(user.getUserName()).isPresent()) {
            throw new Exception("username already taken!");
        }//email validator. got it online
        if(!user.getEmail().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")){
            throw new Exception("email invalid!");
        }
        userRepository.create(user);
        return Optional.of(user);
    }
    public Optional<User> login(User user) throws Exception{
        Optional<User> oldUser=userRepository.getByUsername(user.getUserName());
        if(oldUser.isPresent()&&oldUser.get().getPassword().equals(user.getPassword())){
            return oldUser;
        }
        throw new Exception("login fail!");
    }
    /*
    1. see if exists
    2.see if password is null
    3.see if email is valid
    4. update
     */
    public Optional<User> edit(User user) throws Exception {
    Optional<User> oldUser=userRepository.getById(user.getId());
    if(oldUser.isPresent()&&user.getPassword()!=null){
        oldUser=Optional.of(user);
        return oldUser;
    }
        throw new Exception("update fail!");
    }
    public User unRegester(User user) throws Exception {
        Optional<User> oldUser =userRepository.getById(user.getId());
        if(oldUser.isPresent()){
            userRepository.delete(oldUser.get());
            return oldUser.get();
        }
        throw new Exception("could not delete!");
    }
}
