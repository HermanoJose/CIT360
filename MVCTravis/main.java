package MVCTravis;

/**
 * Created by Joseph on 10/8/16.
 */
public class main {
    public static void main(String[] args) throws Exception {
        ModelTravis model = new ModelTravis();
        ViewTravis view = new ViewTravis();
        ControlTravis control = new ControlTravis(model, view);

        CollegeBean msu = new CollegeBean();
        CollegeBean um = new CollegeBean();

        control.setBean(msu, "Michigan State", 2, 3, "Unranked");
        control.addCollege(msu);

        control.setBean(um, "University of Michigan", 5, 0, "4");
        control.addCollege(um);


    }
}
