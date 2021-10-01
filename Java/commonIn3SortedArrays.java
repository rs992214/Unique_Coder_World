//common elements in 3 sorted arrays

public class solution
{
    public static void main(String[] args)  
    { 
        
        int a[] = new int[]{1,2,3,4,5};
        int b[] = new int[]{1,7,8,9};
        int c[] = new int[]{1,12,6,11};
        
        int  i = 0 ,  j = 0 , k = 0;
        while((i < a.length) && ((j < b.length) && (k < c.length)))
        {
          if(a[i] == b[j] && c[k] == a[i]) 
          {
            System.out.print(a[i]+" ");
            i++; j++; k++;
          }
         
          else if(a[i] < b[j])
            i++;
          else if(b[j] < c[k])
            j++;
          else
            k++;
        }
    }
}