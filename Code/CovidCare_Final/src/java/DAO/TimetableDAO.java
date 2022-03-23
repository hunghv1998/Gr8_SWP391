/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.TimetableEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class TimetableDAO extends DBContext {

    public TimetableEvent getEventDetail(int id) {
        String sql = "SELECT * FROM Timetable WHERE id=" + id;

        ResultSet rs = getData(sql);

        try {
            if (rs.next()) {
                TimetableEvent e = new TimetableEvent();
                e.setId(rs.getInt("id"));
                e.setTitle(rs.getString("title"));
                e.setStart(rs.getTimestamp("startTime"));
                e.setEnd(rs.getTimestamp("endTime"));
                e.setText(rs.getString("detail"));
                e.setAllDay(rs.getBoolean("allDay"));
                e.setProgress(rs.getBoolean("progress"));
                e.setCreator(rs.getInt("creator"));
                e.setAssignee(rs.getInt("assignee"));

                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimetableEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<TimetableEvent> getHospitaTimetable(int creator) {
        ArrayList<TimetableEvent> timetable = new ArrayList<>();

        String sql = "SELECT * FROM Timetable WHERE creator=" + creator;

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                TimetableEvent e = new TimetableEvent();
                e.setId(rs.getInt("id"));
                e.setTitle(rs.getString("title"));
                e.setStart(rs.getTimestamp("startTime"));
                e.setEnd(rs.getTimestamp("endTime"));
                e.setText(rs.getString("detail"));
                e.setAllDay(rs.getBoolean("allDay"));
                e.setProgress(rs.getBoolean("progress"));
                e.setCreator(rs.getInt("creator"));
                e.setAssignee(rs.getInt("assignee"));
                timetable.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimetableEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timetable;
    }

    public ArrayList<TimetableEvent> getPatientTimetable(int assignee) {
        ArrayList<TimetableEvent> timetable = new ArrayList<>();

        String sql = "SELECT * FROM Timetable WHERE assignee=" + assignee;

        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                TimetableEvent e = new TimetableEvent();
                e.setId(rs.getInt("id"));
                e.setTitle(rs.getString("title"));
                e.setStart(rs.getTimestamp("startTime"));
                e.setEnd(rs.getTimestamp("endTime"));
                e.setText(rs.getString("detail"));
                e.setAllDay(rs.getBoolean("allDay"));
                e.setProgress(rs.getBoolean("progress"));
                e.setCreator(rs.getInt("creator"));
                e.setAssignee(rs.getInt("assignee"));
                timetable.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimetableEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timetable;
    }

    public void createEvent(TimetableEvent e) {

        try {
            String sql = "INSERT INTO Timetable(title, startTime, endTime, detail, allDay, progress, creator, assignee) "
                    + "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, e.getTitle());
            stm.setTimestamp(2, e.getStart());
            stm.setTimestamp(3, e.getEnd());
            stm.setString(4, e.getText());
            stm.setBoolean(5, e.isAllDay());
            stm.setBoolean(6, e.isProgress());
            stm.setInt(7, e.getCreator());
            stm.setInt(8, e.getAssignee());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TimetableEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEvent(TimetableEvent event) {
        String sql = "UPDATE Timetable SET "
                + "title=?, "
                + "startTime=?, "
                + "endTime=?, "
                + "detail=?, "
                + "allDay=?, "
                + "progress=?, "
                + "creator=?, "
                + "assignee=? WHERE id=?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setString(1, event.getTitle());
            pre.setTimestamp(2, event.getStart());
            pre.setTimestamp(3, event.getEnd());
            pre.setString(4, event.getText());
            pre.setBoolean(5, event.isAllDay());
            pre.setBoolean(6, event.isProgress());
            pre.setInt(7, event.getCreator());
            pre.setInt(8, event.getAssignee());
            pre.setInt(9, event.getId());

            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TimetableEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteEvent(int id) {
        String sql = "DELETE FROM Timetable WHERE id=" + id;

        try {
            PreparedStatement pre = connection.prepareStatement(sql);

            return (pre.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(TimetableEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
