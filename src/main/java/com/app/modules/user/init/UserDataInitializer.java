package com.app.modules.user.init;

import com.app.modules.user.entity.Role;
import com.app.modules.user.entity.User;
import com.app.modules.user.entity.UserStatus;
import com.app.modules.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Initializes default sample users (Admin and Regular User) on application startup.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (!userRepository.existsByUsername("admin")) {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("Admin@123"))
                    .email("admin@example.com")
                    .fullName("Quản trị viên")
                    .phoneNumber("0901234567")
                    .role(Role.ROLE_ADMIN)
                    .status(UserStatus.ACTIVE)
                    .build();

            userRepository.save(admin);
            log.info(">>> Initialized default ADMIN account: username='admin', password='Admin@123'");
        }

        if (!userRepository.existsByUsername("user")) {
            User normalUser = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("User@123"))
                    .email("user@example.com")
                    .fullName("Người dùng mẫu")
                    .phoneNumber("0912345678")
                    .role(Role.ROLE_USER)
                    .status(UserStatus.ACTIVE)
                    .build();

            userRepository.save(normalUser);
            log.info(">>> Initialized default USER account: username='user', password='User@123'");
        }
    }
}
