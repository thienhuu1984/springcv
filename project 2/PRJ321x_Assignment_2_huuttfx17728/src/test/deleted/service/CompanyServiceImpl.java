package funix.huutt.springcv.service;

import funix.huutt.springcv.repository.CompanyRepository;
import funix.huutt.springcv.repository.RecruitmentRepository;
import funix.huutt.springcv.entity.Company;
import funix.huutt.springcv.entity.Recruitment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RecruitmentRepository recruitmentRepository;


    @Override
    public List<Company> findAllCompany() {
        return null;
    }

    @Override
    public List<Recruitment> findRecruitmentOfCompany(Company company) {
        return recruitmentRepository.findAllOfCompany(company);
    }
}
