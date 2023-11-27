import java.util.*;
import java.io.*;

public class WordleMain{
  
  private static int wordSize = 5;
  private static char CORRECTPOSITION = '*';
  private static char WRONGPOSITION = '#';
  private static char NOTINWORD = '_';



  
  private static ArrayList<String> words = new ArrayList<String>();
  private static ArrayList<String> unusedLetters = new ArrayList<String>();
  private static String letters = "abcdefghijklmnopqrstuvwxyz";
  

  //MyFileReader3
  //  MyFileReader3() constructor  (asks for file name, uses " (),.\"\'`:[]{};?!=-/" to parse file)
  //  MyFileReader3(String parseString) constructor (asks for file name)
  //  MyFileReader3(String fn, String parseString)
  //
  //  boolearn hasNext() return boolean true if more words in file
  //  String next() returns the next word (String) from file
  //
  // must have "throws FileNotFoundException, IOException { "
  //    after function parameters.
  
  // Modify code to suit your needs (see "***" below)
  //
    public static void main (String[] args)
    throws FileNotFoundException, IOException 
  {
      
      
      int nextWord = 0;
    MyFileReader3 f = null;   
    try{
      f = new MyFileReader3("dictionary.txt"," (),.\"\'`:[]{};?!=-/");
      while (f.hasNext()){
        String s = f.next();
        if(s.length()==wordSize){
        words.add(s.toLowerCase());
        nextWord++;
        }
        
        
      }
      playGame(words, nextWord);
    }
    catch(Exception e)
    {
      System.out.println("catching error:");
      System.out.println(e.getMessage());
      System.out.println("done catching error");
    }  
  }
  public static void playGame(ArrayList<String> words, int totalWords){
    for(int i =0; i<letters.length(); i++){
      unusedLetters.add(letters.substring(i,i+1));
    }
    Random r = new Random();
    int w = r.nextInt(totalWords);
    String wordle = words.get(w);
    Scanner s = new Scanner(System.in);
    int guesses =1;
    int maxGuesses =6;
    while(true){
        System.out.println("Guess the word: ");
        String guess = s.nextLine();
        
        System.out.println(wordle);
        if(guess.length()==wordle.length()){
            checkWord(guess, wordle);
        }
        if(guess.equals(wordle)){
            System.out.println("You guessed the word!");
            System.out.println("it took you:"+ guesses + " tries");
            System.exit(0);
        }
        
        if(guesses==maxGuesses){
            System.out.println("You failed to guess the word in 6 guesses");
                System.exit(0);
        }
        if(!(words.contains(guess)) || guess.length()<wordle.length() || guess.length()>wordle.length()){
            System.out.println("Your guess is not a valid word, try again ");
                guesses--;
            
        }
        
        
        guesses++;
        
    }
    
}
  public static String checkWord(String guess, String wordle) {
    String result = "";
    boolean[] used = new boolean[wordle.length()];
    boolean[] usedIncorrect = new boolean[wordle.length()];
    ArrayList<Integer> repeatLetters = new ArrayList<Integer>(); 
    for (int i = 0; i < guess.length(); i++) {
        if (guess.charAt(i) == wordle.charAt(i)) {
            result += CORRECTPOSITION;
            used[i] = true;
            unusedLetters.remove(guess.substring(i, i + 1));
            repeatLetters.add(i);
        } 
        else if (wordle.contains(guess.substring(i, i + 1))) {
            int index = wordle.indexOf(guess.charAt(i));
            boolean correctPosition = false;
            while (index != -1) {
                if (!used[index] && !usedIncorrect[index] && !repeatLetters.contains(index)) { 
                    if (!correctPosition) {
                        result += WRONGPOSITION;
                        usedIncorrect[index] = true;
                        unusedLetters.remove(guess.substring(i, i + 1));
                        break;
                    } 
                    else {
                        result += WRONGPOSITION;
                        unusedLetters.remove(guess.substring(i, i + 1));
                        break;
                    }
                } 
                else if (used[index]) {
                    correctPosition = true;
                }
                 index = wordle.indexOf(guess.charAt(i), index + 1);
            }
            if (index == -1) {
                result += NOTINWORD;
            }
        } 
        else {
            result += NOTINWORD;
        }
    }
    System.out.println(result);
    System.out.println(unusedLetters);
    return result + " " + unuse dLetters;
    }
}
