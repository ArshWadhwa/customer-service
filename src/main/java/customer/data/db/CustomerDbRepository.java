package customer.data.db;

import customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerDbRepository extends JpaRepository<CustomerEntity, UUID>  {

}
