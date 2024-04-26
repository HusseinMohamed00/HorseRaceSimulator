import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

class DistanceFrame extends JFrame implements ActionListener{
    JLabel label;
    JRadioButton distance1;
    JRadioButton distance2;
    JRadioButton distance3;
    JButton Submitbutton;
    JPanel panel;
    ArrayList<Horse> horses;
    static String DistanceString = "";

    public DistanceFrame(ArrayList<Horse> horses){
        this.horses = horses;

        label = new JLabel();
        label.setBounds(10, 10, 200, 20);
        label.setText("Pick a distance");
        label.setFont(new Font("Arial", Font.BOLD, 15));


        distance1 = new JRadioButton();
        distance1.setBounds(10, 40, 150, 30);
        distance1.setText("10m");
        distance1.addActionListener(this);
        distance1.setFocusable(false);
        distance1.setHorizontalTextPosition(JRadioButton.CENTER);
        distance1.setVerticalTextPosition(JRadioButton.BOTTOM);

        distance2 = new JRadioButton();
        distance2.setBounds(100, 40, 150, 30);
        distance2.setText("15m");
        distance2.addActionListener(this);
        distance2.setFocusable(false);
        distance2.setHorizontalTextPosition(JRadioButton.CENTER);
        distance2.setVerticalTextPosition(JRadioButton.BOTTOM);

        distance3 = new JRadioButton();
        distance3.setBounds(190, 40, 150, 30);
        distance3.setText("20m");
        distance3.addActionListener(this);
        distance3.setFocusable(false);
        distance3.setHorizontalTextPosition(JRadioButton.CENTER);
        distance3.setVerticalTextPosition(JRadioButton.BOTTOM);

        Submitbutton = new JButton();
        Submitbutton.setBounds(280, 40, 100, 30);
        Submitbutton.addActionListener(this);
        Submitbutton.setText("Submit");
        Submitbutton.setFocusable(false);
        Submitbutton.setHorizontalTextPosition(JButton.CENTER);
        Submitbutton.setVerticalTextPosition(JButton.BOTTOM);

        panel = new JPanel(new FlowLayout());




        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(distance1);
        buttonGroup.add(distance2);
        buttonGroup.add(distance3);



        this.setSize(500, 200);
        this.setVisible(true);
        this.add(label);
        this.add(panel);
        this.getContentPane().setBackground(new Color (0, 0, 100));
        panel.add(distance1);
        panel.add(distance2);
        panel.add(distance3);
        panel.add(Submitbutton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == distance1){

            DistanceString = "10";

        }
        if(e.getSource() == distance2){

            DistanceString = "15";

        }
        if(e.getSource() == distance3){

            DistanceString = "20";

        }
        if(e.getSource() == Submitbutton){
            
            GUI gui = new GUI(Integer.parseInt(DistanceString), horses);
            dispose();
        }


    }
    
}