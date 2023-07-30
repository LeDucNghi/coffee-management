package com.WebsiteCoffe.Project_cafe.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "Employees")
public class Employees implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_id")
    private int id ;
    @Column(name= "Employee_name")
    private String employee_name;
    @Column(name= "Employee_password")
    private String employee_password;
    @Column(name= "Email")
    private String Email;

    @ManyToMany
    @JoinTable(name = "users_role",
    joinColumns = @JoinColumn(name="Employees_id"),
    inverseJoinColumns = @JoinColumn(name="Roles_ID")
    )
    private Set<Roles> roles= new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities= new ArrayList<>();
        roles.stream().forEach(i->authorities.add(new SimpleGrantedAuthority(i.getName( ))));
        return List.of(new SimpleGrantedAuthority(authorities.toString()));

    }

    @Override
    public String getPassword() {
        return employee_password;
    }

    @Override
    public String getUsername() {
        return employee_name;
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
