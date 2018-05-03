/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aleks
 */
@Entity
@Table(name = "tasks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t")
    , @NamedQuery(name = "Tasks.findByTaskID", query = "SELECT t FROM Tasks t WHERE t.taskID = :taskID")
    , @NamedQuery(name = "Tasks.findByProjectID", query = "SELECT t FROM Tasks t WHERE t.projectID = :projectID")
    , @NamedQuery(name = "Tasks.findByEstimatedHours", query = "SELECT t FROM Tasks t WHERE t.estimatedHours = :estimatedHours")
    , @NamedQuery(name = "Tasks.findByWorkedHours", query = "SELECT t FROM Tasks t WHERE t.workedHours = :workedHours")
    , @NamedQuery(name = "Tasks.findByLog", query = "SELECT t FROM Tasks t WHERE t.log = :log")
    , @NamedQuery(name = "Tasks.findByImpact", query = "SELECT t FROM Tasks t WHERE t.impact = :impact")
    , @NamedQuery(name = "Tasks.findByCriticality", query = "SELECT t FROM Tasks t WHERE t.criticality = :criticality")
    , @NamedQuery(name = "Tasks.findByImportance", query = "SELECT t FROM Tasks t WHERE t.importance = :importance")
    , @NamedQuery(name = "Tasks.findByDependentTask", query = "SELECT t FROM Tasks t WHERE t.dependentTask = :dependentTask")
    , @NamedQuery(name = "Tasks.findByName", query = "SELECT t FROM Tasks t WHERE t.name = :name")
    , @NamedQuery(name = "Tasks.findByDescription", query = "SELECT t FROM Tasks t WHERE t.description = :description")
    , @NamedQuery(name = "Tasks.findByStatus", query = "SELECT t FROM Tasks t WHERE t.status = :status")})
public class Tasks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TaskID")
    private Integer taskID;
    @Column(name = "ProjectID")
    private Integer projectID;
    @Column(name = "EstimatedHours")
    private Integer estimatedHours;
    @Column(name = "WorkedHours")
    private Integer workedHours;
    @Size(max = 400)
    @Column(name = "Log")
    private String log;
    @Column(name = "Impact")
    private Integer impact;
    @Column(name = "Criticality")
    private Integer criticality;
    @Column(name = "Importance")
    private Integer importance;
    @Column(name = "DependentTask")
    private Integer dependentTask;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Size(max = 400)
    @Column(name = "Description")
    private String description;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tasks")
    private Collection<Usertasks> usertasksCollection;

    public Tasks() {
    }

    public Tasks(Integer taskID) {
        this.taskID = taskID;
    }

    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public Integer getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(Integer estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public Integer getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Integer workedHours) {
        this.workedHours = workedHours;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Integer getImpact() {
        return impact;
    }

    public void setImpact(Integer impact) {
        this.impact = impact;
    }

    public Integer getCriticality() {
        return criticality;
    }

    public void setCriticality(Integer criticality) {
        this.criticality = criticality;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public Integer getDependentTask() {
        return dependentTask;
    }

    public void setDependentTask(Integer dependentTask) {
        this.dependentTask = dependentTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Usertasks> getUsertasksCollection() {
        return usertasksCollection;
    }

    public void setUsertasksCollection(Collection<Usertasks> usertasksCollection) {
        this.usertasksCollection = usertasksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskID != null ? taskID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.taskID == null && other.taskID != null) || (this.taskID != null && !this.taskID.equals(other.taskID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tasks[ taskID=" + taskID + " ]";
    }
    
}
