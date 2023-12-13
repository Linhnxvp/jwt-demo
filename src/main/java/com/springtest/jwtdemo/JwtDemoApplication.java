package com.springtest.jwtdemo;

import com.springtest.jwtdemo.models.ERole;
import com.springtest.jwtdemo.models.Role;
import com.springtest.jwtdemo.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JwtDemoApplication implements CommandLineRunner {

	private final RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()){
			roleRepository.save(new Role(ERole.ROLE_USER));
		}
		if (roleRepository.findByName(ERole.ROLE_MODERATOR).isEmpty()){
			roleRepository.save(new Role(ERole.ROLE_MODERATOR));
		}
		if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()){
			roleRepository.save(new Role(ERole.ROLE_ADMIN));
		}
	}
}
