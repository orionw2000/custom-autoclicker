package robomouse;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;
import javax.swing.*;


class robomouse extends Frame implements ActionListener {
    // Frame
    static JFrame f;
    static TextField howMany;
    static TextField totalTimes;
    static HowMany hm;
    
    robomouse()
    {
    }

    // main function
    public static void main(String[] args)    {
        
        JFrame jframe = new JFrame("setup");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        howMany = new TextField(3);
        totalTimes = new TextField(7);
        Button button = new Button("OK");
        hm = new HowMany();
        button.addActionListener(hm);
        JPanel panel = new JPanel();
        panel.add(howMany);
        panel.add(totalTimes);
        panel.add(button);
        jframe.setSize(400,400);
        jframe.add(panel);
        jframe.show();        
    }

    // if button is pressed
    public void actionPerformed(ActionEvent e){
        //loop how many times
        for(int count = 0; count < Integer.parseInt(totalTimes.getText()); count++){
            try {
                TextField[] fields = hm.getFields();
                int size = fields.length/5;
                Click[] clicks = new Click[size];
                for(int i = 0; i < size; i++){
                    Click click = new Click(
                            Integer.parseInt(fields[(5*i)].getText()),
                            Integer.parseInt(fields[(5*i)+1].getText()),
                            Integer.parseInt(fields[(5*i)+2].getText()),
                            Boolean.parseBoolean(fields[(5*i)+3].getText()),
                            Integer.parseInt(fields[(5*i)+4].getText())
                    );
                    clicks[i] = click;
                }
                //Robot instance
                Robot r = new Robot();
                for(Click click : clicks){
                    System.out.println(click);
                    //move to pos
                    r.mouseMove(click.getXpos(), click.getYpos());
                    //click how many times
                    for(int times = 0; times < click.getTimes(); times++) {
                        //which click?
                        if (click.isRightClick()) {
                            r.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                            Thread.sleep(100);
                            r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                        } else {
                            r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                            Thread.sleep(100);
                            r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        }
                        //small delay
                        Thread.sleep(100);
                    }
                    //delay for next click
                    Thread.sleep(click.getDelay());
                }
            }catch (Exception evt) {
                System.err.println(evt.getMessage());
            }
        }
    }

}
