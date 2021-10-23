package com.company;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Container arrayy = new Container();
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while(n != 4) {
            System.out.println("    ");
            System.out.println("0. Adding an element in the array:  ");
            System.out.println("1. Adding an element in the array after indicated position:  ");
            System.out.println("2. Deleting the element from the array:  ");
            System.out.println("3. Extraction the element by index :  ");
            System.out.println("4. Exit:  ");
            if (!scanner.hasNextInt()) {
                System.out.println("You have input non integer number of operation  ");
                break;
            }

            n = scanner.nextInt();
            int j;
            switch(n) {
                case 0:
                    System.out.print("Please, input the integer number: ");
                    if (scanner.hasNextInt()) {
                        j = scanner.nextInt();
                        System.out.println(j);
                        arrayy.addElementToArray(j);
                        System.out.print(arrayy.toString() + " ");
                    } else {
                        System.out.println("You have input non integer number");
                    }
                    break;
                case 1:
                    System.out.print("Please, input the integer number of an element u want to insert: ");
                    System.out.print("Please, input the integer number of a position after which u want to insert an element: ");
                    if (scanner.hasNextInt()) {
                        j = scanner.nextInt();
                        int position = scanner.nextInt();
                        System.out.println(j + "  " + position);
                        arrayy.addElementByIndex(j, position);
                        System.out.print(arrayy.toString() + " ");
                    } else {
                        System.out.println("You have input non integer number");
                    }
                    break;
                case 2:
                    System.out.print("Please, input the integer number of position which element you want to delete: ");
                    if (scanner.hasNextInt()) {
                        j = scanner.nextInt();
                        System.out.println(j);

                        try {
                            arrayy.removeElement(j);
                        } catch (Exception var7) {
                            System.out.print(var7.getMessage());
                        }

                        arrayy.shrinkSize();
                        System.out.print(arrayy.toString() + " ");
                    } else {
                        System.out.println("You have input non integer number");
                    }
                    break;
                case 3:
                    System.out.print("Please, input the integer number of position of element you want to extract: ");
                    if (scanner.hasNextInt()) {
                        j = scanner.nextInt();
                        System.out.println(j);
                        System.out.println("Your element:   ");

                        try {
                            System.out.print(arrayy.PopElement(j));
                        } catch (Exception var6) {
                            System.out.print(var6.getMessage());
                        }
                    } else {
                        System.out.println("You have input non integer number");
                    }
                case 4:
                    break;
                default:
                    System.out.println("You have input an incorrect number of operation ");
            }
        }

    }
}