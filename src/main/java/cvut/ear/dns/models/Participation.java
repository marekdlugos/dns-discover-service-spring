package cvut.ear.dns.models;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PARTICIPATIONS")
public class Participation {

    @EmbeddedId
    private ParticipationId id;

    @JoinColumn(name = "user_id", referencedColumnName = "userID")
    @Column(insertable = false, updatable = false)
    private Long userID;

    @JoinColumn(name = "project_id", referencedColumnName = "projectID")
    @Column(insertable = false, updatable = false)
    private Long projectID;

    @JoinColumn(name = "permission_name", referencedColumnName = "name")
    private Permission permissions;


    public Participation(Long userID, Long projectID, Permission permissions) {
        this.id = new ParticipationId(userID, projectID);
        this.userID = userID;
        this.projectID = projectID;
        this.permissions = permissions;
    }

    public Participation() {
    }


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    public Permission getPermissions() {
        return permissions;
    }

    public void setPermissions(Permission permissions) {
        this.permissions = permissions;
    }

    public ParticipationId getId() {
        return id;
    }

    public void setId(ParticipationId id) {
        this.id = id;
    }
}