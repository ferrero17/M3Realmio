package com.example.dani.m3_realmio.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class Profesor extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private  String email;
    private RealmList<Curso> cursos;
    //Migration
    private String cognom;

    private String subject;
    @Index
    private int age;
    private int sexe;
    @Index
    private String casat;

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCasat() {
        return casat;
    }

    public void setCasat(String casat) {
        this.casat = casat;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RealmList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(RealmList<Curso> cursos) {
        this.cursos = cursos;
    }
}
