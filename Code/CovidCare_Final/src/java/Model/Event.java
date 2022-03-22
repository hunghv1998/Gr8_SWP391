/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author chinh
 */
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private Timestamp start;
    private Timestamp end;
    private String detail;
    private boolean allDay;
    private int assignorId;
    private int assigneeId;

    public Event() {
    }

    public Event(String title, Timestamp start, Timestamp end, String detail, boolean allDay, int assignorId, int assigneeId) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.detail = detail;
        this.allDay = allDay;
        this.assignorId = assignorId;
        this.assigneeId = assigneeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public int getAssignorId() {
        return assignorId;
    }

    public void setAssignorId(int assignorId) {
        this.assignorId = assignorId;
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(int assigneeId) {
        this.assigneeId = assigneeId;
    }

}
