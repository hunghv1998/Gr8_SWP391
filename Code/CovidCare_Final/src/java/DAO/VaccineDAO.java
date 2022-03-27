/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Vaccine;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class VaccineDAO extends DBContext{
    public ArrayList<Vaccine> getListVaccine(){
        ArrayList<Vaccine> listVaccine = new ArrayList<>();
        try{
            String sql = "select * from Vaccines";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Vaccine v = new Vaccine();
                v.setVaccId(rs.getInt("vaccId"));
                v.setVaccName(rs.getString("vaccName"));
                listVaccine.add(v);
            }
            return listVaccine;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
