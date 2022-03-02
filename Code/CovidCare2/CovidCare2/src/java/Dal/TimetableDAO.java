/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.TimetableEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chinh
 */
public class TimetableDAO extends DBContext {
    public ArrayList<TimetableEvent> getTimetable() {
        ArrayList<TimetableEvent> timetable = new ArrayList<>();
        
        String sql = "SELECT * FROM patient_timetable";
        
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                TimetableEvent e = new TimetableEvent();
                e.setTitle(rs.getString("action"));
                e.setStart(rs.getDate("time"));
                e.setEnd(rs.getDate("time"));
                e.setText(rs.getString("userId") + " " + rs.getString("action"));
                e.setAllDay(false);
                e.setUsername("");
                timetable.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return timetable;
    }
}
