package teacherweb.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import teacherweb.com.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

	Users findById(int id);

	Users findByUsernameAndPassword(String userName, String password);
	
	Users findByIdAndUsername(int id, String userName);
}
