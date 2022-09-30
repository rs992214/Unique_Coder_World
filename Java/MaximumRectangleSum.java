import java.util.Arrays;
import java.util.Scanner;

// Reference : https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/


public class MaximumRectangleSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int col = s.nextInt();
        int matrix[][] = new int[row][col];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        int maxSum=0;
        for (int left = 0; left<col;left++){
            int aux[] = new int[row];
            for(int right = left;right<col;right++){
                for (int i = 0; i <row ; i++) {
                    aux[i] += matrix[i][right];
                }
               // System.out.println("Left"+left+" Right"+right);
                maxSum = Math.max(maxSum,findMaxSum(aux));
            }
        }
        System.out.println(maxSum);
    }
    public static int findMaxSum(int a[]){
        int sum = 0;
        int currSum= 0;
        for (int i = 0; i <a.length ; i++) {
            currSum = currSum+a[i];
            sum = Math.max(sum,currSum);
            if(currSum<0)
                currSum=0;
        }
       // System.out.println(Arrays.toString(a));
       // System.out.println(sum);
        return sum;
    }
}
