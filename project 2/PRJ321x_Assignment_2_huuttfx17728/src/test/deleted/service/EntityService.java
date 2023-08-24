package funix.huutt.springcv.service;

import funix.huutt.springcv.entity.*;

import java.util.List;

public interface EntityService {


    List<User> findAllCompany();
    List<User> findAllCandidate();
    List<Recruitment> findAllRecruitment();
}
