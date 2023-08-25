package funix.huutt.springcv.service;

import funix.huutt.springcv.dao.EntityDao;
import funix.huutt.springcv.entity.Category;
import funix.huutt.springcv.entity.Recruitment;
import funix.huutt.springcv.entity.Role;
import funix.huutt.springcv.entity.User;
import funix.huutt.springcv.view.CategoryAnalysis;
import funix.huutt.springcv.view.TopCompany;
import funix.huutt.springcv.view.TopRecuitment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    private EntityDao entityDao;


    @Override
    public List<User> findAllCompany() {
        return entityDao.findAllCompany();
    }

    @Override
    public List<User> findAllCandidate() {
        return entityDao.findAllCandidate();
    }

    @Override
    public List<Recruitment> findAllRecruitment() {
        return entityDao.findAllRecruitment();
    }

    @Override
    public List<Category> findAllCategories() {
        return entityDao.findAllCategories();

    }


    @Override
    public List<CategoryAnalysis> categoriesAnalysis() {
        return entityDao.categoriesAnalysis();
    }

    @Override
    public List<TopRecuitment> getTopRecuitments() {
        return entityDao.getTopRecruitments();
    }

    @Override
    public List<TopCompany> findTopCompanies() {
        return entityDao.findTopCompanies();
    }

    @Override
    public List<Role> findAllRoles() {

        return entityDao.findAllRoles();
    }

    @Override
    public Role findRole(int roleId) {
        return entityDao.findRole(roleId);
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return entityDao.saveUser(user);
    }
}
