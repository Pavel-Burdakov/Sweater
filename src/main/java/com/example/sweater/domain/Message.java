package com.example.sweater.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity // указывает spring-у, что это сущность, которую необходимо сохранять в базе данных.
public class Message {
    @Id// индентификатор (первичный ключ таблицы)
    @GeneratedValue(strategy = GenerationType.AUTO) // указывает на то чтобы id гененрировался автоматически
    private Integer id;
    private String text;
    private String tag;

    // если есть entity, то должен быть конструктор без параметров
    public Message(){}


    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }





}
