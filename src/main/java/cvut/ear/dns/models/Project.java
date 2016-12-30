package cvut.ear.dns.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub on 30.12.2016.
 */
@Entity
@Table(name = "PROJECTS")
public class Project{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
    private List<DnsRecord> dnsRecords = new ArrayList<>();

    public Project() {
    }

    public Project(String name, String description, List<DnsRecord> dnsRecords) {
        this.name = name;
        this.description = description;
        this.dnsRecords = dnsRecords;
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

    public List<DnsRecord> getDnsRecords() {
        return dnsRecords;
    }

    public void setDnsRecords(List<DnsRecord> dnsRecords) {
        this.dnsRecords = dnsRecords;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dnsRecords=" + dnsRecords +
                '}';
    }
}
