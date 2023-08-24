package funix.huutt.springcv.controller;

import funix.huutt.springcv.entity.*;
import funix.huutt.springcv.view.Statistics;

import java.util.List;

// This is not Controller. It's used to define entity only.
public class EntityController {

    protected List<User> users;
    protected List<Company> companies;
    protected List<CV> cvs;
    protected List<OnlineCV> onlineCVS;
    protected List<Role> roles;
    protected List<Recruitment> recruitments;
    protected List<Status> statuses;
    protected List<JobType> jobTypes;
    protected List<JobPortfolio> jobPortfolios;
    protected List<JobEducation> jobEducations;
    protected List<JobExperience> jobExperiences;
    protected List<JobApply> jobApplies;
    protected JobSkill jobSkill;

    protected Company company;
    protected User user;
    protected Role role;
    protected Status status;
    protected OnlineCV onlineCV;
    protected CV cv;
    protected JobType jobType;
    protected Location location;

    protected String username;

    protected Statistics statistics;
}
