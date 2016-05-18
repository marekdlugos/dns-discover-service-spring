package dns.discover.service.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    private String name;
    private String description;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="roles")
    private List<Participation> participations;

    /**
     * Role Constructor
     *
     * @param name          Name of the role
     * @param description   Description of the role
     */
    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Role Constructor for JPA only
     */
    public Role(){
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
