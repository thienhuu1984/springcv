package funix.huutt.springcv.repository;

import funix.huutt.springcv.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
