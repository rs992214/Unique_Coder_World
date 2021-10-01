import java.io.*;
import java.util.*;
class PathFinding{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    static char a[][];
    static int vis[][];
    static int dis[][];
    static int m,n;
    public static void main(String[] args) throws FileNotFoundException {
        long ts = System.currentTimeMillis();
        FastReader s = new FastReader();
         m =s.nextInt();
         n=s.nextInt();
        int startX=0,startY=0,endX=0,endY=0;
        a =new char[m+1][n+1];
        vis=new int[m+1][n+1];
        dis =new int[m+1][n+1];
        for (int i = 0; i <m ; i++) {
            String str=s.next();
            char ch[]=str.toCharArray();
            for (int j = 0; j <n ; j++) {
                a[i][j]=ch[j];
                if(ch[j]=='A'){
                    startX=i;
                    startY=j;
                }
               else if(ch[j]=='B')
                {
                    endX =i;
                    endY=j;
                }
            }
        }
        String path = BFS(startX,startY,endX,endY);
        if(path!=null) {
            System.out.println("YES");
            System.out.println(dis[endX][endY]);
            System.out.println(path);
        }
        else{
            System.out.println("NO");
        }

       // System.out.println(System.currentTimeMillis() - ts);
    }
    public static String BFS(int startX,int startY,int endX,int endY){
        Queue<Pair> queue=new LinkedList<>();
        Pair pair=new Pair();
        pair.x=startX;
        pair.y=startY;
        pair.path = "";
        queue.add(pair);
        vis[startX][startY]=1;
        dis[startX][startY]=0;
        while (!queue.isEmpty()){
            pair = queue.poll();
            int x=pair.x;
            int y=pair.y;
            String path = pair.path;
            if(x==endX&&y==endY)
                return path;
            if(isValid(x,y-1))
            {
                Pair p1=new Pair();
                p1.x=x;
                p1.y=y-1;
                p1.path = path + "L";
                queue.add(p1);
                vis[x][y-1]=1;
                dis[x][y-1]=dis[x][y]+1;
            }
            if(isValid(x-1,y))
            {
                Pair p1=new Pair();
                p1.x=x-1;
                p1.y=y;
                p1.path = path + "U";
                queue.add(p1);
                vis[x-1][y]=1;
                dis[x-1][y]=dis[x][y]+1;
            }
            if(isValid(x,y+1))
            {
                Pair p1=new Pair();
                p1.x=x;
                p1.y=y+1;
                p1.path = path + "R";
                queue.add(p1);
                vis[x][y+1]=1;
                dis[x][y+1]=dis[x][y]+1;
            }

            if(isValid(x+1,y))
            {
                Pair p1=new Pair();
                p1.x=x+1;
                p1.y=y;
                p1.path = path + "D";
                queue.add(p1);
                vis[x+1][y]=1;
                dis[x+1][y]=dis[x][y]+1;
            }


        }
        return null;
    }
    public static boolean isValid(int x,int y){
        if(x<0||x>m-1||y<0||y>n-1)
            return false;
        if(vis[x][y]==1||a[x][y]=='#')
            return false;
        return true;
    }

}
class Pair{
    int x;
    int y;
    String path;
}
