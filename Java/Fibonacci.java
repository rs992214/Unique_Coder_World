class fibonacci {
    public static long fib(int x) {
        if(x<2)
        return x;
        int a=0,b=1,c=0;
        for(int i=2;i<=x;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }

    public static void main(String args[]) {
        int n=9;
        System.out.println("The "+n+"th Fibonacci number is: "+fib(n));
        
    }
}
