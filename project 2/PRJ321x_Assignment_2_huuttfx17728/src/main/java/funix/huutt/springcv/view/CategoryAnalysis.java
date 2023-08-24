package funix.huutt.springcv.view;

import funix.huutt.springcv.entity.Category;

public class CategoryAnalysis {


    private Category category;

    private int recruitments;

    public CategoryAnalysis() {
    }

    public CategoryAnalysis(Category category, int recruitments) {
        this.category = category;
        this.recruitments = recruitments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getRecruitments() {
        return recruitments;
    }

    public void setRecruitments(int recruitments) {
        this.recruitments = recruitments;
    }
}
