package funix.huutt.springcv.view;

import funix.huutt.springcv.entity.Recruitment;

public class TopRecuitment {

    private Recruitment recruitment;

    private int jobApplyCount;

    public TopRecuitment() {
    }

    public TopRecuitment(Recruitment recruitment, int jobApplyCount) {
        this.recruitment = recruitment;
        this.jobApplyCount = jobApplyCount;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

    public int getJobApplyCount() {
        return jobApplyCount;
    }

    public void setJobApplyCount(int jobApplyCount) {
        this.jobApplyCount = jobApplyCount;
    }
}
