package funix.huutt.springcv.dao;

import funix.huutt.springcv.entity.Category;
import funix.huutt.springcv.entity.Company;
import funix.huutt.springcv.entity.Recruitment;
import funix.huutt.springcv.entity.User;
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


}
