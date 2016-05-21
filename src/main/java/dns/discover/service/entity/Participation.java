package dns.discover.service.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_project_id")
    private Long id;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Project project;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="account_project_role", joinColumns=@JoinColumn(name="account_project_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
    private List<Role> roles;

    /**
     * Account and Project relationship constructor
     *
     * @param account    Account identification
     * @param project    Project identification
     */
    public Participation(Account account, Project project) {
        this.account = account;
        this.project = project;
    }

    /**
     * Account and Project relationship Constructor for JPA only
     */
    public Participation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
