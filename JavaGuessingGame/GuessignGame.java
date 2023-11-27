import java.util.Scanner;
public class gmn {

    public static void main(String[] args) {
        // final means the value won't ever change
        //Math.random() returns a double between 0 and 0.999999999
        final int number = (int)(Math.random()*100) + 1;
        
        Scanner s = new Scanner(System.in);
        System.out.println("What is your guess: ");
        int ans=-1;
        int count = 1;
        while(ans!=number){
            
            
             ans = s.nextInt();
             count++;
             if(ans<number){
                 System.out.println("Guess higher");
                
             }
             if(ans>number){
                 System.out.println("Guess lower");
             }
             
             
        }
        
        System.out.println("Your right! the number was " + number);
        System.out.println("it took you "  + count + " tries");
        

    }

}
