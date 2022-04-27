package ru.saikov.voprosnik;

import javax.imageio.IIOException;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class MyMain {
    public final String ITEMS1_1 = "1. �������������";    //�������� ����
    public final String ITEMS1_2 = "2. ������������";
    public final String ITEMS1_3 = "3. ����� �� ���������";

    public final String ITEMS2_1 = "1. �������� ������������ � ����";   //���� �������������
    public final String ITEMS2_2 = "2. �������� ���� ��������";
    public final String ITEMS2_3 = "3. �����";

    public final String ITEMS3_1 = "1. ����� �������";      //���� ������������
    public final String ITEMS3_2 = "2. ����������� ��������";
    public final String ITEMS3_3 = "3. �����";

    public static void main(String[] args) {
        new MyMain().go();  //��������� �������� ����������� �����
    }
    public void go() {
        MyMenu myMenu = new MyMenu(ITEMS1_1, ITEMS1_2, ITEMS1_3, null, null); //������� ����
        myMenu.printMenu();  //�������� �� ����� ����

        boolean cykl = true;   //���������� ��� �����
        while (cykl) {   //���� ����
            String mychosse = myMenu.getItemMenu();  //����� ������� ���� �� �������?
            if (mychosse == ITEMS1_1) {  //������ 1 �������
                System.out.println("������ �������������");
                go1(); //��������� ����� ��������� ������� �� 1 �������
                myMenu.printMenu();  //����� ���������, ���������� ����� ������� ����
            }
            if (mychosse == ITEMS1_2) {
                System.out.println("������ ������������");
                go3();
                myMenu.printMenu();
            }
            if (mychosse == ITEMS1_3) {
                System.out.println("������ ����� �� ���������");
                System.exit(-1);   //����� �� ���������
            }
            if((mychosse == "NC") || (mychosse == null)){ //���� ����� ������������ ���� �������������� ����� ����
                System.out.println("������� ���������� ����� ����");
                myMenu.printMenu();
            }
        }  //����� ����� ����
    }

    public void go1(){ //��� �� �������� � ���������� �������
        MyMenu myMenu = new MyMenu(ITEMS2_1,ITEMS2_2,ITEMS2_3,null,null);
        myMenu.printMenu();
        boolean cykl = true;
        while (cykl){
            String myChosse = myMenu.getItemMenu();
            if (myChosse == ITEMS2_1){
                addUserToBd();  //����� ���������
                myMenu.printMenu();
            }
            if (myChosse == ITEMS2_2) {
                addGroupQues();   //����� ���������
                myMenu.printMenu();
            }
            if (myChosse == ITEMS2_3) { //������������ ����� ���� �����
                System.out.println("������� �����");
                break;  //������� �� �����
            }
            if((myChosse == "NC") || (myChosse == null)){
                System.out.println("������� ���������� ����� ����");
                myMenu.printMenu();
            }

        }
    }

    public void go3(){   //��� �� �������� � ���������� �������
        MyMenu myMenu = new MyMenu(ITEMS3_1,ITEMS3_2,ITEMS3_3,null,null);
        myMenu.printMenu();
        boolean cykl = true;
        while (cykl){
            String myChosse = myMenu.getItemMenu();
            if (myChosse == ITEMS3_1){
                getStady();   //����� ���������
                myMenu.printMenu();
            }
            if (myChosse == ITEMS3_2) {
                printProtokol();   //����� ���������
                myMenu.printMenu();
            }
            if (myChosse == ITEMS3_3) {
                System.out.println("������� �����");
                break;
            }
            if((myChosse == "NC") || (myChosse == null)){
                System.out.println("������� ���������� ����� ����");
                myMenu.printMenu();
            }

        }

    }
    public void addUserToBd(){ // ����� ��� ���� �������� ������������ � ��
        MyUser myUser = new MyUser();
        System.out.println("***** ���������� ������ ������������ *****");
        printHelperFIO(myUser);
        printHelperRabData(myUser);
        //��������� ������, ��� ����� ���������� �� �������� ������_����_��������.USER � ����� SSP/USERS
        //�������������� �� ������� �� ������ ���� ������� ����� SSP/USERS � ���������������� �����!
        String pathToFiles = System.getProperty("user.home") + File.separatorChar + "SSP" + File.separatorChar + "USERS";  //�������� ���� � ����� ��� ����������
        try {
            FileOutputStream outputStream = new FileOutputStream(pathToFiles + File.separatorChar +
                    myUser.getFamilia() + "_" + myUser.getName() + "_" + myUser.getOtchestvo() + ".USERS");    //�������� ��� �����, ��������� �����
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(myUser); //��������� ������ � ����
            objectOutputStream.close(); //��������� �����
            System.out.println("!!! ���� ������ !!!");
        }catch (FileNotFoundException exception){
            //exception.printStackTrace();
            System.out.println("������! �������� ����� SSP � USERS!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addGroupQues(){   //����� ��� ���� �������� ������ ��������
        //System.out.println("������� �������� ������ ��������");
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** �������� ���� �������� *****");
        Vopros vopros = new Vopros();
        printhelperInputQuestion(vopros);

        System.out.print("�������� ������ : ");  //����������� ������
        vopros.setFileName(scanner.nextLine());
        String pathToFiles = System.getProperty("user.home") + File.separatorChar + "SSP" + File.separatorChar + "QUESTION" + File.separatorChar +
                vopros.getFileName() + ".QUE";  //�������� ���� � ����� ��� ����������
        try {
            FileOutputStream outputStream = new FileOutputStream(pathToFiles);    //�������� ��� �����, ��������� �����
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            for (int i = 0; i < 3; i++) {
                objectOutputStream.writeObject(vopros); //��������� ������ � ����
                printhelperInputQuestion(vopros);
            }
            objectOutputStream.close();
            System.out.println("���� �������� ������!");

            } catch (FileNotFoundException exception) {
                System.out.println("������! ����� QUESTION �� �������!");
            } catch (IOException e) {
                e.printStackTrace();
        }
    }


    public void getStady(){   //����� ��� ���� ����� �������
        //��������� ������� ������������
        MyUser myUserToStady = new MyUser();
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** ����� ������� *****");
        printHelperFIO(myUserToStady);
        String pathToFiles = System.getProperty("user.home") +
                File.separatorChar + "SSP" + File.separatorChar + "USERS";  //��������� ���� � �����
        String myFile = pathToFiles + File.separatorChar + myUserToStady.getFamilia() + "_"
                + myUserToStady.getName() + "_" + myUserToStady.getOtchestvo() + ".USERS";  //��������� ��� �����
            try {
                FileInputStream fileStream = new FileInputStream(myFile);  //��������� ������
                ObjectInputStream os = new ObjectInputStream(fileStream);
                Object myUser = os.readObject(); //������ ������
                MyUser myUserLoad = (MyUser) myUser;  //�������� � ������� ��� ����
                os.close();  //����������� �������
                //���������
                System.out.println("���������: ������� - " + myUserLoad.getFamilia() + ". ��� - " +
                        myUserLoad.getName() + ". �������� : " + myUserLoad.getOtchestvo() + ".");  //������� ������ � ��� ������������ �������
                System.out.println("�������� ����� ��������!");
                //����� ������ ���� ���������� ����� ��������**********************************************

            } catch (FileNotFoundException e) {  //������������ ��������� ��������
                System.out.println("������! ���� ������������ �� ������! �������� ������ ������������!!!!");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }
    public void printProtokol(){    //����� ��� ���� ����������� ��������
        System.out.println("������� ����������� ��������");
    }

    public void printHelperFIO(MyUser mu){
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� : ");  //����������� ������
        mu.setFamilia(scanner.nextLine());
        System.out.print("��� : ");
        mu.setName(scanner.nextLine());
        System.out.print("�������� : ");
        mu.setOtchestvo(scanner.nextLine());

    }
    public void printHelperRabData(MyUser mu){
        Scanner scanner = new Scanner(System.in);
        System.out.print("��������� : ");
        mu.setDolznost(scanner.nextLine());
        System.out.print("������������� : ");
        mu.setPodrazdelenie(scanner.nextLine());
        System.out.print("������� : ");
        mu.setUchastok(scanner.nextLine());
        System.out.print("��������� ����� : ");
        mu.setNumberOfTable(scanner.nextLine());
        System.out.print("���� �������� (���������� ��������� ������������ ������� ����� ����!) : ");
        mu.setDataBorn(scanner.nextLine());
    }
    public void printhelperInputQuestion(Vopros vopros){
        Scanner scanner = new Scanner(System.in);
        System.out.print("������ : ");  //����������� ������
        vopros.setVopros(scanner.nextLine());
        System.out.print("������� �1 : ");  //����������� ������
        vopros.setVariant1(scanner.nextLine());
        System.out.print("������� �2 : ");  //����������� ������
        vopros.setVariant2(scanner.nextLine());
        System.out.print("������� �3 : ");  //����������� ������
        vopros.setVariant3(scanner.nextLine());
        System.out.print("����� : ");  //����������� ������
        vopros.setOtvet(scanner.nextLine());

    }
}
