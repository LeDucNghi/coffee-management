package com.WebsiteCoffe.Project_cafe;

import com.WebsiteCoffe.Project_cafe.Entity.Roles;
import com.WebsiteCoffe.Project_cafe.Service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
			employeeService.saveRoles(new Roles())
		}
	}
}
