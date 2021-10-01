import java.util.*;
public class VirusTransmission {
    static char a[][];
    static int vis[][];
    static int dis[][];
    static int m,n;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0) {
             m = s.nextInt();
             n = s.nextInt();
             a = new char[m][n];
            for (int i = 0; i <m ; i++) {
                String str = s.next();
                a[i] = str.toCharArray();
            }


        }

    }
    public static void dfs(int sourceX,int sourceY){

    }
    public static boolean isValid(int x,int y){
        if(x<0||x>m-1||y<0||y>n-1)
            return false;
        if(vis[x][y]==1||a[x][y]=='_'||a[x][y]=='0')
            return false;
        return true;
    }
}
