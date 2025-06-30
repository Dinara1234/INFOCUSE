package org.example.springsecurityrest.event;


import lombok.RequiredArgsConstructor;
import org.example.springsecurityrest.entity.UserEntity;
import org.example.springsecurityrest.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationReadyEventListener {
    private static  final String ADMIN_FIRST_NAME = "dinara";
    private static  final String ADMIN_EMAIL = "lima.gi@yandex.ru";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        if(userRepository.findByEmail(ADMIN_EMAIL).isEmpty()) {
            UserEntity user = UserEntity.builder()
                    .email(ADMIN_EMAIL)
                    .firstName(ADMIN_FIRST_NAME)
                    .hashPassword(passwordEncoder.encode("123"))
                    .role(UserEntity.Role.ADMIN)
                    .state(UserEntity.State.OK)
                    .email(ADMIN_EMAIL)
                    .build();

            userRepository.save(user);

        }
    }


}
