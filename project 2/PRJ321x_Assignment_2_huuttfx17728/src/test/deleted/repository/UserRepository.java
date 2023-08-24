package funix.huutt.springcv.repository;

import funix.huutt.springcv.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(nativeQuery = true, value =
            "SELECT COUNT(*) AS num " +
            "FROM User " +
            "WHERE User NOT IN " +
            "(SELECT Role.user FROM Role " +
            "WHERE Role.name = 'Company' )"

    )
    Integer totalCandidate();
}
