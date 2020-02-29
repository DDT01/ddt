package teacherweb.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teacherweb.com.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);
	
	Users findByUsernameAndPassword(String userName, String password);
	
	Users findByIdAndUsername(int id, String userName);
}
