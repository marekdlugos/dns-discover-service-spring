package entity;

import dns.discover.service.model.Project;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relationships
    //    @OneToMany(mappedBy = "user")
    //    private Set<Project> projects = new HashSet<>();
    //
    //    public Set<Project> getProjects() {
    //        return projects;
    //    }

    private String name;
    private String email;
    private String password;
    private String salt;
    private Date created_at;
    private Date updated_at;

    // Constructor
    public User(String name, String email, String password, String salt, String profile_pic, Date created_at, Date updated_at) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    /**
     * User Constructor for JPA only
     */
    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
