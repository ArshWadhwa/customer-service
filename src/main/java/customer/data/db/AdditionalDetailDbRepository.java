package customer.data.db;

import customer.entity.AdditionalDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalDetailDbRepository extends JpaRepository<AdditionalDetailsEntity, Long> {



}
