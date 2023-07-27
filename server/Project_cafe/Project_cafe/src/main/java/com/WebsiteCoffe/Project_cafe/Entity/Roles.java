package com.WebsiteCoffe.Project_cafe.Entity;


import jakarta.persistence.*;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO,
                    generator = "roles_sequence")
    private long id;
    private String name;
}
