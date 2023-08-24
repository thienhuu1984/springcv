package funix.huutt.springcv.service;

import funix.huutt.springcv.view.TopCompany;

import java.util.List;

public interface StatisticService {

    List<TopCompany> findTopCompanies();
}
