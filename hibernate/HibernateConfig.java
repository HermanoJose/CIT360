import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateConfig

{

    private SessionFactory sessionFactory;

    public HibernateConfig() {
        Configuration config = new Configuration();

        //nastyPath
        /////
        /// Act normal and program still runs
        //config.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");

        //it runs without a driver
        //config.setProperty("hibernate.connection.driver_class", " ");
//
        //cant use null as the username
        //config.setProperty("hibernate.connection.username", null);

        //Happy Path

        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        //change the next line of code to match your MySQL URL and port

        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");

        //change the next two lines of code to match your MySQL user name and password.

        config.setProperty("hibernate.connection.username", "root");

        config.setProperty("hibernate.connection.password", "root");

        //change the pool size to reflect how many users you expect your application to have initially

        config.setProperty("hibernate.connection.pool_size", "10");

        config.setProperty("hibernate.connection.autocommit", "true");
        config.setProperty("hibernate.id.new_generator_mappings", "false");

        config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

		/*
		 * un-comment the next line of code if you want to be able to drop and recreate tables for your data classes listed below.  This is generally a bad idea for security reasons.
		 */

        //config.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        config.setProperty("hibernate.show_sql", "true");

        config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

        config.setProperty("hibernate.current_session_context_class", "thread");

		/*
		 *  Add your classes here that you want to match your database tables
		 *  The example has a User and a PhoneNumber class.
		 */

        config.addAnnotatedClass(User.class);

        config.addAnnotatedClass(PhoneNumber.class);
/*
 * There have been several changes to the Hibernate libraries.
 * Please uncomment the source code for the version of Hibernate you are using.
*/
         /*Hibernate 4.3 - 5.x */ ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        /*Hibernate 3.x - 4.2*/ //ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public  Session getCurrentSession() {

        return sessionFactory.getCurrentSession();

    }

}