package com.WebsiteCoffe.Project_cafe;


import com.WebsiteCoffe.Project_cafe.Entity.Employees;

import com.WebsiteCoffe.Project_cafe.Entity.Roles;
import com.WebsiteCoffe.Project_cafe.Service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.HashSet;


@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class ProjectCafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectCafeApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(EmployeeService employeeService){
		return args -> {

			employeeService.saveRoles(new Roles(null,"Admin"));
			employeeService.saveRoles(new Roles(null,"Employee"));
			employeeService.saveRoles(new Roles(null,"Customer"));
			employeeService.saveRoles(new Roles(null,"Guest"));

			employeeService.saveEmployee(new Employees(null,"TestUser","123456","Test@gmail.com",new HashSet<>()));

			employeeService.addToEmployee("TestUser","Employee");


		};



	}
}
