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
    public final String ITEMS2_2 = "2. �������� ������ ��������";
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** ���������� ������ ������������ *****");
        System.out.print("������� : ");
        myUser.setFamilia(scanner.nextLine());
        System.out.print("��� : ");
        myUser.setName(scanner.nextLine());
        System.out.print("�������� : ");
        myUser.setOtchestvo(scanner.nextLine());
        System.out.print("��������� : ");
        myUser.setDolznost(scanner.nextLine());
        System.out.print("������������� : ");
        myUser.setPodrazdelenie(scanner.nextLine());
        System.out.print("������� : ");
        myUser.setUchastok(scanner.nextLine());
        System.out.print("��������� ����� : ");
        myUser.setNumberOfTable(scanner.nextLine());
        System.out.print("���� �������� (���������� ��������� ������������ ������� ����� ����!) : ");
        myUser.setDataBorn(scanner.nextLine());
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
        System.out.println("������� �������� ������ ��������");
    }
    public void getStady(){   //����� ��� ���� ����� �������
        System.out.println("������ ����� �������");
        //��������� ������� ������������
    }
    public void printProtokol(){    //����� ��� ���� ����������� ��������
        System.out.println("������� ����������� ��������");
    }
}
