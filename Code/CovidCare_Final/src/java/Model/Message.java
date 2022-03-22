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
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer messageId;
    private Integer fromId;
    private Integer toId;
    private String message;
    private Timestamp messageDate;
    private Integer readState;

    public Message() {
    }

    public Message(Integer messageId, Integer fromId, Integer toId, String message, Timestamp messageDate, Integer readState) {
        this.messageId = messageId;
        this.fromId = fromId;
        this.toId = toId;
        this.message = message;
        this.messageDate = messageDate;
        this.readState = readState;
    }

    public Message(Integer fromId, Integer toId, String message, Timestamp messageDate, Integer readState) {
        this.fromId = fromId;
        this.toId = toId;
        this.message = message;
        this.messageDate = messageDate;
        this.readState = readState;
    }

    public Message(Integer fromId, Integer toId, String message) {
        this.fromId = fromId;
        this.toId = toId;
        this.message = message;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
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
