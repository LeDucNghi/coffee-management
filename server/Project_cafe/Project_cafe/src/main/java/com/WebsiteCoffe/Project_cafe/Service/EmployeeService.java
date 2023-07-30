package com.WebsiteCoffe.Project_cafe.Service;

import com.WebsiteCoffe.Project_cafe.Entity.Employees;
import com.WebsiteCoffe.Project_cafe.Entity.Roles;

public interface EmployeeService {
    Employees saveEmployee(Employees employees);
    Roles saveRoles(Roles roles);
    void addToEmployee(String employeeName, String roleName);
}
