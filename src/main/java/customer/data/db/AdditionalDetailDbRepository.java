package customer.data.db;

import customer.entity.AdditionalDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalDetailDbRepository extends JpaRepository<AdditionalDetailsEntity, Long> {



}
