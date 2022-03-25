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
public class ChatRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    private int fromId;
    private int toId;
    private String senderName;
    private String senderPhoto;
    private String lastMessage;
    private Timestamp lastMessageTime;

    public ChatRoom() {
    }

    public ChatRoom(int fromId, int toId, String senderName, String senderPhoto, String lastMessage, Timestamp lastMessageTime) {
        this.fromId = fromId;
        this.toId = toId;
        this.senderName = senderName;
        this.senderPhoto = senderPhoto;
        this.lastMessage = lastMessage;
        this.lastMessageTime = lastMessageTime;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhoto() {
        return senderPhoto;
    }

    public void setSenderPhoto(String senderPhoto) {
        this.senderPhoto = senderPhoto;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Timestamp getLastMessageTime() {
        return lastMessageTime;
    }

    public void setLastMessageTime(Timestamp lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }

}
