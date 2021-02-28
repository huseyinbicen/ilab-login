package com.ilab.login.service.impl;

import com.ilab.login.domain.User;
import com.ilab.login.repository.UserRepository;
import com.ilab.login.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.logger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(String username, String password) {
        User user = userRepository.findUserByUsernameAndPassword(username, password);
        return user == null ? "YANLIŞ" : "DOĞRU";
    }

    @Override
    public String save(String username, String password) {
        String response = StringUtils.EMPTY;
        try {
            if (StringUtils.isEmpty(username))
                return "Username is blank";
            if (StringUtils.isEmpty(password))
                return "password is blank";
            if (userRepository.findUserByUsername(username) != null)
                return "Username already Exist";

            User user = new User(username, password);
            user = userRepository.save(user);
            response = "User saved id = " + user.getId();
        } catch (Exception e) {
            LOGGER.error("USER INFO CANNOT SAVED", e);
        }
        return response;
    }
}
