package ru.saikov.voprosnik;

import java.util.ArrayList;
import java.util.Scanner;

public class MyMenu {
    int chosse = 1;//Выбраный элемент меню
    ArrayList<String> listMenu = new ArrayList<String>(); //Список для элементов меню

    public MyMenu(String a_item1, String a_item2, String a_item3, String a_item4, String a_item5){  //Конструктор
        listMenu.add(a_item1);   //Заполняем список элементами меню
        listMenu.add(a_item2);   //Если пункт меню не нужен передаем null
        listMenu.add(a_item3);
        listMenu.add(a_item4);
        listMenu.add(a_item5);
    }

    public void printMenu(){   //Печать меню
        for (String s : listMenu){  //Проходим по всему списку
            if (s != null) {   //Выводим на экран только НЕ ПУСТЫЕ элементы
                System.out.println(s);
            }
        }
    }

    public String getItemMenu(){   //Метод возвращает что нажал пользователь
        String items;
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();   //Запрашиваем ввод
        if (s == 1){   //При конкретном варианте
            items = listMenu.get(s - 1); //Получаем соответствующий элемент из списка
            return items;   //Возвращаем
        }
        if (s == 2){      //Далее аналогично
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

        return "NC";  //Если не один вариант не прошел, нужно для проверки диапазон введенных пользователя
    }
}
