package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends IGenericRepository<User>{
    public Optional<User> getByUsername(String username);

}
