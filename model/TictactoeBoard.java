import java.util.Objects;

public class TictactoeBoard {
  int[][] slot;
  int[] countRows = new int[3];
  int[] countCols = new int[3];
  int countDiagonalUp = 0;
  int countDiagonalDown = 0;
  State boardState = State.RUNNING;


  private enum State{
    RUNNING,
    ENDED
  }
  TictactoeBoard() {
    this.slot = new int[3][3];
  }

  private Boolean validateInput(int column, int row) {
    if(column < 0 || column > 2 || row < 0 || row > 2 ) {
      return false;
    }

    if(slot[column][row] != 0  ){
      return false;
    }

    slot[column][row] = 1;
    return true;
  }

  private Boolean boardIsFull() {
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(slot[i][j] == 0) {
          return false;
        }
      }
    }
     return true;
  }

  public void input(String player, int col, int row) {


    if (boardIsFull() || !validateInput(col, row)) {
      System.out.println("Invalid input");
      return;
    }

    if(boardState != State.RUNNING) {
      System.out.println("Board is completed, no input is allowed");
      return;
    }

    System.out.println("Player " + player + " making an input on column: " + col + " row: " + row);

    int value = 0;
    if(Objects.equals(player, "X")){
      value = 1;
    }else{
      value = -1;
    }

    countRows[row] += value;
    countCols[col] += value;

    if(row == col){
      countDiagonalDown += value;
    }

    if(row+col == 2){
      countDiagonalUp +=value;
    }

    if(
        countDiagonalUp == -3 ||
        countDiagonalDown == -3 ||
        countRows[row] == -3 ||
        countCols[col] == -3
    ){
      boardState = State.ENDED;
      System.out.println("Game is finished, Player O Win");
    }else  if(countDiagonalUp == 3 ||
        countDiagonalDown == 3 ||
        countRows[row] == 3 ||
        countCols[col] == 3
    ){
      boardState = State.ENDED;
      System.out.println("Game is finished, Player X Win");
    } else if(boardIsFull()){
      boardState = State.ENDED;
      System.out.println("Game is tied, board is full");
    }else {
      System.out.println("Continuing next turn");

    }

  }
}
