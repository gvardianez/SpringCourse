package ru.alov.lesson_3_mvc.models;

public interface IProduct {
    int getId();
    String getName();
    double getCost();
    void setId(int id);
    void setName(String name);
    void setCost(double cost);
}
