package Hibernate.Utill;

import Hibernate.Entity.Course;
import Hibernate.Entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtill {

    private static SessionFactory sessionFactory=buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry registry=new StandardServiceRegistryBuilder().loadProperties("NAITA.properties").build();

        Metadata metadata=new MetadataSources(registry)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .buildMetadata();
        return  metadata.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
