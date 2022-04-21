package ru.saikov.voprosnik;

import java.util.ArrayList;
import java.util.Scanner;

public class MyMenu {
    int chosse = 1;//Выбраный элемент меню
    ArrayList<String> listMenu = new ArrayList<String>();

    public MyMenu(String a_item1, String a_item2, String a_item3, String a_item4, String a_item5){
        listMenu.add(a_item1);
        listMenu.add(a_item2);
        listMenu.add(a_item3);
        listMenu.add(a_item4);
        listMenu.add(a_item5);
    }

    public void printMenu(){
        for (String s : listMenu){
            if (s != null) {
                System.out.println(s);
            }
        }
    }

    public String getItemMenu(){
        String items;
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        if (s == 1){
            items = listMenu.get(s - 1);
            return items;
        }
        if (s == 2){
            items = listMenu.get(s - 1);
            return items;
        }
        if (s == 3){
            items = listMenu.get(s - 1);
            return items;
        }
        if (s == 4){
            items = listMenu.get(s - 1);
            return items;
        }
        if (s == 5){
            items = listMenu.get(s - 1);
            return items;
        }

        return "NC";
    }
}
