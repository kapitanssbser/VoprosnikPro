package ru.saikov.voprosnik;

public class MyMain {
    public final String ITEMS1_1 = "1. Администратор";
    public final String ITEMS1_2 = "2. Пользователь";
    public final String ITEMS1_3 = "3. Выход из программы";

    public final String ITEMS2_1 = "1. Добавить пользователя в базу";
    public final String ITEMS2_2 = "2. Назад";

    public static void main(String[] args) {
        new MyMain().go();
    }
    public void go() {
        MyMenu myMenu = new MyMenu(ITEMS1_1, ITEMS1_2, ITEMS1_3, null, null);
        myMenu.printMenu();

        boolean cykl = true;
        while (cykl) {
            String mychosse = myMenu.getItemMenu();
            if (mychosse == ITEMS1_1) {
                System.out.println("Выбран администратор");
                go1();
                myMenu.printMenu();
            }
            if (mychosse == ITEMS1_2) {
                System.out.println("Выбран пользователь");
            }
            if (mychosse == ITEMS1_3) {
                System.out.println("Выбран выход из программы");
                System.exit(-1);
            }
            if((mychosse == "NC") || (mychosse == null)){
                System.out.println("Введите корректный пункт меню");
            }
        }
    }

    public void go1(){
        MyMenu myMenu = new MyMenu(ITEMS2_1,ITEMS2_2,null,null,null);
        myMenu.printMenu();
        boolean cykl = true;
        while (cykl){
            String myChosse = myMenu.getItemMenu();
            if (myChosse == ITEMS2_1){
                System.out.println("Выбран добавить пользователя в БД");
            }
            if (myChosse == ITEMS2_2) {
                System.out.println("Выбрано назад");
                break;
            }
        }
    }

}
