package ru.saikov.voprosnik;

public class MyMain {
    public final String ITEMS1_1 = "1. Администратор";    //Основное меню
    public final String ITEMS1_2 = "2. Пользователь";
    public final String ITEMS1_3 = "3. Выход из программы";

    public final String ITEMS2_1 = "1. Добавить пользователя в базу";   //Меню АДМИНИСТРАТОР
    public final String ITEMS2_2 = "2. Добавить группу вопросов";
    public final String ITEMS2_3 = "3. Назад";

    public final String ITEMS3_1 = "1. Сдать экзамен";      //Меню ПОЛЬЗОВАТЕЛЬ
    public final String ITEMS3_2 = "2. Распечатать протокол";
    public final String ITEMS3_3 = "3. Назад";

    public static void main(String[] args) {
        new MyMain().go();  //Запускаем основной программный метод
    }
    public void go() {
        MyMenu myMenu = new MyMenu(ITEMS1_1, ITEMS1_2, ITEMS1_3, null, null); //Создаем меню
        myMenu.printMenu();  //Печатаем на экран меню

        boolean cykl = true;   //Переменная для цикла
        while (cykl) {   //Цикл меню
            String mychosse = myMenu.getItemMenu();  //Какой элемент меню мы выбрали?
            if (mychosse == ITEMS1_1) {  //Выбран 1 элемент
                System.out.println("Выбран администратор");
                go1(); //Запускаем метод обработки события на 1 элемент
                myMenu.printMenu();  //Метод отработан, необходимо снова вывести меню
            }
            if (mychosse == ITEMS1_2) {
                System.out.println("Выбран пользователь");
                go3();
                myMenu.printMenu();
            }
            if (mychosse == ITEMS1_3) {
                System.out.println("Выбран выход из программы");
                System.exit(-1);   //Выход из программы
            }
            if((mychosse == "NC") || (mychosse == null)){ //Если вдруг пользователь ввел несуществующий пункт меню
                System.out.println("Введите корректный пункт меню");
                myMenu.printMenu();
            }
        }  //Конец цикла меню
    }

    public void go1(){ //Все по аналогии с предидущим методом
        MyMenu myMenu = new MyMenu(ITEMS2_1,ITEMS2_2,ITEMS2_3,null,null);
        myMenu.printMenu();
        boolean cykl = true;
        while (cykl){
            String myChosse = myMenu.getItemMenu();
            if (myChosse == ITEMS2_1){
                System.out.println("Выбран добавить пользователя в БД");
                myMenu.printMenu();
            }
            if (myChosse == ITEMS2_2) {
                System.out.println("Выбрано добавить группу вопросов");
                myMenu.printMenu();
                //break;
            }
            if (myChosse == ITEMS2_3) {
                System.out.println("Выбрано назад");
                break;
            }
            if((myChosse == "NC") || (myChosse == null)){
                System.out.println("Введите корректный пункт меню");
                myMenu.printMenu();
            }

        }
    }

    public void go3(){   //все по аналогии с предидущим методом
        MyMenu myMenu = new MyMenu(ITEMS3_1,ITEMS3_2,ITEMS3_3,null,null);
        myMenu.printMenu();
        boolean cykl = true;
        while (cykl){
            String myChosse = myMenu.getItemMenu();
            if (myChosse == ITEMS3_1){
                System.out.println("Выбран сдать экзамен");
                myMenu.printMenu();
            }
            if (myChosse == ITEMS3_2) {
                System.out.println("Выбрано распечатать протокол");
                myMenu.printMenu();
                //break;
            }
            if (myChosse == ITEMS3_3) {
                System.out.println("Выбрано назад");
                break;
            }
            if((myChosse == "NC") || (myChosse == null)){
                System.out.println("Введите корректный пункт меню");
                myMenu.printMenu();
            }

        }

    }

}
