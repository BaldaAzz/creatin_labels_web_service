package nastya.proj.NastyaProj.repositories;

import nastya.proj.NastyaProj.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRrepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
