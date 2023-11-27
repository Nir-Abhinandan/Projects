public class IdentifyGenerationName {

  
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the year you were born: ");
      int year= sc.nextInt();
      if (year>=1946 && year<=1964){
          System.out.println("You are a baby boomer");
      }
      else if (year>=1965 && year<=1980){
              System.out.println("You are a Gen X");
              }
      else if (year>=1981 && year<= 1996){
                 System.out.println("You are a Millenial");
            }
      else if (year>=1997 && year<2012){
          System.out.println("You are a Gen Z");
      }
      else if (year>=2012 && year<=2024){
          System.out.println("You are a Gen A");
      }
           if (year<1946 || year>2024){
               System.out.println("You are too old or too young to have a generation name");
           }
               
    }
    
}
