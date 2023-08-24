package funix.huutt.springcv.service;

import funix.huutt.springcv.dao.EntityDao;
import funix.huutt.springcv.entity.Recruitment;
import funix.huutt.springcv.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
