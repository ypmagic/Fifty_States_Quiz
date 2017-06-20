import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by young on 6/20/17.
 */
public class Quiz {

    JFrame frame;
    // pictures of states
    JPanel north;
    JLabel quizState;
    ArrayList<ImageIcon> states;
    // player response
    JTextField center;
    // status update
    JPanel south;
    JLabel numberCorrect;
    JLabel isWrong;
    int numCorrect;
    // state names
    String[] stateNames;
    int stateNum;

    public Quiz() throws IOException {
        this.numCorrect = 0;
        // north panel
        this.north = new JPanel();
        StatesArray a = new StatesArray();
        this.states = a.getStates();
        this.stateNames = a.getNames();
        this.quizState = new JLabel();
        // center
        this.center = new JTextField();
        this.center.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (center.getText().equals(stateNames[stateNum])) {
                    numCorrect++;
                    isWrong.setText("Correct!");
                } else {
                    isWrong.setText("Incorrect!");
                }
                numberCorrect.setText(numCorrect + "/50 correct!");
                setRandomState();
            }
        });
        // south panel
        this.south = new JPanel(new GridBagLayout());
        this.numberCorrect = new JLabel("Your progress here");
        this.isWrong = new JLabel("Right or wrong indicator here");
        // frame
        this.frame = new JFrame("Fifty States Quiz");
        this.frame.setLayout(new BorderLayout());
        this.frame.add(this.north, BorderLayout.NORTH);
        this.frame.add(this.center, BorderLayout.CENTER);
        this.frame.add(this.south, BorderLayout.SOUTH);
        this.frame.pack();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    private void setRandomState() {
        Random randomizer = new Random();
        ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
        this.stateNum = randomizer.nextInt();
        while (usedNumbers.contains(this.stateNum)) {
            this.stateNum = randomizer.nextInt();
        }
        usedNumbers.add(this.stateNum);
        this.quizState.setIcon(this.states.get(this.stateNum));
    }

}
