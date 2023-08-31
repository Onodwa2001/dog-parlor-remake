package za.ac.cput.dogparlor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.dogparlor.domain.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role,String> {
}
