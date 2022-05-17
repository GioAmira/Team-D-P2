package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.User;

import java.util.Optional;

public interface UserRepo {
    Optional<User> getByUsername(String username);
}
