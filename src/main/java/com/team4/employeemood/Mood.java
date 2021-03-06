package com.team4.employeemood;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity(name="moods")
public class Mood {

    @Id
    @GeneratedValue
    private Long id;

    private Integer dayRating;
    private String comment;
    private String previousDayChange;
    private String improvementIdea;
    private Date date;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name="userId")
    private User user;


    public Mood(Integer dayRating, String comment, String previousDayChange, String improvementIdea, Date date, String username, Long id) {
        this.dayRating = dayRating;
        this.comment = comment;
        this.previousDayChange = previousDayChange;
        this.improvementIdea = improvementIdea;
        this.date = date;
//        this.username = username;
        this.id = id;

        MoodData.moodList.add(this);
    }

    public Mood() {
    }


    public Integer getDayRating() {
        return dayRating;
    }

    public void setDayRating(Integer dayRating) {
        this.dayRating = dayRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPreviousDayChange() {
        return previousDayChange;
    }

    public void setPreviousDayChange(String previousDayChange) {
        this.previousDayChange = previousDayChange;
    }

    public String getImprovementIdea() {
        return improvementIdea;
    }

    public void setImprovementIdea(String improvementIdea) {
        this.improvementIdea = improvementIdea;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Mood{" +
                "id=" + id +
                ", dayRating=" + dayRating +
                ", comment='" + comment + '\'' +
                ", previousDayChange='" + previousDayChange + '\'' +
                ", improvementIdea='" + improvementIdea + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
