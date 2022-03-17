/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.TimetableEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimetableDAO extends DBContext {

    public ArrayList<TimetableEvent> getTimetable(String username) {
        ArrayList<TimetableEvent> timetable = new ArrayList<>();

        String sql = "SELECT p.username ,p.action, p.start, p.[end] FROM patient_timetable p\n"
                + "Inner join Account a on p.username = a.username\n"
                + "where p.username = '"
                + username + "'";

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                TimetableEvent e = new TimetableEvent();
                e.setTitle(rs.getString("action"));
                e.setStart(rs.getTimestamp("start"));
                e.setEnd(rs.getTimestamp("end"));
                e.setText(rs.getString("username") + " " + rs.getString("action"));
                e.setAllDay(false);
                e.setUsername(rs.getString("username"));
                timetable.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return timetable;
    }

    public void createEvent(TimetableEvent event, String username) {

        try {
            String sql = "INSERT INTO patient_timetable(username ,action, start, [end]) VALUES (?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, event.getTitle());
            stm.setTimestamp(3, event.getStart());
            stm.setTimestamp(4, event.getEnd());
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TimetableEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(TimetableEvent event) {
        try {
            String sql = "UPDATE patient_timetable SET action = ?,\n"
                    + "	start = ?,\n"
                    + "	end = ?,	\n"
                    + "	WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, event.getTitle());
            stm.setTimestamp(2, event.getStart());
            stm.setTimestamp(3, event.getEnd());
            stm.setInt(4, event.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TimetableEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public boolean delete(int id){
        boolean check = true;
        try {
            String sql = "DELETE FROM patient_timetable\n" +
                    "      WHERE id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            check = stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TimetableEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
}
