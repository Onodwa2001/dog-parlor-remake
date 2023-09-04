package za.ac.cput.dogparlor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.dogparlor.domain.ExtraService;

@Repository
public interface ExtraServiceRepository extends JpaRepository<ExtraService, String> {
}
