import java.util.Scanner;
public class Main {

    public static double average(int a,int b){
       
        double avg =  ((double)a+(double)b)/2.0;
        return avg;
        
        
    }

    public static double average(double ia, double ib){
       
        double iavg =  (ia+ib)/2;
        return iavg;
    }
    
    public static String firstlast(String s){
         //s = "";
         String rs = "";
        int n = s.length();
        
        if(n == 0) return rs;

        char first = s.charAt(0);
        char last = s.charAt(n - 1);
        
        //System.out.println(first+","+last);
        rs = rs+first+last;
    
       
        return rs;
    }
    public static String reverse(String w){
        //w = "8o5o587";
        String rw="";
        char c;
        for (int i=0; i<w.length(); i++)
      {
        c= w.charAt(i);
        rw= c+rw;
      }
      System.out.println(rw);
      return rw;
    }
    public static void main(String[] args) {
            System.out.println(average(10,12));
            System.out.println(average(5,6));
            
            System.out.println( firstlast("lhjkk"));
            reverse("");
        

        
        
        
    }
    

    

}
