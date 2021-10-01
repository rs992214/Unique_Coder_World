import java.util.*;
public class BfsExample {
    static int vis[]=new int[10001];
    static List<Integer> arr[] = new ArrayList[10001];
    static int dis[]=new int[10001];
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t =s.nextInt();
    while (t-->0){
        int m =s.nextInt();
        int n =s.nextInt();
        for (int i = 1; i <=m ; i++) {
            arr[i]=new ArrayList<>();
            vis[i]=0;
        }
        for (int i = 0; i <n ; i++) {
            int a=s.nextInt();
            int b=s.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        BFS(1);
        System.out.println(dis[m]);
       // System.out.println(Arrays.toString(dis));
    }

    }
    public static void BFS(int src){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        vis[src]=1;
        dis[src]=0;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            for(int child:arr[curr]){
                if(vis[child]!=1){
                    queue.add(child);
                    vis[child]=1;
                    dis[child]=dis[curr]+1;
                }
            }
        }
    }

}
