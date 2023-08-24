package funix.huutt.springcv.service;

import funix.huutt.springcv.entity.Company;
import funix.huutt.springcv.entity.Recruitment;

import java.util.List;

public interface CompanyService {

    List<Company> findAllCompany();
    List<Recruitment> findRecruitmentOfCompany(Company company);

}
