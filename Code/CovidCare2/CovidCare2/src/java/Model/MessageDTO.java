/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author chinh
 */
public class MessageDTO {
    private String sentBy;
    private Integer fromId;
    private Integer toId;
    private String message;
    private Timestamp messageDate;
    private Integer readState;

    public MessageDTO() {
    }
    
    public MessageDTO(String sentBy, Integer fromId, Integer toId, String message, Timestamp messageDate, Integer readState) {
        this.sentBy = sentBy;
        this.fromId = fromId;
        this.toId = toId;
        this.message = message;
        this.messageDate = messageDate;
        this.readState = readState;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Timestamp messageDate) {
        this.messageDate = messageDate;
    }

    public Integer getReadState() {
        return readState;
    }

    public void setReadState(Integer readState) {
        this.readState = readState;
    }
}
