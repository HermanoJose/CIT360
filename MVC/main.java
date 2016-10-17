package MVC;

/**
 * Created by cs_ch on 10/4/2016.
 */
public class main {
    public static void main(String[] args) throws Exception {
        model model  = new model();
        view view = new view();
        control con = new control(model, view);

        con.setAnimalName("horse");
        con.setLegsCount(4);
        con.updateView();

        con.setAnimalName("pigs");
        con.updateView();
        con.updateView();
    }
}
