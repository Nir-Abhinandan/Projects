public class RockpaperScissos {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random(); 
        int ranNum = 1+r.nextInt(2);
        System.out.println("What will you put?,(1 is rock, 2 is paper, 3 is scissors): ");
        int choice = sc.nextInt();
        if (choice == 1) {
           System.out.println("You chose rock");
        }
        else if(choice==2){
            System.out.println("You chose paper");
        }
        else {
            System.out.println("You chose scissors");
        }
        switch(ranNum){
            case 1:
                if(ranNum == 1 && choice == 1){
                    System.out.println("The computer chose rock");
                    System.out.println("The game ends in a tie");
                }
                if(ranNum == 1 && choice == 2){
                    System.out.println("The computer chose rock");
                    System.out.println("You win!");
                }
                if(ranNum == 1 && choice == 3){
                    System.out.println("The computer chose rock");
                    System.out.println("You lose!");
                }
                break;
            case 2:
                if(ranNum == 2 && choice == 1){
                    System.out.println("The computer chose paper");
                    System.out.println("You lose!");
                }
                if(ranNum == 2 && choice == 2){
                    System.out.println("The computer chose paper");
                    System.out.println("Its a tie!!");
                }
                if(ranNum == 2 && choice == 3){
                    System.out.println("The computer chose rock");
                    System.out.println("You win!");
                }
                break;
            case 3:
                if(ranNum == 3 && choice == 1){
                    System.out.println("The computer chose scissors");
                    System.out.println("You lose!");
                }
                if(ranNum == 3 && choice == 2){
                    System.out.println("The computer chose scissors");
                    System.out.println("You win!");
                }
                if(ranNum == 3 && choice == 3){
                    System.out.println("The computer chose scissors");
                    System.out.println("Its a tie!");
                }
                break;
        }
    }
    
}
