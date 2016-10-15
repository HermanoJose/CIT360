package MVC;

/**
 * Created by cs_ch on 10/2/2016.
 */
public class control {
    private MVC.model model;
    private MVC.view view;

    public control(MVC.model model, MVC.view view){
        this.model = model;
        this.view = view;
    }

    public void setAnimalName(String name){
        model.setName(name);
    }

    public String getAnimalName(){
        return model.getName();
    }

    public void setLegsCount(int legs){
        model.setLegs(legs);
    }

    public int getLegsCount(){
        return model.getLegs();
    }

    public void updateView(){
        view.animalCout(model.getName(), model.getLegs());
    }
}
