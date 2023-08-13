package com.example.COFFEE.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int userId;

    @Column(name = "UserName")
    private String userName;

    @Column(name="Password",nullable = false)

    private String userPass;

    @Column(name ="Phone",unique = true,nullable = false)
    private String phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "DateCreated")
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date created;

    @Column(name = "UserStatus")
    private Boolean userStatus;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="User_Role", joinColumns = @JoinColumn(name = "UserId"),
    inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private Set<Role> listRole= new HashSet<>();




}
