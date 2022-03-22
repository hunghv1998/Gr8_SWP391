/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author User
 */
public class TimetableEvent {

    private int id;
    private String title;
    private Timestamp start;
    private Timestamp end;
    private String text;
    private boolean allDay;
    private boolean progress;
    private int creator;
    private int assignee;

    public TimetableEvent() {
    }

    public TimetableEvent(int id, String title, Timestamp start, Timestamp end, String text, boolean allDay, boolean progress, int creator, int assignee) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.text = text;
        this.allDay = allDay;
        this.progress = progress;
        this.creator = creator;
        this.assignee = assignee;
    }

    public TimetableEvent(String title, Timestamp start, Timestamp end, String text, boolean allDay, boolean progress, int creator, int assignee) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.text = text;
        this.allDay = allDay;
        this.progress = progress;
        this.creator = creator;
        this.assignee = assignee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public boolean isProgress() {
        return progress;
    }

    public void setProgress(boolean progress) {
        this.progress = progress;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public int getAssignee() {
        return assignee;
    }

    public void setAssignee(int assignee) {
        this.assignee = assignee;
    }

}
