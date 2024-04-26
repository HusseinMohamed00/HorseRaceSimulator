import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import javax.swing.*;


class GUI extends JFrame implements ActionListener{
    JButton DistanceButton;
    JButton HorseButton;
    JButton RaceButton;
    JButton StatsButton;
    JLabel label;
    ArrayList<Horse> horses;
    DistanceFrame DistanceObj;
    int distance;
    boolean RaceBegin = false;



    public GUI(int distance, ArrayList<Horse> horses){
        this.distance = distance;
        this.horses = horses;


        label = new JLabel("Welcome to the horse race!", JLabel.CENTER);
        label.setBounds(10, 10, 200, 20);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(Color.WHITE);

        




        HorseButton = new JButton();
        HorseButton.setBounds(280, 40, 100, 30);
        HorseButton.addActionListener(this);
        HorseButton.setText("Add Horse");
        HorseButton.setFocusable(false);
        HorseButton.setHorizontalTextPosition(JButton.CENTER);
        HorseButton.setVerticalTextPosition(JButton.BOTTOM);
        HorseButton.setBackground(Color.CYAN);
        HorseButton.setForeground(Color.BLUE);

        DistanceButton = new JButton();
        DistanceButton.setBounds(10, 40, 100, 30);
        DistanceButton.addActionListener(this);
        DistanceButton.setText("Distance");
        DistanceButton.setFocusable(false);
        DistanceButton.setHorizontalTextPosition(JButton.CENTER);
        DistanceButton.setVerticalTextPosition(JButton.BOTTOM);
        DistanceButton.setBackground(Color.CYAN);
        DistanceButton.setForeground(Color.BLUE);

        RaceButton = new JButton();
        RaceButton.setBounds(100, 40, 100, 30);
        RaceButton.addActionListener(this);
        RaceButton.setText("Start Race");
        RaceButton.setFocusable(false);
        RaceButton.setHorizontalTextPosition(JButton.CENTER);
        RaceButton.setVerticalTextPosition(JButton.BOTTOM);
        RaceButton.setBackground(Color.CYAN);
        RaceButton.setForeground(Color.BLUE);

        StatsButton = new JButton();
        StatsButton.setBounds(190, 40, 100, 30);
        StatsButton.addActionListener(this);
        StatsButton.setText("View Stats");
        StatsButton.setFocusable(false);
        StatsButton.setHorizontalTextPosition(JButton.CENTER);
        StatsButton.setVerticalTextPosition(JButton.BOTTOM);
        StatsButton.setBackground(Color.CYAN);
        StatsButton.setForeground(Color.BLUE);

        

        this.getContentPane().setBackground(new Color (0, 0, 100));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(550, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(DistanceButton);
        this.add(HorseButton);
        this.add(RaceButton);

        this.add(StatsButton);
        this.add(label);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == HorseButton){
            if(!RaceBegin){ 
            System.out.println("Horse Button Pressed");
            HorseFrame Horse = new HorseFrame(distance, this.horses);
            dispose();
            }

        }
        if(e.getSource() == DistanceButton){
            DistanceObj = new DistanceFrame(this.horses);
            dispose();

        }
        if(e.getSource() == RaceButton){
            try{

                if(this.horses.size() > 0){
                    int DistanceValue = Integer.parseInt(DistanceFrame.DistanceString);
                    Race RaceObj = new Race(DistanceValue, this.horses);
    
                    dispose();
                    RaceObj.startRaceGUI();
                    RaceBegin = true;
                }
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Please enter a valid distance");
            }
           
            if(horses.size() < 2){
                JOptionPane.showMessageDialog(this, "Please add at least 2 horses to start");
                return;

            }
        }

    }

}
