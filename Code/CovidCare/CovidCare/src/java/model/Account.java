/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Account {
    
    private String userName;
    private String passWord;
    private ArrayList<Group> listGroup = new ArrayList<>();

    public Account() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public ArrayList<Group> getListGroup() {
        return listGroup;
    }

    public void setListGroup(ArrayList<Group> listGroup) {
        this.listGroup = listGroup;
    }

    
    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    
    
   
    
    
    
    
}
