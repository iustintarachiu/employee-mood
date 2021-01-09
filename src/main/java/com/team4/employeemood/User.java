package com.team4.employeemood;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name="users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private Date birthdate;
    private Date employmentDate;
    private String projectName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Mood> moods = new ArrayList<>();

//    private String username;

    public User(String firstName, String lastName, Date birthDate, Date employmentDate, String projectName, Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.employmentDate = employmentDate;
        this.projectName = projectName;
//        this.username = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@moodproject";
        this.id = id;

        UserData.userList.add(this);
    }

    public User() {
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

    public Date getBirthDate() {
        return birthdate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthdate = birthDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

//    public void setUsername() {
//        this.username = this.getFirstName().toLowerCase() + "." + this.getLastName().toLowerCase() + "@moodproject";
//    }

//    public String getUsername() {
//        return username;
//    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthdate +
                ", employmentDate=" + employmentDate +
                ", projectName='" + projectName + '\'' +
//                ", username='" + username + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public void setUsername(String username) {
//        this.username = username;
//    }
}
