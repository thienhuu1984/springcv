package funix.huutt.springcv.service;

import funix.huutt.springcv.entity.*;
import funix.huutt.springcv.view.CategoryAnalysis;
import funix.huutt.springcv.view.TopCompany;
import funix.huutt.springcv.view.TopRecuitment;

import java.util.List;

public interface EntityService {


    List<User> findAllCompany();
    List<User> findAllCandidate();
    List<Recruitment> findAllRecruitment();

    List<Category> findAllCategories() ;

    List<CategoryAnalysis> categoriesAnalysis();

    List<TopRecuitment> getTopRecuitments();
    List<TopCompany> findTopCompanies();

    List<Role> findAllRoles();

    Role findRole(int roleId);

    User saveUser(User user);
}
