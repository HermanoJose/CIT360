import java.io.Serializable;

/**
 * Created by Heather on 9/16/2016.
 */
public class PersonBean implements Serializable {
    private String firstName;
    private String lastName;
    private int age;

    public PersonBean(){
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

