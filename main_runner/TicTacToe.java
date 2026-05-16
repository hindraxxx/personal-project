public class TicTacToe {

  public static void main(String[] args) {
    TictactoeBoard game = new TictactoeBoard();

    game.input("X", 0, 0);
    game.input("O", 1, 0);
    game.input("X", 0, 1);
    game.input("O", 1, 1);
    game.input("X", 0, 2); // X wins by first column
    game.input("0", 1, 2); // X wins by first column
  }


}
