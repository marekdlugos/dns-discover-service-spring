package cvut.ear.dns.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROJECTS")
public class Project extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;

    @OneToMany(mappedBy = "projectID", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Participation> participations;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DnsRecord> dnsRecords;

    /**
     * Project Constructor
     *
     * @param name        Name of the project
     * @param description Description of the project
     */
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.participations = new ArrayList<>();
        this.dnsRecords = new ArrayList<>();
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