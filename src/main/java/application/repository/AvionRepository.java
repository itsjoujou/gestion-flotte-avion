package application.repository;

import application.model.AvionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AvionRepository extends JpaRepository<AvionEntity, Integer> {
    @Transactional
    @Query(value = "SELECT * FROM v_avion_detail WHERE EXTRACT(MONTH FROM expired_in)<=?1", nativeQuery = true)
    List<AvionEntity> findAllAvionWithAssuranceExpiredIn(int monthDuration);
}
