/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aleks
 */
@Entity
@Table(name = "usertasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertasks.findAll", query = "SELECT u FROM Usertasks u")
    , @NamedQuery(name = "Usertasks.findByUserID", query = "SELECT u FROM Usertasks u WHERE u.usertasksPK.userID = :userID")
    , @NamedQuery(name = "Usertasks.findByTaskID", query = "SELECT u FROM Usertasks u WHERE u.usertasksPK.taskID = :taskID")
    , @NamedQuery(name = "Usertasks.findByRoles", query = "SELECT u FROM Usertasks u WHERE u.roles = :roles")})
public class Usertasks implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsertasksPK usertasksPK;
    @Size(max = 45)
    @Column(name = "roles")
    private String roles;
    @JoinColumn(name = "taskID", referencedColumnName = "TaskID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tasks tasks;
    @JoinColumn(name = "userID", referencedColumnName = "UserID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Usertasks() {
    }

    public Usertasks(UsertasksPK usertasksPK) {
        this.usertasksPK = usertasksPK;
    }

    public Usertasks(String userID, int taskID) {
        this.usertasksPK = new UsertasksPK(userID, taskID);
    }

    public UsertasksPK getUsertasksPK() {
        return usertasksPK;
    }

    public void setUsertasksPK(UsertasksPK usertasksPK) {
        this.usertasksPK = usertasksPK;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usertasksPK != null ? usertasksPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertasks)) {
            return false;
        }
        Usertasks other = (Usertasks) object;
        if ((this.usertasksPK == null && other.usertasksPK != null) || (this.usertasksPK != null && !this.usertasksPK.equals(other.usertasksPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usertasks[ usertasksPK=" + usertasksPK + " ]";
    }
    
}
