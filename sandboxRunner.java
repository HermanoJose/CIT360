import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by cs_ch on 11/8/2016.
 */
public class sandboxRunner {
    private List<User> users;
    private HibernateConfig H;

    public sandboxRunner(){
        H = new HibernateConfig();
    }

    public static void main(String[] args) {
        sandboxRunner aSillyHibernateUseExample = new sandboxRunner();
        aSillyHibernateUseExample.AddUser();
        aSillyHibernateUseExample.ShowUser();
    }

    private void AddUser(){
        Session session = H.getCurrentSession();

        Transaction Tsession = session.beginTransaction();

        User Rex = new User();
        Rex.setUname("Rex");
        Rex.setPword("123456789");

        session.save(Rex);
        Tsession.commit();

        System.out.println("aUser generated ID is: " + Rex.getId() + Rex.getUname());
    }

    private void ShowUser(){
        Session session = H.getCurrentSession();
        Transaction showT = session.beginTransaction();

        Query k = session.createQuery("dfdfdfdf");
        Query j = session.createQuery((String)null);
        Query f = session.createQuery("");
        Query allUsersQuery = session.createQuery("select u from User as u");

        users = allUsersQuery.list();

        Iterator<User> iter = users.iterator();;
        while(iter.hasNext()) {
            User element = iter.next();
            System.out.println(element.toString());
        }
        showT.commit();
    }
}
