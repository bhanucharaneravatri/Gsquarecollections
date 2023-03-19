/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.travelsite.model;

import java.time.LocalDate;

/**
 *
 * @author charanbhanu4
 */
public class loginmodel {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    public loginmodel()
    {
        
    }
    public loginmodel(String username) {
        this.userName=username;
    }
    public loginmodel(String userName,String password,String firstName,String lastName,LocalDate dateOfBirth)
        {
            this.userName=userName;
            this.password=password;
            this.dateOfBirth=dateOfBirth;
            this.lastName=lastName;
            this.firstName=firstName;
        }
    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public String getFirstName()
    {
        return this.firstName;
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
        public void setFirstName(String str)
        {
            this.firstName=str;
        }
        public void setPassword(String str)
        {
            this.password=str;
        }
        public void setLastName(String str)
        {
            this.lastName=str;
        }
        public void setDateOfBirth(LocalDate dateOfBirth)
        {
            this.dateOfBirth=dateOfBirth;
        }
        @Override
        public String toString()
        {
            return "username: "+this.userName+" f: "+this.firstName+" l: "+this.lastName+ " p: "+this.password+" d: "+this.dateOfBirth;
        }
        }
