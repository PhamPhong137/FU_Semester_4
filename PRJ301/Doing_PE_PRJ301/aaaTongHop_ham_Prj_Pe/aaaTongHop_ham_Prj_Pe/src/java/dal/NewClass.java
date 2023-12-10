/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class NewClass {

    public static Scanner sc = new Scanner(System.in);
    
    public static int getIntegerInRange(int min, int max) {
        int value;
        while (true) {
            if (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Please enter integer number: ");
                continue;
            }
            value = sc.nextInt();
            sc.nextLine();
            if (value < min) {
                System.out.print("Please enter number larger or equal " + min + ": ");
                continue;
            }
            if (value > max) {
                System.out.print("Please enter number lower equal " + max + ": ");
                continue;
            }
            return value;
        }
    }
    
    public static  boolean checkYN() {
        String choice;
        while (true) {
            choice = sc.nextLine();
            if ("y".equalsIgnoreCase(choice) || "yes".equalsIgnoreCase(choice))
                return true;

            if ("n".equalsIgnoreCase(choice) || "no".equalsIgnoreCase(choice))
                return false;

            System.out.print("Please enter your decision: ");
        }
    }
    
    public static void main(String[] args) {
        
        System.out.print("Enter length of Array:");
        int len = Integer.parseInt(sc.nextLine());
        int[] array = new int[len];
        System.out.println("Enter element of array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("arr[" + i + "] = ");
            array[i] = getIntegerInRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (i < array.length - 1) {
                System.out.print("Do you want to continue?(Y/N): ");
                if (checkYN() == false) {
                    break;
                }
            }
        }
        System.out.print("Enter value: ");
        int value = getIntegerInRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            }
        }
        System.out.println("Amount of frequence: " + count);
        System.out.print("Indexs: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");

    }

}
