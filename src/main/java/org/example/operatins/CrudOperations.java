package org.example.operatins;

import org.example.model.Course;
import org.example.model.Student;
import org.example.model.StudentDetails;
import org.example.model.Teacher;
import org.hibernate.Session;

public class CrudOperations {

    //one to one
    public static void createStudent(Session session)
    {
        Student student = new Student("raman","bangar","raman@gmail.com");
        StudentDetails studentDetails = new StudentDetails("maths","football");
        student.setStudentDetailsId(studentDetails);
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        System.out.println("successfully inserted ");
    }
    public static void deleteStudent(Session session) {
        session.beginTransaction();
       Student student = session.get(Student.class,1);
       System.out.println("Found student "+student);
       //delete student
        if(student!=null)
        {
            session.delete(student);
            session.getTransaction().commit();
            System.out.println("Successfully deleted");
        }
    }


    //one to  many
   public static void insertCourse(Session session)
   {

       session.beginTransaction();
       Student student = session.get(Student.class,2);

       Course course1= new Course("PS");


       student.add(course1);

       session.save(course1);


       session.getTransaction().commit();
       System.out.println("success-fully done");
   }

   //many to  many
    public static void insertTeacherCourse(Session session)
    {
        Teacher teacher1= new Teacher("sumit","koshti","smit67@gmail.com");
        Teacher teacher2= new Teacher("sonam","sahu","sonamt6@gmail.com");
        session.beginTransaction();
        Course newCourse = new Course("science");
        session.save(newCourse);
        newCourse.addTeacher(teacher1);
        newCourse.addTeacher(teacher2);
        session.save(teacher1);
        session.save(teacher2);
        session.getTransaction().commit();
        System.out.println("data inserted");
    }
}
