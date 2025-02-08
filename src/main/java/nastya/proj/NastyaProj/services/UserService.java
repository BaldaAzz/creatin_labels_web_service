package nastya.proj.NastyaProj.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nastya.proj.NastyaProj.models.User;
import nastya.proj.NastyaProj.models.enums.Role;
import nastya.proj.NastyaProj.repositories.UserRrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRrepository userRrepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Разделить функцию на более мелкие функции и классы
    public boolean createUser(User user) {

        String email = user.getEmail();

        if(userRrepository.findByEmail(email) != null) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        userRrepository.save(user);

        log.info("Savin new User with email: {}", email);

        return true;
    }
}
