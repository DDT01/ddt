package teacherweb.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import teacherweb.example.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
//    User findUserByUsername(String username);

    @Query("select u from User u where u.username = :username")
    User findUserByUsername(@Param("username") String username);
}
