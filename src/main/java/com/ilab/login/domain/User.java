package com.ilab.login.domain;

import com.ilab.login.domain.base.BaseEntity;
import com.sun.istack.NotNull;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;

@Entity
@Where(clause = BaseEntity.SOFT_DELETE_CLAUSE)
public class User extends BaseEntity{

    @NotNull
    private String username;
    @NotNull
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
