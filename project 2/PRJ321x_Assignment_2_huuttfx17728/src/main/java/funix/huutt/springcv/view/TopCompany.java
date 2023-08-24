package funix.huutt.springcv.view;

import funix.huutt.springcv.entity.Company;

public class TopCompany {

    private Company company;

    private Long countOfCandidates;

    private Long countOfRecruitments;

    public TopCompany() {
    }

    public TopCompany(Company company) {
        this.company = company;
    }

    public TopCompany(Company company, Long countOfCandidates) {
        this.company = company;
        this.countOfCandidates = countOfCandidates;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getCountOfCandidates() {
        return countOfCandidates;
    }

    public void setCountOfCandidates(Long countOfCandidates) {
        this.countOfCandidates = countOfCandidates;
    }

    public Long getCountOfRecruitments() {
        return countOfRecruitments;
    }

    public void setCountOfRecruitments(Long countOfRecruitments) {
        this.countOfRecruitments = countOfRecruitments;
    }

    @Override
    public String toString() {
        return "TopCompany{" +
                "company=" + company +
                ", countOfCandidates=" + countOfCandidates +
                '}';
    }
}
