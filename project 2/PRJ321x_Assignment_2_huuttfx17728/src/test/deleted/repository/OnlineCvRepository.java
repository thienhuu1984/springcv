package funix.huutt.springcv.repository;

import funix.huutt.springcv.entity.OnlineCV;
import funix.huutt.springcv.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OnlineCvRepository extends JpaRepository<OnlineCV, Integer> {

    @Query("FROM OnlineCV cv where cv.user = :user")
    List<OnlineCV> findCVsByCurrentUser(@Param("user") User user);

}
