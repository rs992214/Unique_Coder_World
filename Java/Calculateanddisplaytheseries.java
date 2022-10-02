/*
Program to find sum of series 1 + 1/2 + 1/3 + 1/4 + .. + 1/n
*/

import javax.swing.JOptionPane;

public class Calculateanddisplaytheseries 


{
    public static void main(String[] args) {
        double n,r;
        n = Double.parseDouble(JOptionPane.showInputDialog("Enter any number"));
        r = 0;
        for (double i = 1;i<=n;i++) {
            r = r + (1/i);
        }
        JOptionPane.showMessageDialog(null, r, "1/1+1/2+...+1/N", JOptionPane.INFORMATION_MESSAGE);
    }
}