package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        System.out.println(calc(number));

    }
    static int pars(String number) throws Exception {
        int num = -1;
        switch (number) {
            case ("I"):
                num = 1;
                break;
            case ("II"):
                num = 2;
                break;
            case ("III"):
                num = 3;
                break;
            case ("IV"):
                num = 4;
                break;
            case ("V"):
                num = 5;
                break;
            case ("VI"):
                num = 6;
                break;
            case ("VII"):
                num = 7;
                break;
            case ("VIII"):
                num = 8;
                break;
            case ("IX"):
                num = 9;
                break;
            case ("X"):
                num = 10;
                break;
        }
        return num;

    }
    final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    final static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }
    public static String calc(String input) throws Exception {
        String[] str = input.split(" ");
        if(str.length!=3){
            throw new Exception("throws Exception");
        }
        int first = 0;
        int second = 0;
        boolean status = false;
        try{
            first  = Integer.parseInt(str[0]);
            second = Integer.parseInt(str[2]);

        }catch (Exception e){

            first = pars(str[0]);
            second = pars(str[2]);
            status = true;

            if(first == -1 || second == -1){
                throw new Exception("throws Exception");
            }


        }


        int itog = 0;
        if(first<=10 && first >=1 && second<=10 && second >=1) {
            switch (str[1]) {
                case ("+"):
                    itog  = first + second;
                    break;
                case ("-"):
                    itog  = first - second;
                    break;
                case ("*"):
                    itog  = first * second;
                    break;
                case ("/"):
                    itog  = first / second;
                    break;
            }
        }else{
            throw new Exception("throws Exception");
        }
        if(status){
            if(itog >0){
                String res  = toRoman(itog);
                return res;
            } else{
                throw new Exception("throws Exception");
            }
        }else {
            return Integer.toString(itog);
        }

    }


}
