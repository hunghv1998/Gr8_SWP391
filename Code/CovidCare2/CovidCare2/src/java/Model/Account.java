/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String userName;
    private String passWord;
    private boolean status;
    private int groupId;
    private Group group;

    @Override
    public String toString() {
        return "Account{" + "userName=" + userName + ", passWord=" + passWord + ", status=" + status + ", groupId=" + groupId + ", group=" + group + ", listGroup=" + listGroup + '}';
    }
    private ArrayList<Group> listGroup = new ArrayList<>();

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
   

    public Account() {
    }
    
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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
