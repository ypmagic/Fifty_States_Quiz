import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    int totalNum;
    // state names
    String[] stateNames;
    int stateNum;
    ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
    ArrayList<String> incorrectStates = new ArrayList<String>();

    public Quiz() throws IOException {
        this.numCorrect = 0;
        this.totalNum = 0;
        // north panel
        this.north = new JPanel();
        StatesArray a = new StatesArray();
        this.states = a.getStates();
        this.stateNames = a.getNames();
        this.quizState = new JLabel();
        setRandomState();
        this.north.add(this.quizState);
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
                    incorrectStates.add(stateNames[stateNum]);
                }
                numberCorrect.setText(numCorrect + "/50 correct!");
                center.setText("");
                setRandomState();
            }
        });
        // south panel
        this.south = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.insets = new Insets(0, 0, 5, 0);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        this.numberCorrect = new JLabel("Your progress here");
        this.numberCorrect.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        this.isWrong = new JLabel("Right or wrong indicator here");
        this.isWrong.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        this.south.add(this.numberCorrect, c);
        this.south.add(this.isWrong, c);
        // frame
        this.frame = new JFrame("Fifty States Quiz");
        this.frame.setLayout(new BorderLayout());
        this.frame.setSize(300,500);
        this.frame.add(this.north, BorderLayout.NORTH);
        this.frame.add(this.center, BorderLayout.CENTER);
        this.frame.add(this.south, BorderLayout.SOUTH);
        this.frame.pack();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
    }

    private void setRandomState() {
        this.totalNum++;
        Random randomizer = new Random();
        if (totalNum < 50) {
            this.stateNum = randomizer.nextInt(50);
            boolean keepGoing = true;
            while (keepGoing) {
                if (usedNumbers.contains(this.stateNum)) {
                    this.stateNum = randomizer.nextInt(50);
                } else {
                    usedNumbers.add(this.stateNum);
                    this.quizState.setIcon(this.states.get(this.stateNum));
                    keepGoing = false;
                }
            }
        } else if (totalNum == 50) {
            this.frame.setVisible(false);
            Results a = new Results(this.numCorrect, this.incorrectStates);
        }
    }

}
