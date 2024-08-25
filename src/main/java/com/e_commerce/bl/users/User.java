package com.e_commerce.bl.users;

import java.io.Serializable;

/**
 * Created by Pini Shlomi At 19/08/2024
 */
public abstract class User implements Serializable {
    private final String userName;
    private final String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "username: " + userName + " password: " + password;
    }

}
