import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToeFrame extends JFrame
{
    private static final GridLayout LAYOUT = new GridLayout(3,3);
    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;

    private JButton buttons[] = new JButton[10], quitBtn;
    private JPanel wholePanel, boardPanel, titlePanel;
    private JLabel title;
    private int turns = 0;
    private String letter = "";
    private boolean win = false;

    public TicTacToeFrame()
    {
        createQuitButton();
        createTitlePanel();
        createBoardPanel();
        createWholePanel();
        findHorzWins();
        findVertWins();
        findDiagWins();
        showResults();

        //รับความกว้างของหน้าจอ
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        //กำหนดขนาดหน้าจอเป็นครึ่งหนึ่งของความสูงและความกว้างของหน้าจอ และ จัดกึ่งกลาง
        setSize(WIDTH, HEIGHT);
        setLocation(screenWidth / 4, screenHeight / 4);

    }

    private void createQuitButton() //สร้างปุ่มกดออกจากหน้าต่าง UI 
    {
        quitBtn = new JButton("-- Quit --");
        quitBtn.setFont(new Font(Font.SERIF, 0, 24));

        class QuitListener implements ActionListener
        {

            @Override
            public void actionPerformed(ActionEvent ae) //เมื่อกดแล้วให้ exit จากหน้าต่าง UI
            {
                System.exit(0);
            }

        }

        ActionListener quitListener = new QuitListener();//add quitListener ไปใน quitBtn เพื่อไปใช้ต่อใน createWholePanel();
        quitBtn.addActionListener(quitListener);
    }

    private void createTitlePanel() //สร้าง คำว่า Welcome to my Tic Tac Toe Game! โดยที่ setFont style size 
    {                               //แล้ว add title ไปใน titlePanel เพื่อไปใช้ต่อใน createWholePanel();
        title = new JLabel("Welcome to my Tic Tac Toe Game!");
        titlePanel = new JPanel();
        title.setFont(new Font(Font.SERIF, 0, 30));
        titlePanel.add(title);
    }

    private void createBoardPanel() //สร้าง board TicTacToe
    {
        boardPanel = new JPanel();
        boardPanel.setLayout(LAYOUT);

        class ButtonListener implements ActionListener
        {

            @Override
            public void actionPerformed(ActionEvent ae)
            {
                showResults();
                turns++;
                if(turns % 2 == 0)
                {
                    letter = "O";
                }
                else {
                    letter = "X";
                }

                JButton pressedButton = (JButton)ae.getSource();
                pressedButton.setText(letter);                   //ให้ปุ่มรับค่า latter ได้จาการกดปุ่ม ทุก turns ที่หาร 2 ลงตัวจะเป็น O ถ้าไม่ใช้ก็ X
                pressedButton.setEnabled(false);
            }

        }
        ActionListener buttonListener = new ButtonListener();  //สร้าง Object new ButtonListener(); ใช้ for loop เพื่อสร้างปุ่มจำนวน 9 ปุม 
        for(int i=1; i<=9; i++)                                //add buttonListener ลงใน button[i] และ add button[i] ลงใน boardPanel เพื่อไปใช้ต่อใน createWholePanel();
        {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font(Font.SERIF, 0, 24));
            buttons[i].addActionListener(buttonListener);
            boardPanel.add(buttons[i]);
        }
    }

    private void createWholePanel() //จัดเรียงหน้า UI setLayout สร้าง Object new BorderLayout 
    {                               //และ add titlePanel ไว้บนสุด add bordPanel ไว้ตรงกลาง add quitBtn ไว้ล่างสุด
        wholePanel = new JPanel();
        wholePanel.setLayout(new BorderLayout());
        wholePanel.add(titlePanel, BorderLayout.NORTH);
        wholePanel.add(boardPanel, BorderLayout.CENTER);
        wholePanel.add(quitBtn, BorderLayout.SOUTH);
        add(wholePanel);
    }

    public void findHorzWins() //checkwin ตามแถว
    {
        if (buttons[1].getText().equals(buttons[2].getText()) && buttons[2].getText().equals(buttons[3].getText()) && buttons[1].getText().equals("")==false)
        {
            win=true; //check ตามแถวที่ 1,2,3 ตามระดับ buttons.getText() เปรียบเทียบ buttons.getText()
            //equals มีparameter anObject วัตถุจะเปรียบเทียบกับ String(getText) ,== false return เป็นอย่างอื่น win=true
        }

        else if (buttons[4].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[6].getText()) && buttons[4].getText().equals("")==false)
        {
            win=true;
        }

        else if (buttons[7].getText().equals(buttons[8].getText()) && buttons[8].getText().equals(buttons[9].getText()) && buttons[7].getText().equals("")==false)
        {
            win=true;
        }
    }

    public void findVertWins()//checkwin ตามคอลัมภ์
    {
        if (buttons[1].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[7].getText()) && buttons[1].getText().equals("")==false)
        {
            win=true;//check ตามคอลัมภ์ที่ 1,4,7 ตามระดับ buttons.getText() เปรียบเทียบ buttons.getText()
            //equals มีparameter anObject วัตถุจะเปรียบเทียบกับ String(getText) ,== false return เป็นอย่างอื่น win=true

        }

        else if (buttons[2].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[8].getText()) && buttons[2].getText().equals("")==false)
        {
            win=true;

        }

        else if (buttons[3].getText().equals(buttons[6].getText()) && buttons[6].getText().equals(buttons[9].getText()) && buttons[3].getText().equals("")==false)
        {
            win=true;

        }
    }

    public void findDiagWins() //checkwin ตามแนวทแยงมุม
    {
        if (buttons[1].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[9].getText()) && buttons[1].getText().equals("")==false)
        {
            win=true;//check ตามแนวทแยงมุมที่ 1,5,9 ตามระดับ buttons.getText() เปรียบเทียบ buttons.getText()
            //equals มีparameter anObject วัตถุจะเปรียบเทียบกับ String(getText) ,== false return เป็นอย่างอื่น win=true
        }

        else if (buttons[3].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[7].getText()) && buttons[3].getText().equals("")==false)
        {
            win=true;
        }
    }

    public void showResults() //methods นี้ไว้เช็ค turns 
    {
        if(turns>=5) //เมื่อผ่านไป 5 turns ให้ check methodsตามด้านล่าง 
        {
            findHorzWins();
            findVertWins();
            findDiagWins();

            if (win==true) //ถ้า win จริงให้โชว์ การทำงาน gameOver();
            {
                gameOver();
            }

            else if (turns==8 && win==false) //ถ้า turns = 8 หรือ ไม่มี win เลย ให้ showMessage
            {
                JOptionPane.showMessageDialog(null, "The game is a tie."); //parentComponent กำหนดเฟรมที่แสดงไดอะล็อก 
                System.exit(0);                                                             //ถ้า null หรือถ้า parentComponent ไม่มี Frame จะใช้ Frame เริ่มต้น
            }
        }
    }
    public void gameOver() { //methods นี้ไว้ ShowOption YES_NO_OPTION 
        JOptionPane pane = new JOptionPane();
        int dialogResult = JOptionPane.showConfirmDialog(pane, "Game Over. "+ letter + " wins. Would you like to play again?","Game over.",JOptionPane.YES_NO_OPTION);

        if(dialogResult == JOptionPane.YES_OPTION) {          //ถ้าเลือก Yes Option ให้ทำงาน new TicTacToeFrame();
            this.dispose(); // close the current frame
            TicTacToeFrame newGame = new TicTacToeFrame();
            newGame.setVisible(true);
        } else {                                              //ถ้าเลือก No Option ให้ Runtime exit
            System.exit(0);
        }
    }
}