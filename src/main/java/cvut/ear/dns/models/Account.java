package cvut.ear.dns.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.beans.Transient;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jakub on 30.12.2016.
 */
@Entity
@Table(name = "ACCOUNTS")
public class Account implements UserDetails{


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "Username should be entered!")
    @Column(unique = true)
    @Size(min = 4, message = "Minimum size is 4 characters!")
    private String username;

    @NotNull
    @NotEmpty(message = "Password should be entered!")
    @Size(min = 6, message = "Minimum size is 6 characters!")
    private String password;

    @NotNull
    @NotEmpty(message = "First name should be entered!")
    private String firstName;

    @NotNull
    @NotEmpty(message = "Last name should be entered!")
    private String lastName;

    @NotNull
    @Column(unique = true)
    @NotEmpty(message = "Email should be entered")
    @Email(message = "Not a valid email!")
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccessedDate;

    private boolean enabled;

    private boolean tokenExpired;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "account_roles",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles;



    public Account() {
    }

    public Account(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tokenExpired = false;
    }

    @PrePersist
    protected void onCreate(){
        setCreationDate(new Date());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastAccessedDate() {
        return lastAccessedDate;
    }

    public void setLastAccessedDate(Date lastAccessedDate) {
        this.lastAccessedDate = lastAccessedDate;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                ", lastAccessedDate=" + lastAccessedDate +
                ", enabled=" + enabled +
                ", tokenExpired=" + tokenExpired +
                ", roles=" + roles +
                '}';
    }

    @Transient
    public Set<Permission> getPermissions(){
        Set<Permission> perms = new HashSet<>();
        for (Role role : roles){
            perms.addAll(role.getPermissions());
        }
        return perms;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.addAll(getRoles());
        grantedAuthorities.addAll(getPermissions());
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        //TODO return getPassword() ???
        return password;
    }

    @Override
    public String getUsername() {
        //TODO return getUsername() ???
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
