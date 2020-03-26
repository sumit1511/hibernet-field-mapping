package org.example.model;

import javax.persistence.*;

@Entity
@Table(name="student_details")
public class StudentDetails  {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    @Column(name = "main_subject")
    private String mainSubject;
    @Column(name = "hobby")
    private String hobby;

    public StudentDetails(String mainSubject, String hobby) {
        this.mainSubject = mainSubject;
        this.hobby = hobby;
    }

    public StudentDetails() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain_subject() {
        return mainSubject;
    }

    public void setMain_subject(String main_subject) {
        this.mainSubject = main_subject;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", main_subject='" + mainSubject + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
