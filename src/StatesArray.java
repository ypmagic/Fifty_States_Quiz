import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Creates an array of ImageIcons to put into a JLabel
 */
public class StatesArray {

    private ArrayList<ImageIcon> states;
    private String[] names;

    public StatesArray() throws IOException {
        this.states = new ArrayList<ImageIcon>();
        this.names = new String[50];
        receiveStates();
    }

    /*
    Takes images of states using IO, creates ImageIcons for them, and inserts them into this.states.
     */
    private void receiveStates() throws IOException {
        for (int i = 0; i < 50; i++) {
            BufferedImage a = ImageIO.read(new File("" + i + ".png"));
            Image img = a.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            this.states.add(new ImageIcon(img));
        }
    }

    private void fillStateNames() {
        this.names[0] = "Alabama";
        this.names[1] = "Alaska";
        this.names[2] = "Arizona";
        this.names[3] = "Arkansas";
        this.names[4] = "California";
        this.names[5] = "Colorado";
        this.names[6] = "Connecticut";
        this.names[7] = "Delaware";
        this.names[8] = "Florida";
        this.names[9] = "Georgia";
        this.names[10] = "Hawaii";
        this.names[11] = "Idaho";
        this.names[12] = "Illinois";
        this.names[13] = "Indiana";
        this.names[14] = "Iowa";
        this.names[15] = "Kansas";
        this.names[16] = "Kentucky";
        this.names[17] = "Louisiana";
        this.names[18] = "Maine";
        this.names[19] = "Maryland";
        this.names[20] = "Massachusetts";
        this.names[21] = "Michigan";
        this.names[22] = "Minnesota";
        this.names[23] = "Mississippi";
        this.names[24] = "Missouri";
        this.names[25] = "Montana";
        this.names[26] = "Nebraska";
        this.names[27] = "Nevada";
        this.names[28] = "New Hampshire";
        this.names[29] = "New Jersey";
        this.names[30] = "New Mexico";
        this.names[31] = "New York";
        this.names[32] = "North Carolina";
        this.names[33] = "North Dakota";
        this.names[34] = "Ohio";
        this.names[35] = "Oklahoma";
        this.names[36] = "Oregon";
        this.names[37] = "Pennsylvania";
        this.names[38] = "Rhode Island";
        this.names[39] = "South Carolina";
        this.names[40] = "South Dakota";
        this.names[41] = "Tennessee";
        this.names[42] = "Texas";
        this.names[43] = "Utah";
        this.names[44] = "Vermont";
        this.names[45] = "Virginia;";
        this.names[46] = "Washington";
        this.names[47] = "West Virginia";
        this.names[48] = "Wisconsin";
        this.names[49] = "Wyoming";
    }

    public ArrayList<ImageIcon> getStates() {
        return this.states;
    }

    public String[] getNames() {
        return this.names;
    }
}
