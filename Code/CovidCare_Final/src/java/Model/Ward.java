/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author chinh
 */
public class Ward implements Serializable {

    private static final long serialVersionUID = 1L;

    private String wardId;
    private String wardName;
    private String stateId;

    public Ward() {
    }

    public Ward(String wardId, String wardName, String stateId) {
        this.wardId = wardId;
        this.wardName = wardName;
        this.stateId = stateId;
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }
}
