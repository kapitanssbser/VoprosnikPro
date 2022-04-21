package ru.saikov.voprosnik;

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
                System.out.println("������ �������� ������������ � ��");
                myMenu.printMenu();
            }
            if (myChosse == ITEMS2_2) {
                System.out.println("������� �������� ������ ��������");
                myMenu.printMenu();
                //break;
            }
            if (myChosse == ITEMS2_3) {
                System.out.println("������� �����");
                break;
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
                System.out.println("������ ����� �������");
                myMenu.printMenu();
            }
            if (myChosse == ITEMS3_2) {
                System.out.println("������� ����������� ��������");
                myMenu.printMenu();
                //break;
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

}
