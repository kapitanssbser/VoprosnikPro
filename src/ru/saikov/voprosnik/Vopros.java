package ru.saikov.voprosnik;

import java.io.Serializable;

public class Vopros implements Serializable { //Класс вопрос
    String vopros;//Сам вопрос
    String otvet;//Ответ на вопрос
    String variant1, variant2, variant3;//Варианты ответа
    enum Gruppy {ELECTRIK, SPEC_SYST};//Группы
    Gruppy gruppy;
    String fileName; //Имя файла группы вопросов
    //Конструктор
    public Vopros(String vopros,String otvet, String variant1, String variant2, String variant3, Gruppy gruppy){
        this.vopros = vopros;
        this.otvet = otvet;
        this.variant1 = variant1;
        this.variant2 = variant2;
        this.variant3 = variant3;
        this.gruppy = gruppy;
    }
    public Vopros(){
        super();
    }
    //Сеттеры и геттеры


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setVopros(String vopros) {
        this.vopros = vopros;
    }

    public String getVopros() {
        return vopros;
    }

    public void setOtvet(String otvet) {
        this.otvet = otvet;
    }

    public String getOtvet() {
        return otvet;
    }

    public void setVariant1(String variant1) {
        this.variant1 = variant1;
    }

    public String getVariant1() {
        return variant1;
    }

    public void setVariant2(String variant2) {
        this.variant2 = variant2;
    }

    public String getVariant2() {
        return variant2;
    }

    public void setVariant3(String variant3) {
        this.variant3 = variant3;
    }

    public String getVariant3() {
        return variant3;
    }

    public void setGruppy(Gruppy gruppy) {
        this.gruppy = gruppy;
    }

    public Gruppy getGruppy() {
        return gruppy;
    }
}
