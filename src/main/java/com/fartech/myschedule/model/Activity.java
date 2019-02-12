package com.fartech.myschedule.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "activity")
@EntityListeners(AuditingEntityListener.class)
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  activityId;
    private String title;
    private String startDate;
    private String endDate;
    private Integer activityCategoryId;
    private String description;
    private String day;
    private Integer purchaseId;
    private boolean isDone;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getActivityCategoryId() {
        return activityCategoryId;
    }

    public void setActivityCategoryId(int activityCategoryId) {
        this.activityCategoryId = activityCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public void setActivityCategoryId(Integer activityCategoryId) {
        this.activityCategoryId = activityCategoryId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isFinished) {
        this.isDone = isFinished;
    }



    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", title='" + title + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", activityCategoryId=" + activityCategoryId +
                ", description='" + description + '\'' +
                ", day='" + day + '\'' +
                ", purchaseId=" + purchaseId +
                ", isDone=" + isDone +
                '}';
    }
}
