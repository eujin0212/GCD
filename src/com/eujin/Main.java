package com.eujin;
import java.util.*;
import java.lang.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int x,y;

    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }

    public static int gcdFormula(int a, int b)
    {
        if (a>b){
            if (b == 0)
                return b;
            System.out.println(a + "=" + a/b + "(" + b + ")" + "+" + (a-((a/b)*b)));
            return gcdFormula(b%a, (a-((a/b)*b)));
        }else{
            if (b == 0)
                return b;
            System.out.println(a + "=" + a/b + "(" + b + ")" + "+" + b);
            return gcdFormula(b, a);
        }
    }

    public static void main(String[] args){

        System.out.print("Please input x: ");
        x = scanner.nextInt();
        System.out.print("Please input y: ");
        y = scanner.nextInt();
        int g, f;

        g = gcd(x, y);
        f = gcdFormula(x, y);
        System.out.println("GCD(" + x + " , " + y+ ") = " + g);
    }

}

// Code Contributed by Mohit Gupta_OMG <(0_o)>

