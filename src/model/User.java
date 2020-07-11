/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class User {
    private int user_ID;
    private String user_name;
    private String user_password;
    private Date user_create_at;
    private String user_permission;

    public int getUser_ID() {
        return user_ID;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public Date getUser_create_at() {
        return user_create_at;
    }

    public String getUser_permission() {
        return user_permission;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_create_at(Date user_create_at) {
        this.user_create_at = user_create_at;
    }

    public void setUser_permission(String user_permission) {
        this.user_permission = user_permission;
    }
    
    
}
