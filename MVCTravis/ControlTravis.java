package MVCTravis;

import java.util.HashMap;

/**
 * Created by Joseph on 10/8/16.
 */
public class ControlTravis {
    private ModelTravis model;
    private ViewTravis view;

    public ControlTravis(ModelTravis model, ViewTravis view) {
        this.model = model;
        this.view = view;
    }

    public CollegeBean getBean(String name) {
        return model.getCollegeByName(name);
    }

    public void setBean(CollegeBean bean, String name, int wins, int losses, String rank) {
        bean.setName(name);
        bean.setWins(wins);
        bean.setLosses(losses);
        bean.setRank(rank);
    }

    public void display() {
        view.show(model.getAllColleges());
    }

    public void addCollege(CollegeBean college) {
        model.addCollege(college.getName(), college);
        view.show(model.getAllColleges());
    }
}
