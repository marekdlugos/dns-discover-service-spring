package sit.fel.cvut.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "xfr_table")
public class XFRRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zone;
    private String client;
    private Date created_at;
    private Date updated_at;

    public XFRRecord(String zone, String client, Date created_at, Date updated_at) {
        this.zone = zone;
        this.client = client;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    /**
     * XFR Record Constructor for JPA only
     */
    public XFRRecord(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
