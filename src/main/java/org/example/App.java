package org.example;

import org.example.model.Course;
import org.example.model.Student;
import org.example.model.StudentDetails;
import org.example.model.Teacher;
import org.example.operatins.CrudOperations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class App
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = null;
        try{
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(StudentDetails.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Teacher.class)
                    .buildSessionFactory();
            Session session=sessionFactory.getCurrentSession();

//
//            CrudOperations.createStudent(session);
//            CrudOperations.insertCourse(session);
//            CrudOperations.deleteStudent(session);
//            CrudOperations.insertTeacherCourse(session);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            sessionFactory.close();
        }

    }
}
