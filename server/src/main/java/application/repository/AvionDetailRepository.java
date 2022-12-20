package application.repository;

import application.model.AvionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionDetailRepository extends JpaRepository<AvionDetail, Integer> {
}
