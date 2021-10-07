import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReadWriteChar {

 

    public static void main(String[] args) throws IOException{
        FileReader in=null;
        FileWriter out1=null;
        FileWriter out2=null;
        int count1 = 0;
        int count2 = 0;
        try
        {
            in=new FileReader("D://MyFiles/File1.txt");
            out1=new FileWriter("D://MyFiles/vowels.txt");
            out2=new FileWriter("D://MyFiles/consonants.txt");

            int c;
            while((c=in.read())!=-1)
            {
            	char ch = (char)c;
            	  if(( ch == 'a') ||( ch == 'e') ||( ch == 'i') ||( ch == 'o') ||( ch == 'u') || ( ch == 'A') ||( ch == 'E') ||( ch == 'I') ||( ch == 'O') ||( ch == 'U')) 
            	    {
            		  out1.write(ch);
            		  count1++;
            	    }
            	  else
            	  {
            		  out2.write(ch);
            		  count2++;
            	  }
            }
            System.out.println("Characters are seperated");
            System.out.println("Vowels Count: "+count1);
            System.out.println("Consonants Count: "+count2);
        }
        catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
        finally
        {
            if(in!=null)
            	in.close();
            if(out1!=null)
            	out1.close();
            if(out2!=null)
                out2.close();
        }

 

    }

 

}
 