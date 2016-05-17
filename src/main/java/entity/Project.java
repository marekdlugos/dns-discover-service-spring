package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @JsonIgnore
    @ManyToOne
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Date created_at;
    private Date updated_at;

    // Relationships
//    @OneToMany(mappedBy = "dns_records")
//    private Set<DNSRecord> dns_records = new HashSet<>();
//
//    public Set<DNSRecord> getDns_records() {
//        return dns_records;
//    }
//
//    @OneToMany(mappedBy = "xfr_records")
//    private Set<XFRRecord> xfrRecords = new HashSet<>();
//
//    public Set<XFRRecord> getXfr_records() {
//        return xfrRecords;
//    }

    /**
     * Project Constructor
     * @param name          Name of the project
     * @param description   Description of the project
     * @param created_at    Date and Time when the project was created
     * @param updated_at    Date and Time when the project was updated
     */
    public Project(String name, String description, Date created_at, Date updated_at) {
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

    // Getters and Setters
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
}
