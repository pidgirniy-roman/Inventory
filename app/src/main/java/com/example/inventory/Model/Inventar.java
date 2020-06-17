package com.example.inventory.Model;

public class Inventar {
    private int id;
    private String name; // ТТ/ЛО/ЦО/Сотрудник
    private String nameInv; // ИНВ
    private String Comment; // Комментарий
    private String readinessStatus; // Статус готовности
    private String statusSent; // Статус отправки
    private String date; // Дата отправки

    public Inventar(){}

    public Inventar(int id, String name, String nameInv, String comment, String readinessStatus, String statusSent, String date) {
        this.id = id;
        this.name = name;
        this.nameInv = nameInv;
        Comment = comment;
        this.readinessStatus = readinessStatus;
        this.statusSent = statusSent;
        this.date = date;
    }

    public Inventar(String name, String nameInv, String comment, String readinessStatus, String statusSent, String date) {
        this.name = name;
        this.nameInv = nameInv;
        Comment = comment;
        this.readinessStatus = readinessStatus;
        this.statusSent = statusSent;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameInv() {
        return nameInv;
    }

    public void setNameInv(String nameInv) {
        this.nameInv = nameInv;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getReadinessStatus() {
        return readinessStatus;
    }

    public void setReadinessStatus(String readinessStatus) {
        this.readinessStatus = readinessStatus;
    }

    public String getStatusSent() {
        return statusSent;
    }

    public void setStatusSent(String statusSent) {
        this.statusSent = statusSent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
