package cvut.ear.dns.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ParticipationId implements Serializable{

    private Long userID;
    private Long projectID;

    public ParticipationId(Long userID, Long projectID) {
        this.userID = userID;
        this.projectID = projectID;
    }

    public ParticipationId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipationId that = (ParticipationId) o;

        if (userID != null ? !userID.equals(that.userID) : that.userID != null) return false;
        return projectID != null ? projectID.equals(that.projectID) : that.projectID == null;
    }

    @Override
    public int hashCode() {
        int result = userID != null ? userID.hashCode() : 0;
        result = 31 * result + (projectID != null ? projectID.hashCode() : 0);
        return result;
    }
}
