import java.util.*;
public class ConnectFour{
  private static final int ROWS = 6;
  private static final int COLS = 7;
  private static final char PLAYER1 = 'R';
  private static final char PLAYER2 = 'B';
  private static final char EMPTY = '_';
  
  private char[][] board;
  
  public ConnectFour(){
    
    board = new char[ROWS][COLS];
    clearBoard();
  }
  
  public void clearBoard(){
    for(int i =0; i < ROWS;i++)
      for(int j = 0; j < COLS; j++)
        board[i][j] = EMPTY;
  }
  
  //Complete
  //Place piece on board; returns false if 
  // column is full, otherwise true if successfully placed
  public boolean dropPiece(int col, char player) {
    for (int row = 0; row < ROWS; row++) {
        if (board[row][col] == ' ') {
            board[row][col] = player;
            return true;
        }
    }
    return false;
}
  
  //Only for testing purposes, won't be used when
  // actually plaing the game
  public void fillBoard(ArrayList<Coordinate> list, char player){
    char fillChar= player;

    
    for(Coordinate c:list){
      int x = c.getX();
      int y = c.getY();
      board[x][y] = fillChar;
    }
  }
  public void displayBoard(){
    for(int i =0; i < ROWS;i++){
      for(int j = 0; j < COLS; j++){
        System.out.print(""+board[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println();
  }
  
  //Complete the following 4 functions
  // returns first four-in-a-row/col/diagonal found,
  //   or "none" if neither player has won
  public char checkHorizontal(){
    for (int row = 0; row < ROWS; row++) {
        for (int col = 0; col < COLS - 3; col++) {
            //System.out.println(row+"  "+col);
            char start = board[row][col];
            if (start != EMPTY && start == board[row][col + 1] && start == board[row][col + 2] && start == board[row][col + 3]) {
                return start; 
            }
        }
    }
    return EMPTY;
  }
  
  //Complete
  public char checkVertical(){
    for(int i = 0; i < ROWS - 3; i++){
        for (int j = 0; j < COLS; j++) {
            //System.out.println(i+"  "+j);
            char start = board[i][j];
            if(start != EMPTY && board[i][j] == board[i+1][j] && board[i][j] == board[i+2][j]&& board[i][j]== board[i+3][j]){
                return start;
            }
        }

    
    }
    return EMPTY;
  }
  
  //Complete
  public char checkDownDiagonal(){
    for(int i = 0; i < ROWS - 4; i++){
        for (int j = 0; j < COLS - 3; j++) {
            
            char start = board[i][j];
            if(start != EMPTY && board[i][j] == board[i+1][j+1] && board[i][j] == board[i+2][j+2] && board[i][j]== board[i+3][j+3]){
                return start;
            }
        }

    
    }
    return EMPTY;
  }
  
  //Complete
  public char checkUpDiagonal(){
   for(int i = 3; i < ROWS; i++){
        for (int j = 0; j < COLS - 3; j++) {
            
            char start = board[i][j];
            if(start != EMPTY && board[i][j] == board[i-1][j+1] && board[i][j] == board[i-2][j+2] && board[i][j]== board[i-3][j+3]){
                return start;
            }
        }

    
    }
    return EMPTY;
  }
  
  
  
  
  public void randomFillBoard(int n){
    boolean toggle = false;
    for(int i= 0; i < n; i++){
       int x = (int)(Math.random()*ROWS);
       int y = (int)(Math.random()*COLS);
       
       while(board[x][y] != '_'){
          x = (int)(Math.random()*ROWS);
          y = (int)(Math.random()*COLS);
       }
       if(toggle)
          board[x][y] = PLAYER1;
       else
         board[x][y] = PLAYER2;
       toggle = !toggle;
     }
  }
  public static void main(String[] args) {
        
    }
}