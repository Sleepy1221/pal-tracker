package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private long hours;

    public TimeEntry() {

    }

    //new TimeEntry(projectId, userId, LocalDate.parse("2017-01-08"), 8));

    //new TimeEntry(timeEntryId, projectId, userId, LocalDate.parse("2017-01-08"), 8);

    public TimeEntry(long projectId, long userId, LocalDate date, long hours) {
        this.projectId = projectId;
        this.date = date;
        this.userId = userId;
        this.hours = hours;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getHours() {
        return hours;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return id == timeEntry.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }
}
