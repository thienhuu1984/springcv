package funix.huutt.springcv.service;

import funix.huutt.springcv.repository.*;
import funix.huutt.springcv.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CVRepository cvRepository;

    @Autowired
    private RecruitmentRepository recruitmentRepository;

    @Autowired
    private OnlineCvRepository onlineCvRepository;

//    @Autowired
//    private StatisticsDao statisticsDao;

    @Override
    public List<Company> findAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public List<CV> findAllCV(String username) {

        try {
            User user = null;
            Optional<User> data = userRepository.findById(username);
            if(!data.isEmpty())
                user = data.get();

            return  cvRepository.findCVsByCurrentUser(user);

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<OnlineCV> findAllOnlineCV(String username) {
        try {
            User user = null;
            Optional<User> data = userRepository.findById(username);
            if(!data.isEmpty())
                user = data.get();

            return  onlineCvRepository.findCVsByCurrentUser(user);

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Recruitment> findAllRecruitments() {
        return recruitmentRepository.findAll();
    }
}
