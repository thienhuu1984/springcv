package funix.huutt.springcv.service;

import funix.huutt.springcv.entity.*;
import org.springframework.beans.MutablePropertyValues;

import java.util.List;

public interface CandidateService {

    List<Company> findAllCompany();
    List<CV> findAllCV(String username);
    List<OnlineCV> findAllOnlineCV(String username);

    List<User> findAllUsers();
    List<Recruitment> findAllRecruitments();
}
