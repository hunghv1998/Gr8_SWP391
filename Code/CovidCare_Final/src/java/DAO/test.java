/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.PostVaccinate;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class test {
    public static void main(String[] args) {
        PostVaccineDAO pD = new PostVaccineDAO();
        ArrayList<PostVaccinate> pv = pD.getListPostVaccinate(3);
        
        PostVaccinate p = pD.getPostById(7);
        System.out.println(p.toString());
    }
    
}
