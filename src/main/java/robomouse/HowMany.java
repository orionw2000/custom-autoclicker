package robomouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class HowMany extends Frame implements ActionListener {
    // Frame
    static JFrame f;

    private static int rows;
    private TextField[] fields;
    public HowMany(){
        
    }
    public void actionPerformed(ActionEvent e){
        rows = Integer.parseInt(robomouse.howMany.getText());
        // object of class
        robomouse rm = new robomouse();

        // create a frame
        f = new JFrame("robomouse");

        // set the frame to close on exit
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create array of labels/fields for each button press 
        fields = new TextField[rows*5];
        JLabel[] labels = new JLabel[rows];
        for(int i = 0; i <rows; i ++){
            fields[i*5] = new TextField(7);
            fields[(i*5)+1] = new TextField(7);
            fields[(i*5)+2] = new TextField(7);
            fields[(i*5)+3] = new TextField(7);
            fields[(i*5)+4] = new TextField(7);
            labels[i] = new JLabel(String.valueOf(i+1));
        }

        // create a button
        Button b = new Button("OK");

        // add actionListener to button
        b.addActionListener(rm);

        // create a panel
        JPanel p = new JPanel(new GridBagLayout());
        //setup gridbag constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);
        // add items to panel
        for(int i = 0; i < rows; i++){
            constraints.gridx = 0;
            constraints.gridy = i;
            p.add(labels[i], constraints);
            constraints.gridx = 1;
            p.add(fields[5*i], constraints);
            constraints.gridx = 2;
            p.add(fields[(5*i)+1], constraints);
            constraints.gridx = 3;
            p.add(fields[(5*i)+2], constraints);
            constraints.gridx = 4;
            p.add(fields[(5*i)+3], constraints);
            constraints.gridx = 5;
            p.add(fields[(5*i)+4], constraints);
        }

        p.add(b);
        f.add(p);

        // setsize of frame
        f.setSize(600, 800);
        // show it
        f.show();
    }
    public int getRows(){
        return rows;
    }

    public TextField[] getFields() {
        return fields;
    }
}
