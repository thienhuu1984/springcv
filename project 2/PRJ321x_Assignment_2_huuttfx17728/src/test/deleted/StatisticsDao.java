package funix.huutt.springcv.repository;

import funix.huutt.springcv.entity.Company;
import funix.huutt.springcv.view.TopCompany;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatisticsDao extends CrudRepository<Company, Long> {

    @Query("SELECT " +
            "new TopCompany(c , COUNT(j)) " +
            "FROM Company c " +
            "JOIN Recruitment r on c.id = r.company_id " +
            "JOIN JobApply j on r.id = j.recruitment_id " +
            "GROUP BY c.id " +
            "ORDER BY num DESC")
    List<TopCompany> findTopCompanies();

}
