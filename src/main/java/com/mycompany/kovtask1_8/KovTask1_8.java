

package com.mycompany.kovtask1_8;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;



public class KovTask1_8 {
    
    

    
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        var list = new LinkedList<Telephone>();
        
        list.add(new Telephone("Samsung Note 4", "XYZ123456789", "White", true));
        list.add(new Telephone("Iphone 14 Pro", "X35235ZMD", "Deep Purple", true));
        list.add(new Telephone("POCO X3 PRO MAX ULTRA M5 GALAXY NOTE 19 EXTRA CHRAGE CHINA TOWN", "XYZ123456789", "Black", true));
        
        System.out.println("Вариант 2. Ковальчук Артем Викторович.");
        
        int command = 0;
        do {
            for (var i : list) {
                        System.out.println("%s, %s, %s, %s".formatted(i.model, i.serialNumber, i.color, i.areMobile));
                    }
            System.out.println("Выберите операцию:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить новый телефон");
            System.out.println("2. Удаление телефона по серийному номеру");
            System.out.println("3. Удаление всех телефонов из списка");
            
            command = scan.nextInt();
            
            switch (command){
                case 0: break;
                case 1: {
                    System.out.println("Введите модель телефона");
                    String model = scan.next();
                    String varSerNum;
                    boolean flag = true;
                    do {
                        flag = false;
                        System.out.println("Введите серийный номер устройства:");
                        varSerNum = scan.next();
                        for (Telephone telephone : list){
                        if (varSerNum.equals(telephone.serialNumber)){ 
                            System.out.println("Телефон с таким серийным номером уже есть в списке.");
                            flag = true;
                            break;
                        }
                        }
                    } while(flag == true);
                    System.out.println("Введите цвет телефона:");
                    String color = scan.next();
                    System.out.println("Telaфон является мобильным? (true/false):");
                    boolean areMobile = scan.nextBoolean();
                    
                    list.add(new Telephone(model, varSerNum, color, areMobile));
                    break;
                }
                case 2: {
                    System.out.println("Введите серийный номер устройства");
                    String varSerNum = scan.next();
                    
                    
                        for (Telephone telephone : list ){
                        if (varSerNum.equals(telephone.serialNumber)){
                            list.remove(telephone);
                        }
                    }
                    
                    
                    break;
                }
                case 3: {
                    list.clear();
                    System.out.println("Список очищен!");
                    break;
                }
                default: {
                    System.out.println("Неверная операция!");
                }
            }
        } while (command != 0);
    }
}
    

