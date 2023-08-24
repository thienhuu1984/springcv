package funix.huutt.springcv.repository;

import funix.huutt.springcv.entity.OnlineCV;

import java.util.List;

public interface OnlineCVDAO {

    List<OnlineCV> findOnlineCVByUsername(String username);
}
