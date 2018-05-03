/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aleks
 */
@Entity
@Table(name = "projects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projects.findAll", query = "SELECT p FROM Projects p")
    , @NamedQuery(name = "Projects.findByProjectID", query = "SELECT p FROM Projects p WHERE p.projectID = :projectID")
    , @NamedQuery(name = "Projects.findByName", query = "SELECT p FROM Projects p WHERE p.name = :name")
    , @NamedQuery(name = "Projects.findByDescription", query = "SELECT p FROM Projects p WHERE p.description = :description")
    , @NamedQuery(name = "Projects.findByProjectOwner", query = "SELECT p FROM Projects p WHERE p.projectOwner = :projectOwner")
    , @NamedQuery(name = "Projects.findByAssignee", query = "SELECT p FROM Projects p WHERE p.assignee = :assignee")
    , @NamedQuery(name = "Projects.findByTotalEstimatedHours", query = "SELECT p FROM Projects p WHERE p.totalEstimatedHours = :totalEstimatedHours")
    , @NamedQuery(name = "Projects.findByTotalWorkedHours", query = "SELECT p FROM Projects p WHERE p.totalWorkedHours = :totalWorkedHours")
    , @NamedQuery(name = "Projects.findByCostProjection", query = "SELECT p FROM Projects p WHERE p.costProjection = :costProjection")})
public class Projects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProjectID")
    private Integer projectID;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Size(max = 400)
    @Column(name = "Description")
    private String description;
    @Column(name = "ProjectOwner")
    private Integer projectOwner;
    @Size(max = 45)
    @Column(name = "Assignee")
    private String assignee;
    @Column(name = "TotalEstimatedHours")
    private Integer totalEstimatedHours;
    @Column(name = "TotalWorkedHours")
    private Integer totalWorkedHours;
    @Column(name = "CostProjection")
    private Integer costProjection;

    public Projects() {
    }

    public Projects(Integer projectID) {
        this.projectID = projectID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
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

    public Integer getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(Integer projectOwner) {
        this.projectOwner = projectOwner;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Integer getTotalEstimatedHours() {
        return totalEstimatedHours;
    }

    public void setTotalEstimatedHours(Integer totalEstimatedHours) {
        this.totalEstimatedHours = totalEstimatedHours;
    }

    public Integer getTotalWorkedHours() {
        return totalWorkedHours;
    }

    public void setTotalWorkedHours(Integer totalWorkedHours) {
        this.totalWorkedHours = totalWorkedHours;
    }

    public Integer getCostProjection() {
        return costProjection;
    }

    public void setCostProjection(Integer costProjection) {
        this.costProjection = costProjection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectID != null ? projectID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projects)) {
            return false;
        }
        Projects other = (Projects) object;
        if ((this.projectID == null && other.projectID != null) || (this.projectID != null && !this.projectID.equals(other.projectID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Projects[ projectID=" + projectID + " ]";
    }
    
}
