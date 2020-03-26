package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

      @Id
      @Column(name = "id")
      @GeneratedValue( strategy = GenerationType.IDENTITY )
      private  int id;
      @Column(name = "first_name")
      private String firstName;
      @Column(name = "last_name")
      private String lastName;
      @Column(name = "email")
      private String email;
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "student_details_id")
      private StudentDetails studentDetailsId;

      @OneToMany(mappedBy = "student",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
      private List<Course>courses;

    public StudentDetails getStudentDetailsId() {
        return studentDetailsId;
    }

    public void setStudentDetailsId(StudentDetails studentDetailsId) {
        this.studentDetailsId = studentDetailsId;
    }

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", studentDetailsId=" + studentDetailsId +
                '}';
    }
    public void add( Course tempCourse)
    {
        if(courses==null)
        {
             courses= new ArrayList<Course>();
        }
        courses.add(tempCourse);
        tempCourse.setStudent(this);
    }
}
