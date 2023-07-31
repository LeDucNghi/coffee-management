package com.WebsiteCoffe.Project_cafe.Repository;

import com.WebsiteCoffe.Project_cafe.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Integer> {
    Employees findByEmployeeName(String employee_name);

}

