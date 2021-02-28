package com.ilab.login.service;

public interface UserService {

    String login(String username, String password);

    String save(String username, String password);
}
