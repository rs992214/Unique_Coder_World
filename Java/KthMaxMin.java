package com.art;

import java.util.Scanner;

public class KthMaxMin {
    public static void main(String[] args) {
        int n,k;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array: ");
        n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the position of maximum: ");
        k = sc.nextInt();
        int loc = KthMax(arr,k);
        System.out.println(k + "st/nd/th maximum is: " + arr[loc]);
    }

    static int KthMax(int[] a,int k)
    {
        int temp = 0;
        //sorting the array
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 1; j < a.length; j++)
            {
                if (a[i] > a[j])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        int loc = a.length - k - 1;
        return loc;

    }
}
