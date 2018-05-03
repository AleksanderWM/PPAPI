/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aleks
 */
@Embeddable
public class UsertasksPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "userID")
    private String userID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taskID")
    private int taskID;

    public UsertasksPK() {
    }

    public UsertasksPK(String userID, int taskID) {
        this.userID = userID;
        this.taskID = taskID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        hash += (int) taskID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsertasksPK)) {
            return false;
        }
        UsertasksPK other = (UsertasksPK) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        if (this.taskID != other.taskID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UsertasksPK[ userID=" + userID + ", taskID=" + taskID + " ]";
    }
    
}
