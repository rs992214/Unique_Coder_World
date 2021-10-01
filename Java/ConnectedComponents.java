import java.util.*;
public class ConnectedComponents {
    static int a[][],m,n;
    static boolean vis[][];
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
         n=s.nextInt();
         m=s.nextInt();
        a=new int[n][m];
        vis = new boolean[n][m];
       String str[]=new String[n];
       int countdot=0;
        for (int i = 0; i <n ; i++) {
            String st=s.next();
            char ch[] =st.toCharArray();
            for (int j = 0; j <m ; j++) {
                if(ch[j]=='#')
                a[i][j]=0;
                else if(ch[j]=='.') {
                    a[i][j] = 1;
                    countdot++;
                }
            }
        }
        if(countdot==m*n)
            System.out.println(1);
        else
        System.out.println(findValue(a));
    }
    public static int findValue(int a[][]){
        int count=0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length ; j++) {
                if(!vis[i][j]&&a[i][j]==1)
                {
                    count++;
                    dfs(i,j);
                }
            }
        }
        return count;

    }
    public static void dfs(int x,int y){
       vis[x][y] = true;
       if(isValid(x-1,y))
           dfs(x-1,y);
       if(isValid(x+1,y))
           dfs(x+1,y);
       if(isValid(x,y+1))
           dfs(x,y+1);
        if(isValid(x,y-1))
            dfs(x,y-1);
    }
    public static boolean isValid(int x,int y){
        if(x<0||x>n-1||y<0||y>m-1)
            return false;
        if(vis[x][y]==true||a[x][y]==0)
            return false;
        return true;
    }
}
