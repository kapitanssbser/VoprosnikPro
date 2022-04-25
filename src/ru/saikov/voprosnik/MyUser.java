package ru.saikov.voprosnik;

import java.util.Date;

public class MyUser {
    String familia; //Фамилия
    String name;    //Имя
    String otchestvo;    //Отчество
    String dolznost;     //Должность
    String podrazdelenie;     //Подразделение
    String uchastok;     //Участок
    Date dataBorn;     //Дата рождения
    String numberOfTable;    //Табельный номер
    String notes;    //Примечания
    //Сетеры и гетеры

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getFamilia() {
        return familia;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setDolznost(String dolznost) {
        this.dolznost = dolznost;
    }

    public String getDolznost() {
        return dolznost;
    }

    public void setPodrazdelenie(String podrazdelenie) {
        this.podrazdelenie = podrazdelenie;
    }

    public String getPodrazdelenie() {
        return podrazdelenie;
    }

    public void setUchastok(String uchastok) {
        this.uchastok = uchastok;
    }

    public String getUchastok() {
        return uchastok;
    }

    public void setDataBorn(Date dataBorn) {
        this.dataBorn = dataBorn;
    }

    public Date getDataBorn() {
        return dataBorn;
    }

    public void setNumberOfTable(String numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    public String getNumberOfTable() {
        return numberOfTable;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }
}
