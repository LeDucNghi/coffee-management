package com.WebsiteCoffe.Project_cafe.Service;


import com.WebsiteCoffe.Project_cafe.Entity.Employees;
import com.WebsiteCoffe.Project_cafe.Entity.Roles;
import com.WebsiteCoffe.Project_cafe.Repository.EmployeeRepository;
import com.WebsiteCoffe.Project_cafe.Repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private  EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Employees saveEmployee(Employees employees) {
        employees.setEmployee_password(passwordEncoder.encode(employees.getEmployee_password()));
        return employeeRepository.save(employees);
    }

    @Override
    public Roles saveRoles(Roles roles) {
       return  roleRepository.save(roles);
    }

    @Override
    public void addToEmployee(String employeeName, String roleName) {


        Employees employee= employeeRepository.findByEmployeeName(employeeName);

        Roles role = roleRepository.findByName(roleName);
        employee.getRoles().add(role);
    }
}
