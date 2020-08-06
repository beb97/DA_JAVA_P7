package com.beb97.batch;

import java.util.Date;

public class Pret {

    private String bookId;
    private String personId;

    private Date dueDate;

    public Pret() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Pret{" +
                "bookId='" + bookId + '\'' +
                ", personId='" + personId + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}