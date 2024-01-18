package com.example.erp_app.config;

import com.example.erp_app.controller.dto.RegisterRequest;
import com.example.erp_app.model.Role;
import com.example.erp_app.model.Specialization;
import com.example.erp_app.model.User;
import com.example.erp_app.repository.SpecializationRepository;
import com.example.erp_app.repository.UserRepository;
import com.example.erp_app.service.SpecializationService;
import com.example.erp_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final SpecializationRepository specializationRepository;
    private final UserService userService;
    private final SpecializationService specializationService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(UserRepository userRepository, UserService userService,
                           SpecializationRepository specializationRepository,
                           SpecializationService specializationService,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.specializationRepository = specializationRepository;
        this.specializationService = specializationService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Specialization spec = specializationRepository.findById(1l).orElse(null);
        if (spec == null) {
            specializationService.addSpecialization("IT Admin");
        }

        User user = userRepository.findByEmail("admin").orElse(null);

//        if (user == null) {
//            RegisterRequest newUser = new RegisterRequest();
//            newUser.setName("Adam");
//            newUser.setSurname("Kowalski");
//            newUser.setEmail("admin");
//            newUser.setPesel("123321122312");
//            newUser.setPhoneNum("321939876");
//            newUser.setPassword("admin");
//            newUser.setDateOfBirthday("1996-05-09");
//            newUser.setSpecId(1l);
//            userService.register(newUser);
//        }

        if (user == null) {
            User newUser = new User();
            newUser.setName("Adam");
            newUser.setSurname("Kowalski");
            newUser.setEmail("admin");
            newUser.setPesel("123321122312");
            newUser.setPhoneNum("321939876");
            newUser.setPassword(passwordEncoder.encode("admin"));
            newUser.setDOB(LocalDate.parse("1996-05-09"));
            newUser.setSpecialization(specializationRepository.findById(1l).orElseThrow());
            newUser.setRole(Role.ADMIN);
            userRepository.save(newUser);
        }
    }
}
