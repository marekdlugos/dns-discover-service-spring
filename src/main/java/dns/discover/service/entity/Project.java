package dns.discover.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_id")
    private Long id;

    private String name;
    private String description;
    private Date created_at;
    private Date updated_at;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Participation> participations = new ArrayList<Participation>();

    @OneToMany(mappedBy = "project")
    private List<DnsRecord> dnsRecords = new ArrayList<DnsRecord>();

    /**
     * Project Constructor
     *
     * @param name        Name of the project
     * @param description Description of the project
     * @param created_at  Date and Time when the project was created
     * @param updated_at  Date and Time when the project was updated
     */
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    /**
     * Project Constructor for JPA only
     */
    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public List<DnsRecord> getDnsRecords() {
        return dnsRecords;
    }

    public void setDnsRecords(List<DnsRecord> dnsRecords) {
        this.dnsRecords = dnsRecords;
    }
}
