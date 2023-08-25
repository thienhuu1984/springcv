package funix.huutt.springcv.dao;

import funix.huutt.springcv.entity.*;
import funix.huutt.springcv.view.CategoryAnalysis;
import funix.huutt.springcv.view.TopCompany;
import funix.huutt.springcv.view.TopRecuitment;

import java.util.List;

public interface EntityDao {

    List<User> findAllCompany();
    List<Company> findAllCompanyWithRecruitments();
    List<User> findAllCandidate();
    List<Recruitment> findAllRecruitment();
    List<Recruitment> findAllRecruitmentsWithAppliesOfCompany(Company company);

    List<CategoryAnalysis> categoriesAnalysis();

    List<Category> findAllCategories();

    List<TopRecuitment> getTopRecruitments();

    List<TopCompany> findTopCompanies();

    Company findCompanyWithAllRecruitments(int companyId);
    Recruitment findRecruitmentHasAppliesById(int recruitmentId);


    List<Role> findAllRoles();

    Role findRole(int roleId);

    User saveUser(User user);
}
