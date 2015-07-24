package tictactoe;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Game extends JFrame{
    int movesLeft;
    boolean gameNotOver;
    String currPlayer, winPlayer;
    private final  String AI = "O";
    private final String USER = "X";
    JButton[] buttons;
    private final int[][] line = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    JPanel panel;
    JButton start;
    JPanel board;




    public Game(){
        panel = new JPanel(new FlowLayout());
        start = new JButton("start");
        panel.add(start);
            start.addActionListener(new ButtonActionListener());
        setLayout(new BorderLayout(0, 0));
        add(panel, BorderLayout.CENTER);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

            Game game = new Game();
        }


    private void initialize() {
        currPlayer = USER;
        winPlayer = " ";
        movesLeft = 9;
        gameNotOver = true;

        for(int i = 0; i < 9; ++i){
                buttons[i].setText(" ");
        }
    }

    class TicTacToeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int currPos = 0;
            for (int i = 0; i < 9; ++i) {
                if (e.getSource() == buttons[i]) {
                    currPos = i;
                }
            }

            checkAndMakeMove(currPos);
            revalidate();

            if(gameNotOver) {
                currPos =  getMove()[1];
                System.out.println("making move: "+currPos + " MOVES LEFT: "+movesLeft);
                gameNotOver = true;
                checkAndMakeMove(currPos);
            }
        }
    }

    class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            board = new JPanel(new GridLayout(3, 3, 2, 2));
            buttons = new JButton[9];
            for(int i = 0; i < 9; ++i){
                    buttons[i] = new JButton();
                    buttons[i].addActionListener(new TicTacToeListener());
                    buttons[i].setForeground(Color.WHITE);
                    buttons[i].setBackground(Color.BLACK);
                    buttons[i].setFont(new Font("SansSerif", Font.BOLD, 50));
                    buttons[i].setText("O");
                    board.add(buttons[i]);
            }

            add(board, BorderLayout.CENTER);
            add(new JButton(new AbstractAction("New Game") {
                public void actionPerformed(ActionEvent e) {
                    initialize();
                }
            }), BorderLayout.SOUTH);
            initialize();

        }
    }

    private int[] getMove() {
        int[] result = minimax(2, AI, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[] {result[0], result[1]};
    }



    private int [] minimax  (int depth, String player, int alpha, int beta){
        ArrayList<Integer> nextMoves = generateMoves();

        int bestScore;
        int bestPos = -1;
        String opponent = (player == AI) ? "O" : AI;

        if (nextMoves.isEmpty() || depth == 0) {

            return new int[] {evaluate(), bestPos};

        }
        if(player.equals(AI)) {
            for (int i = 0; i < nextMoves.size(); ++i) {

                buttons[nextMoves.get(i)].setText(AI);
                bestScore = minimax(depth - 1, opponent, alpha, beta)[0];

                if (bestScore > alpha) {
                    alpha = bestScore;
                    bestPos = nextMoves.get(i).intValue();

                }
                buttons[nextMoves.get(i)].setText(" ");
                if (beta <= alpha) {
                    break;
                }
            }
                System.out.println("alpha " + alpha + ", bestpos " + bestPos);
                return new int[]{alpha, bestPos};
            } else {
            for (int i = 0; i < nextMoves.size(); ++i) {
                buttons[nextMoves.get(i)].setText(opponent);
                    bestScore = minimax (depth - 1, AI, alpha, beta)[0];

                    if (bestScore < beta) {
                        beta    = bestScore;
                        bestPos = nextMoves.get(i).intValue();
                    }
                    buttons[nextMoves.get(i)].setText(" ");
                    if (beta <= alpha) {
                        break;
                    }

            }
            System.out.println("beta " + beta + ", bestpos " + bestPos);
                return new int[]{beta, bestPos};
            }

        }




    private ArrayList<Integer> generateMoves() {
        ArrayList<Integer> nextMoves = new ArrayList<Integer>();

        if (currPlayerWin()) {
            return nextMoves;
        }

        for (int i = 0; i < buttons.length; ++i) {
            if (buttons[i].getText().equals(" ")) {
                nextMoves.add(i);
                System.out.print(" " + i + "; ");
                nextMoves.trimToSize();
            }
        }

        return nextMoves;

    }


    private int evaluate() {
        int score = 0;
        for (int i = 0; i<line.length;++i) {
            score += evaluateLine(line[i][0], line [i][1], line[i][2]);
        }

        System.out.println();
        System.out.println(buttons[0].getText() + " " + buttons[1].getText() + " " + buttons[2].getText());
        System.out.println(buttons[3].getText() + " " + buttons[4].getText() + " " + buttons[5].getText());
        System.out.println(buttons[6].getText() + " " + buttons[7].getText() + " " + buttons[8].getText());
        System.out.println("SCORE: " + score);
        return score;
    }


    private int evaluateLine(int pos1, int pos2, int pos3) {
        int score = 0;

        if (buttons[pos1].getText().equals("X")) {
            score = 1;
        } else if (buttons[pos1].getText().equals("0")) {
            score = -1;
        }

        if (buttons[pos2].getText().equals("X")) {
            if (score == 1) {
                score = 10;
            } else if (score == -1) {
                return 0;
            } else {
                score = 1;
            }
        } else if (buttons[pos2].getText().equals("O")) {
            if (score == -1) {
                score = -10;
            } else if (score == 1) {
                return 0;
            } else {
                score = -1;
            }
        }


        if (buttons[pos3].getText().equals("X")) {
            if (score > 0) {
                score *= 10;
            } else if (score < 0) {
                return 0;
            } else {  //
                score = 1;
            }
        } else if (buttons[pos3].getText().equals("O")) {
            if (score < 0) {
                score *= 10;
            } else if (score > 1) {
                return 0;
            } else {
                score = -1;
            }
        }
        return score;
    }



    private void checkAndMakeMove(int currPos) {
        if(!isMoveAllowed(currPos) && gameNotOver) {
            JOptionPane.showMessageDialog(null, "Invalid Move");
        } else if(gameNotOver){
            buttons[currPos].setText(currPlayer);
            movesLeft--;
            if(isGameOver()){
                if(winPlayer != " "){
                    JOptionPane.showMessageDialog(null, winPlayer + " wins");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "No Winner");
                    System.exit(0);
                }
            } else {
                changecurrPlayer();
            }
        }
    }

    private boolean isGameOver() {
        if(currPlayerWin() || noMovesLeft()){
            gameNotOver = false;
            return true;
        } else {
            gameNotOver = true;
            return false;
        }
    }

    private void changecurrPlayer() {
        if(currPlayer == "O"){
            currPlayer = "X";
        } else {
            currPlayer = "O";
        }
    }

    private boolean noMovesLeft() {
        for(int i = 0; i < 9; ++i){

                if(buttons[i].getText() == " "){
                    return false;

            }
        }
        return true;
    }

    private boolean isMoveAllowed(int pos) {
        if(buttons[pos].getText() == " "){
            return true;
        } else {
            return false;
        }
    }

    private boolean currPlayerWin() {
        for (int i = 0; i < line.length; i++) {
            if (buttons[line[i][0]].getText() == currPlayer &&
                    buttons[line[i][1]].getText() == currPlayer && buttons[line[i][2]].getText() == currPlayer) {
                winPlayer = currPlayer;
                return true;
            }
        }
        return false;
    }


}