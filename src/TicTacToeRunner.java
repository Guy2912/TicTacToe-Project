import javax.swing.JFrame;

public class TicTacToeRunner {

    public static void main(String args[])
    {
        JFrame frame = new TicTacToeFrame();
        frame.setTitle("Tic Tac Toe Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}