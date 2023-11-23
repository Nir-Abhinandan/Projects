import java.util.ArrayList;
public class ConnectFourTester{
    public static void main(String[] args){
  final int ROWS = 6;
    final int COLS = 7;
    final char PLAYER1 = 'R';
    final char PLAYER2 = 'B';
    final char EMPTY = '_';
  
    ConnectFour c4 = new ConnectFour();
    ArrayList<Coordinate> list = new ArrayList<Coordinate>();
    c4.displayBoard();
    
    //Test DropPiece
    System.out.println(c4.dropPiece(3,PLAYER1));
    System.out.println(c4.dropPiece(3,PLAYER2));
    System.out.println(c4.dropPiece(3,PLAYER1));
    System.out.println(c4.dropPiece(3,PLAYER2));
    System.out.println(c4.dropPiece(3,PLAYER1));
    System.out.println(c4.dropPiece(3,PLAYER2));
    System.out.println(c4.dropPiece(3,PLAYER1));
    System.out.println(c4.dropPiece(5,PLAYER2));
    c4.displayBoard();
    c4.clearBoard();
    
    c4.randomFillBoard(25);
    c4.displayBoard();

    
    //Test DropPiece again
    System.out.println(c4.dropPiece(3,PLAYER1));
    c4.displayBoard();
    
    //Check for Winner:
    System.out.println("Horizontal: "+c4.checkHorizontal());
    System.out.println("Vertical: "+c4.checkVertical());
    System.out.println("Down Diagonal: "+c4.checkDownDiagonal());
    System.out.println("Up Diagonal: "+c4.checkUpDiagonal());
    
    //test Vertical
    c4.clearBoard();
    list.add(new Coordinate(1,4));
    list.add(new Coordinate(2,4));
    list.add(new Coordinate(3,4));
    list.add(new Coordinate(4,4));
    c4.fillBoard(list,PLAYER1);
    c4.displayBoard(); 
    System.out.println("Vertical: "+c4.checkVertical());
    
    
    list = new ArrayList<Coordinate>();
    c4.clearBoard();
    list.add(new Coordinate(1,1));
    list.add(new Coordinate(1,2));
    list.add(new Coordinate(1,3));
    list.add(new Coordinate(1,4));
    c4.fillBoard(list,PLAYER2);
    c4.displayBoard(); 
    System.out.println("Horizontal: "+c4.checkHorizontal());
 
    list = new ArrayList<Coordinate>();
    c4.clearBoard();
    list.add(new Coordinate(0,1));
    list.add(new Coordinate(1,2));
    list.add(new Coordinate(2,3));
    list.add(new Coordinate(3,4));
    c4.fillBoard(list,PLAYER1);
    c4.displayBoard(); 
    System.out.println("DownDiagonal: "+c4.checkDownDiagonal());

    list = new ArrayList<Coordinate>();
    c4.clearBoard();
    list.add(new Coordinate(5,0));
    list.add(new Coordinate(4,1));
    list.add(new Coordinate(3,2));
    list.add(new Coordinate(2,3));
    c4.fillBoard(list,PLAYER2);
    c4.displayBoard(); 
    System.out.println("upDiagonal: "+c4.checkUpDiagonal());

    //Add your own code to test the algorithms here:
  }
  
  
}