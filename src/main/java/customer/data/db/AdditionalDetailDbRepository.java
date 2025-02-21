package customer.data.db;

import customer.entity.AdditionalDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AdditionalDetailDbRepository extends JpaRepository<AdditionalDetailsEntity, UUID> {
    List<AdditionalDetailsEntity> findByUserId(UUID userId);



}
