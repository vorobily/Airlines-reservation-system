package com.example.airlinesreservation.service;

import com.example.airlinesreservation.entity.User;
import com.example.airlinesreservation.exception.UserException;
import com.example.airlinesreservation.login.Login;

import java.util.Collection;

public interface UserService {

    int createUser(User user) throws UserException;

    User fetchUserById(int user_id) throws UserException;

    User validate(Login login);

    Collection<User> fetchAllUsers();

}
