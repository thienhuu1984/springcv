package funix.huutt.springcv.dao;

import funix.huutt.springcv.entity.*;
import funix.huutt.springcv.view.CategoryAnalysis;
import funix.huutt.springcv.view.TopCompany;
import funix.huutt.springcv.view.TopRecuitment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntityDaoImpl implements EntityDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAllCompany() {

        try {

            TypedQuery<Role> rQuery = entityManager.createQuery(
                    "FROM Role r " +
                            "JOIN FETCH r.users " +
                            "WHERE r.name = :data",
                    Role.class
            );

            rQuery.setParameter("data", "Company");

            Role role = rQuery.getSingleResult();

            return role.getUsers();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Company> findAllCompanyWithRecruitments() {


        try {

            TypedQuery<Company> query = entityManager.createQuery(
                    "FROM Company c " +
                            "JOIN FETCH c.recruitments " +
                            "WHERE c.status > 0 ",
                    Company.class
            );


            return query.getResultList();


        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public List<User> findAllCandidate() {

        try {

            TypedQuery<Role> rQuery = entityManager.createQuery(
                    "FROM Role r " +
                            "JOIN FETCH r.users " +
                            "WHERE r.name = :data1 ",
                    Role.class
            );

            rQuery.setParameter("data1", "Candidate");

            Role role = rQuery.getSingleResult();

            return role.getUsers();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Recruitment> findAllRecruitment() {

        try {

            TypedQuery<Recruitment> query = entityManager.createQuery(
                    "FROM Recruitment r " +
                            "LEFT JOIN FETCH r.jobApplies " +
                            "JOIN FETCH r.jobType " +
                            "WHERE r.expiredDate >= :data " +
                            "AND r.status > 0 ",
                    Recruitment.class
            );

            query.setParameter("data", new java.sql.Date(System.currentTimeMillis()));

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Recruitment> findAllRecruitmentsWithAppliesOfCompany(Company company) {
        try {

            TypedQuery<Recruitment> query = entityManager.createQuery(
                    "FROM Recruitment r " +
                            "JOIN FETCH r.jobApplies " +
                            "WHERE r.company_id = :data1 " +
                            "AND r.expiredDate >= :data2 " +
                            "AND r.status > 0 ",
                    Recruitment.class
            );

            query.setParameter("data1", company.getId());
            query.setParameter("data2", new java.sql.Date(System.currentTimeMillis()));

            return query.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<CategoryAnalysis> categoriesAnalysis() {

        try {


            List<Category> categories = findAllCategories();

            if(categories == null ) return null;

            List<CategoryAnalysis> categoryAnalyses = new ArrayList<>();

            for(int i = 0; i< 4; i++) {
                int max = getCategoryMostRecruitments(categories);
                if(max == -1) break;
                categoryAnalyses.add(new CategoryAnalysis(
                        categories.get(max),
                        categories.get(max).getRecruitments().size()
                ));
                categories.remove(max);
            }


            return categoryAnalyses;

        } catch (Exception e) {
            return null;
        }
    }



    @Override
    public List<Category> findAllCategories() {

        try {
            TypedQuery<Category> query = entityManager.createQuery(
                    "FROM Category c " +
                            "LEFT JOIN FETCH c.recruitments "   ,
                    Category.class
            );

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TopRecuitment> getTopRecruitments() {
        try {

            List<Recruitment> recruitments = findAllRecruitment();

            if(recruitments == null ) return null;

            List<TopRecuitment> topRecuitments = new ArrayList<>();

            for(int i=0;i<4;i++) {
                int max = findMaxApplyCount(recruitments) ;
                if(max == -1) break;
                topRecuitments.add(new TopRecuitment(recruitments.get(max), recruitments.get(max).getJobApplies().size()));
                recruitments.remove(max);
            }

            return topRecuitments;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TopCompany> findTopCompanies() {

        try {
            List<Company> companies = findAllCompanyWithRecruitments();

            List<TopCompany> temps = new ArrayList<>();
            List<TopCompany> results = new ArrayList<>();

            for (Company company: companies) {
                long count = 0;
                List<Recruitment> recruitments = findAllRecruitmentsWithAppliesOfCompany(company) ;
                if(recruitments == null) continue;
                for(Recruitment recruitment : recruitments) {
                    count += recruitment.getJobApplies().size();
                }
                temps.add(new TopCompany(company, count));
            }

            for(int i=0;i<4;i++ ) {
                int max = findCompanyHasMaxApplyCount(temps) ;
                if(max == -1) break;
                results.add(temps.get(max));
                temps.remove(max);
            }

            return results;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Company findCompanyWithAllRecruitments(int companyId) {

        try {

            TypedQuery<Company> query = entityManager.createQuery(
                    "FROM Company c " +
                            "JOIN FETCH c.recruitments " +
                            "WHERE c.id = :data " +
                            "AND c.status > 0 ",
                    Company.class
            );

            query.setParameter("data", companyId) ;

            return query.getSingleResult();


        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public Recruitment findRecruitmentHasAppliesById(int recruitmentId) {

        try {

            TypedQuery<Recruitment> query = entityManager.createQuery(
                    "FROM Recruitment r " +
                            "LEFT JOIN FETCH r.jobApplies " +
                            "WHERE r.id = :data1 " +
                            "AND r.expiredDate > :data2 " +
                            "AND r.status > 0",
                    Recruitment.class
            );

            query.setParameter("data1", recruitmentId);
            query.setParameter("data2", new java.sql.Date(System.currentTimeMillis()));

            return query.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Role> findAllRoles() {

        try {
            TypedQuery<Role> query = entityManager.createQuery(
                    "FROM Role r " +
                            "WHERE r.id > :data ",
                    Role.class
            );

            query.setParameter("data", 1);

            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Role findRole(int roleId) {
        return entityManager.find(Role.class, roleId);
    }

    @Override
    public User saveUser(User user) {

        User dbUser = entityManager.merge(user);

        return dbUser;
    }

    private int findCompanyHasMaxApplyCount(List<TopCompany> topCompanies ) {

        if(topCompanies == null || topCompanies.size() == 0) return -1;

        int max = 0;
        long res = topCompanies.get(0).getCountOfCandidates();

        for(int i =0; i< topCompanies.size(); i++) {
            long t = topCompanies.get(i).getCountOfCandidates();
            if( t > res) {
                max = i;
                res = t;
            }
        }

        return max;

    }

    private int findMaxApplyCount(List<Recruitment> recruitments) {

        if(recruitments == null || recruitments.size() == 0) return -1;

        int maxId = 0;
        int res = recruitments.get(0).getJobApplies().size();
        for(int i =0;i< recruitments.size();i++) {
            int t = recruitments.get(i).getJobApplies().size();
            if(t > res) {
                maxId = i;
                res = t;
            }
        }

        return maxId;
    }

    private int getCategoryMostRecruitments(List<Category> categories) {

        if(categories == null || categories.size() == 0) return  -1;

        int max = 0;
        int res = categories.get(max).getRecruitments().size();
        for(int i = 0; i<categories.size(); i++ ) {
            int t = categories.get(i).getRecruitments().size();
            if(t > res) {
                max = i;
                res = t;
            }
        }
        return max;
    }
}
