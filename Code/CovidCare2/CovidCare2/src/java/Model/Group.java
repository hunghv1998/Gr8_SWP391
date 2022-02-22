/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Group {
    private static final long serialVersionUID = 1L;
    
    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", name=" + name + ", listFeature=" + listFeature.toString() + '}';
    }

    private int id;
    private String name;
    private ArrayList<Feature> listFeature = new ArrayList<>();

    public Group() {
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Feature> getListFeature() {
        return listFeature;
    }

    public void setListFeature(ArrayList<Feature> listFeature) {
        this.listFeature = listFeature;
    }

}
