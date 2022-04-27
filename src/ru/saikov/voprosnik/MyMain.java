package ru.saikov.voprosnik;

import javax.imageio.IIOException;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class MyMain {
    public final String ITEMS1_1 = "1. Администратор";    //Основное меню
    public final String ITEMS1_2 = "2. Пользователь";
    public final String ITEMS1_3 = "3. Выход из программы";

    public final String ITEMS2_1 = "1. Добавить пользователя в базу";   //Меню АДМИНИСТРАТОР
    public final String ITEMS2_2 = "2. Добавить файл вопросов";
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
                addUserToBd();  //Метод обработки
                myMenu.printMenu();
            }
            if (myChosse == ITEMS2_2) {
                addGroupQues();   //Метод обработки
                myMenu.printMenu();
            }
            if (myChosse == ITEMS2_3) { //Обрабатываем пункт меню НАЗАД
                System.out.println("Выбрано назад");
                break;  //Выходим из цикла
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
                getStady();   //Метод обработки
                myMenu.printMenu();
            }
            if (myChosse == ITEMS3_2) {
                printProtokol();   //Метод обработки
                myMenu.printMenu();
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
    public void addUserToBd(){ // Метод для меню ДОБАВИТЬ ПОЛЬЗОВАТЕЛЯ В БД
        MyUser myUser = new MyUser();
        System.out.println("***** Добавление нового пользователя *****");
        printHelperFIO(myUser);
        printHelperRabData(myUser);
        //Сохраняем объект, имя файла составляем по принципу Иванов_Иван_Иванович.USER в папку SSP/USERS
        //Предварительно на текущем ПК должна быть создана папка SSP/USERS в пользовательской папке!
        String pathToFiles = System.getProperty("user.home") + File.separatorChar + "SSP" + File.separatorChar + "USERS";  //Получаем путь к папке для сохранения
        try {
            FileOutputStream outputStream = new FileOutputStream(pathToFiles + File.separatorChar +
                    myUser.getFamilia() + "_" + myUser.getName() + "_" + myUser.getOtchestvo() + ".USERS");    //Собираем имя файла, открываем поток
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(myUser); //Сохраняем объект в файл
            objectOutputStream.close(); //Закрываем поток
            System.out.println("!!! Файл создан !!!");
        }catch (FileNotFoundException exception){
            //exception.printStackTrace();
            System.out.println("ОШИБКА! Создайте папку SSP и USERS!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addGroupQues(){   //Метод для меню ДОБАВИТЬ ГРУППУ ВОПРОСОВ
        //System.out.println("Выбрано добавить группу вопросов");
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** Добавить файл вопросов *****");
        Vopros vopros = new Vopros();
        printhelperInputQuestion(vopros);

        System.out.print("Название группы : ");  //Запрашиваем данные
        vopros.setFileName(scanner.nextLine());
        String pathToFiles = System.getProperty("user.home") + File.separatorChar + "SSP" + File.separatorChar + "QUESTION" + File.separatorChar +
                vopros.getFileName() + ".QUE";  //Получаем путь к папке для сохранения
        try {
            FileOutputStream outputStream = new FileOutputStream(pathToFiles);    //Собираем имя файла, открываем поток
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            for (int i = 0; i < 3; i++) {
                objectOutputStream.writeObject(vopros); //Сохраняем объект в файл
                printhelperInputQuestion(vopros);
            }
            objectOutputStream.close();
            System.out.println("Файл вопросов создан!");

            } catch (FileNotFoundException exception) {
                System.out.println("ОШИБКА! Папка QUESTION не найдена!");
            } catch (IOException e) {
                e.printStackTrace();
        }
    }


    public void getStady(){   //Метод для меню СДАТЬ ЭКЗАМЕН
        //Загрузить нужного пользователя
        MyUser myUserToStady = new MyUser();
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** Сдать экзамен *****");
        printHelperFIO(myUserToStady);
        String pathToFiles = System.getProperty("user.home") +
                File.separatorChar + "SSP" + File.separatorChar + "USERS";  //Формируем путь к файлу
        String myFile = pathToFiles + File.separatorChar + myUserToStady.getFamilia() + "_"
                + myUserToStady.getName() + "_" + myUserToStady.getOtchestvo() + ".USERS";  //Формируем имя файла
            try {
                FileInputStream fileStream = new FileInputStream(myFile);  //Открываем потоки
                ObjectInputStream os = new ObjectInputStream(fileStream);
                Object myUser = os.readObject(); //Читаем объект
                MyUser myUserLoad = (MyUser) myUser;  //Приводим к нужному нам типу
                os.close();  //Освобождаем ресурсы
                //Проверяем
                System.out.println("Загружено: Фамилия - " + myUserLoad.getFamilia() + ". Имя - " +
                        myUserLoad.getName() + ". Отчество : " + myUserLoad.getOtchestvo() + ".");  //Выводим данные с уже загруженного объекта
                System.out.println("Начинаем сдачу экзамена!");
                //Далее должна быть реализация сдачи экзамена**********************************************

            } catch (FileNotFoundException e) {  //Обрабатываем ошибочные ситуации
                System.out.println("ОШИБКА! Файл пользователя не найден! Добавьте нового пользователя!!!!");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }
    public void printProtokol(){    //Метод для меню РАСПЕЧАТАТЬ ПРОТОКОЛ
        System.out.println("Выбрано распечатать протокол");
    }

    public void printHelperFIO(MyUser mu){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Фамилия : ");  //Запрашиваем данные
        mu.setFamilia(scanner.nextLine());
        System.out.print("Имя : ");
        mu.setName(scanner.nextLine());
        System.out.print("Отчество : ");
        mu.setOtchestvo(scanner.nextLine());

    }
    public void printHelperRabData(MyUser mu){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Должность : ");
        mu.setDolznost(scanner.nextLine());
        System.out.print("Подразделение : ");
        mu.setPodrazdelenie(scanner.nextLine());
        System.out.print("Участок : ");
        mu.setUchastok(scanner.nextLine());
        System.out.print("Табельный номер : ");
        mu.setNumberOfTable(scanner.nextLine());
        System.out.print("Дата рождения (необходима подсказка относительно формата ввода даты!) : ");
        mu.setDataBorn(scanner.nextLine());
    }
    public void printhelperInputQuestion(Vopros vopros){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Вопрос : ");  //Запрашиваем данные
        vopros.setVopros(scanner.nextLine());
        System.out.print("Вариант №1 : ");  //Запрашиваем данные
        vopros.setVariant1(scanner.nextLine());
        System.out.print("Вариант №2 : ");  //Запрашиваем данные
        vopros.setVariant2(scanner.nextLine());
        System.out.print("Вариант №3 : ");  //Запрашиваем данные
        vopros.setVariant3(scanner.nextLine());
        System.out.print("Ответ : ");  //Запрашиваем данные
        vopros.setOtvet(scanner.nextLine());

    }
}
