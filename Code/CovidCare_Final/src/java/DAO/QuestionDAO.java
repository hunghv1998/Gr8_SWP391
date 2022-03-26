/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DBContext;
import Model.User;
import Model.Question;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class QuestionDAO extends DBContext {

    public ArrayList<Question> getAllQuestion() {
        String sql = "Select * from Question";
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Question> listQues = new ArrayList<>();

        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int ques_id = rs.getInt("id");
                String ques_content = rs.getString("content");
                listQues.add(new Question(ques_id, ques_content));
            }
            return listQues;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public void addNewAnswer(int userId, int questId, String answer) {
        String sql = "INSERT INTO [dbo].[AccountQuestion]\n"
                + "           ([userId]\n"
                + "           ,[secretQuestionId]\n"
                + "           ,[answer])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Question> listQues = new ArrayList<>();

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, questId);
            stm.setString(3, answer);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public boolean checkingAccountAnswer(int userId, int questId, String answer) {
        boolean result;
        String sql = "select * from [AccountQuestion]\n"
                + "where userId=? AND secretQuestionId=? AND answer=?";
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, questId);
            stm.setString(3, answer);
            rs = stm.executeQuery();

            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

}
