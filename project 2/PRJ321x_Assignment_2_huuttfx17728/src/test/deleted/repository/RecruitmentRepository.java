package funix.huutt.springcv.repository;

import funix.huutt.springcv.entity.Company;
import funix.huutt.springcv.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Integer> {

    @Query("FROM Recruitment r " +
            "WHERE r.company = :company ")
    List<Recruitment> findAllOfCompany(@Param("company") Company company);


}
