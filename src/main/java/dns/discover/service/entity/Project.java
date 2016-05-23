package dns.discover.service.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

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

    @Column(nullable = false)
    private String name;
    private String description;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Participation> participations = new ArrayList<Participation>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
    private List<DnsRecord> dnsRecords = new ArrayList<DnsRecord>();

    /**
     * Project Constructor
     *
     * @param name        Name of the project
     * @param description Description of the project
     */
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
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
