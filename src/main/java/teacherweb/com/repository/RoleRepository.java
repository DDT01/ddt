package teacherweb.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import teacherweb.com.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query(value = "SELECT r FROM Role r WHERE r.id = :roleId")
	Role findById(@Param("roleId") int roleId);
}
