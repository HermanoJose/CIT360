import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Created by Joseph on 12/1/16.
 */
public class FoodModel {
    private HibernateConfig theHibernateConfiguration;
    public FoodModel() {
        this.theHibernateConfiguration = new HibernateConfig();
    }

    public Food getFood(String date) {
        Session theSession = this.theHibernateConfiguration.getCurrentSession();
        Transaction transaction = theSession.beginTransaction();
        Query singleUserQuery = theSession.createQuery("select f from Food as f where f.date="+date);
        Food theFood = (Food)singleUserQuery.uniqueResult();
        return theFood;
    }
}
