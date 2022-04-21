package ru.saikov.voprosnik;

public class MyMain {
    public final String ITEMS1_1 = "1. Администратор";
    public final String ITEMS1_2 = "2. Пользователь";
    public final String ITEMS1_3 = "3. Выход из программы";

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

}
