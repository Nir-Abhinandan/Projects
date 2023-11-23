
import java.util.Scanner;
import java.util.Arrays;
public class AdventureGame{
    private static boolean doneWithGame;
    private static World w;
    private static Scanner kb;
    private static Player player;
    public static void main(String[] args){
        kb = new Scanner(System.in);
        System.out.println("What is your name?"); 
        String name = kb.nextLine();
        player = new Player(name);
        w = new World(player);
        System.out.println("What do you do?");
        doneWithGame=false;
        //Game loop, parsing of inputs is done in the parseInput function
        while (!doneWithGame){
            String input = kb.nextLine();
            parseInput(input);
        }

        
    }
    //Called in World.java to end the game
    public static void endGame(){
        doneWithGame=true;
    }
    public static void parseInput(String in){
        //splits user input into an array of 2 strings--one which contains the first word, which is the verb, and one which contains the rest of the input.
        String[] arrOfStr = in.split(" ",2);
        
            

        if (arrOfStr[0].equals("grab")){
            if (arrOfStr.length==1){
                System.out.println("Grab what?");
                w.grab(kb.nextLine());
            }
            else{
                w.grab(arrOfStr[1]);
            }
        }
        else if (arrOfStr[0].equals("drop")){
            if (arrOfStr.length==1){
                System.out.println("Drop what?");
                w.grab(kb.nextLine());
            }
            else{
                w.drop(arrOfStr[1]);
            }
        }
        else if (arrOfStr[0].equals("look")){
            w.look();
        }
        else if (arrOfStr[0].equals("fight")){
            if (arrOfStr.length==1){
                System.out.println("Fight what?");
                w.fight(kb.nextLine());
            }
            else{
                w.fight(arrOfStr[1]);
            }
        }
        else if (arrOfStr[0].equals("inventory")){
            w.checkInventory();
        }
        else if (arrOfStr[0].equals("move")){
            if (arrOfStr.length==1){
                System.out.println("Move where?");
                w.changeCurrentRoom(kb.nextLine());
            }
            else{
                w.changeCurrentRoom(arrOfStr[1]);
            }
            //System.out.println("You are now in "+w.getCurrentRoom());
        }
        else if (arrOfStr[0].equals("help")){
            System.out.println("List of commands:");
            System.out.println("\tgrab: grabs an item, if one is within reach.\n\tdrop: drops an item from your inventory.\n\tlook: look around and view your surroundings.\n\tfight: fight a creature, if one is in sight.\n\tinventory: displays a list of items in your inventory.\n\tmove: move from one room to another\n\texits: display a list of exits available");
        } else if (arrOfStr[0].equals("exits")){
            w.getExits();
        }
        else {
            //If user passes in a command that is unknown, check through the backpack to see if there is an action with the same command, otherwise print out the list of commands
            BackPack bp = player.getBackPack();
            for (Item i : bp){
                for (Action a : i.getActions()){
                    if (a.getName().equals(arrOfStr[0])){
                        parseInput(a.getParsedAction());
                        return;
                    }
                }
            }
            System.out.println("List of commands:");
            System.out.println("\tgrab: grabs an item, if one is within reach.\n\tdrop: drops an item from your inventory.\n\tlook: look around and view your surroundings.\n\tfight: fight a creature, if one is in sight.\n\tinventory: displays a list of items in your inventory.\n\tmove: move from one room to another\n\texits: display a list of exits available");
        }
    }
    
}
