package com.WebsiteCoffe.Project_cafe.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name="Roles")
public class Roles {
    @Id
    @SequenceGenerator(
            name = "roles_sequence",
            sequenceName = "roles_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.AUTO,
                    generator = "roles_sequence")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    @Fetch(value= FetchMode.SELECT)
    @JsonIgnore
    private Set<Employees> employees = new HashSet<>();


    public Roles(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
