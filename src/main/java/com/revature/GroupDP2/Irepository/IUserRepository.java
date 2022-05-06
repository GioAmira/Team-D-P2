package com.revature.GroupDP2.Irepository;

import org.apache.catalina.User;

import java.util.List;

public interface IUserRepository extends IGenericRepository{
    public List<User> getByName(String fName, String lName);
    public User getByUsername(String username);

}
