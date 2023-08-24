package funix.huutt.springcv.repository;

import funix.huutt.springcv.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
