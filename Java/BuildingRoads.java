import java.util.*;
public class BuildingRoads {
    static int adj[][];
    static int m,n;
    static boolean vis[][];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n =s.nextInt();
        m=s.nextInt();
        adj=new int[n][n];
        vis =new boolean[n][n];
        Nodes [] nodes =new Nodes[m];
        for (int i = 0; i <m ; i++) {
            nodes[i]=new Nodes();
            int a =s.nextInt();
            int b=s.nextInt();
            Nodes node=new Nodes();
            node.a=a;
            node.b=b;
            nodes[i]=node;
            adj[a-1][b-1]=1;
            adj[b-1][a-1]=1;
        }
        // System.out.println(Arrays.toString(nodes));
        int cnt=0;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <nodes.length ; i++) {
            Nodes node = nodes[i];
            int x =node.a;
            int y=node.b;
            x--;
            y--;
            if(!vis[x][y]&&adj[x][y]==1) {
                cnt++;
                int value = BFS(x,y);
                value++;
                list.add(value);

            }
        }
        System.out.println(list.size()-1);
        for (int i = 1; i <list.size() ; i++) {
            System.out.println(list.get(0)+" "+list.get(i));
        }


    }
    public static int  BFS(int x,int y){
        vis[x][y]=true;
        if(isValid(x+1,y))
            BFS(x+1,y);
        if(isValid(x-1,y))
            BFS(x-1,y);
        if(isValid(x,y+1))
            BFS(x,y+1);
        if(isValid(x,y-1))
            BFS(x,y-1);
        return x;

    }
    public static boolean isValid(int x,int y){
        if(x<0||x>n-1||y<0||y>m-1)
            return false;
        if(vis[x][y]==true||adj[x][y]==0)
            return false;
        return true;
    }
}
class Nodes{
    int a;
    int b;

    @Override
    public String toString() {
        return "Nodes{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
