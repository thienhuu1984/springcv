package funix.huutt.springcv.repository;

import funix.huutt.springcv.entity.Company;
import funix.huutt.springcv.entity.JobApplied;
import funix.huutt.springcv.view.TopCompany;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StatisticsDAOImpl {

    @Autowired
    private EntityManager entityManager;



//    @Override
    public List<TopCompany> findTopCompanies() {

        List<TopCompany> topCompanies = new ArrayList<>();

        try {

            TypedQuery<Company> result = entityManager.createQuery(
                    "SELECT co " +
                            "FROM Company co " +
                            "JOIN (SELECT c.id , count(j) as num " +
                            "FROM Company c " +
                            "JOIN Recruitment r on c.id = r.company_id " +
                            "JOIN JobApply j on r.id = j.recruitment_id " +
                            "GROUP BY c.id " +
                            "ORDER BY num DESC) AS a " +
                            "ON a.id = co.id",
                    Company.class
            );

            List<Company> companies = result.getResultList();
            for(Company company: companies) {
                topCompanies.add(new TopCompany(company));
            }

            for(TopCompany topCompany: topCompanies) {
                TypedQuery<JobApplied> result1 = entityManager.createQuery(
                        "SELECT j " +
                                "FROM JobApply j " +
                                "JOIN ",
                        JobApplied.class
                );
            }

        } catch (Exception e) {
            System.out.println("No company found.");
            return null;
        }

        return topCompanies;
    }

    /*

    Select c.*, count(j.username) as num
From company c
join recruitment r on c.id = r.company_id
join job_applied j on r.id = j.recruitment_id
group by c.id
order by num desc;
     */
}
