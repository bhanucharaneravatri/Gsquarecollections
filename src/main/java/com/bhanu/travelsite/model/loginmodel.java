/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.travelsite.model;

/**
 *
 * @author charanbhanu4
 */
public class loginmodel {
    private String userName;
    private String password;
    public void loginmodel(String userName,String password)
        {
            this.userName=userName;
            this.password=password;
        }

    public String getUserName()
    {
        return this.userName;
    }
        public String getPassword()
    {
        return this.password;
    }
        public void setUserName(String str)
        {
            this.userName=str;
        }
        public void setPassword(String str)
        {
            this.password=str;
        }
        @Override
        public String toString(){
            return "loginmodel [userName=" + userName + ", password=" + password + "]";
        }
        

}
