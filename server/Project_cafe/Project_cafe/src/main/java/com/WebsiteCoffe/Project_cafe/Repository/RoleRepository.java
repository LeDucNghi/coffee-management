package com.WebsiteCoffe.Project_cafe.Repository;

import com.WebsiteCoffe.Project_cafe.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {


    Roles findByName(String roleName);

}
