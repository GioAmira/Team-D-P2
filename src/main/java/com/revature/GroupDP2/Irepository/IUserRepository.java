package com.revature.GroupDP2.Irepository;

import org.apache.catalina.User;

import java.util.List;

public interface IUserRepository extends IGenericRepository{
    public User getByUsername(String username);

}