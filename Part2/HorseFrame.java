import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


class HorseFrame extends JFrame implements ActionListener{
    JTextField name;
    JSlider confidence;
    JTextField symbol;
    JPanel panel;
    JButton Submitbutton;
    JLabel labelName;
    JLabel labelConfidence;
    JLabel labelSymbol;
    ArrayList<Horse> horses;
    int distance;

    public HorseFrame( int distance, ArrayList<Horse> horses){
        
        this.horses = horses;

        this.distance = distance;


        labelName = new JLabel("Name:");
        labelConfidence = new JLabel("Confidence:");
        labelSymbol = new JLabel("Symbol:");

        
        
        labelName.setBounds(10, 10, 80, 20);
        name = new JTextField("",20);
        name.setBounds(100, 10, 150, 20);



        labelConfidence.setBounds(10, 40, 80, 40);
        confidence = new JSlider(JSlider.HORIZONTAL, 1, 9, 5);
        confidence.setMajorTickSpacing(10);
        confidence.setMinorTickSpacing(1);
        confidence.setPaintTicks(true);
        confidence.setPaintLabels(true);
        confidence.setBounds(100, 40, 200, 20);


        labelSymbol.setBounds(10, 90, 80, 20);
        symbol = new JTextField("",20);
        symbol.setBounds(100, 90, 150, 20);

        


        panel = new JPanel(new GridBagLayout());
        panel.setLayout(null);


        Submitbutton = new JButton();
        Submitbutton.setBounds(10, 120, 100, 30);
        Submitbutton.addActionListener(this);
        Submitbutton.setText("Submit");
        Submitbutton.setFocusable(false);
        Submitbutton.setHorizontalTextPosition(JButton.CENTER);
        Submitbutton.setVerticalTextPosition(JButton.BOTTOM);
        Submitbutton.setBackground(Color.CYAN);

        


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 250);
        this.setVisible(true);
        panel.add(name);
        panel.add(confidence);
        panel.add(symbol);
        panel.add(Submitbutton);
        panel.add(labelName);
        panel.add(labelConfidence);
        panel.add(labelSymbol);
        this.add(panel);
        this.getContentPane().setBackground(new Color (0, 0, 100));
        








    }

    public void AddingTheHorse(){    

        String nameValue = name.getText();
        int confidenceValueString = confidence.getValue();
        String symbolValue = symbol.getText(); 
        char symbolValueChar = symbolValue.charAt(0);



        try{
            Double confidenceValueInt = (double) confidenceValueString/10;
            if((symbolValue.length()==1 &&confidenceValueInt <1 && confidenceValueInt>0)){
                Horse horse = new Horse(symbolValueChar ,nameValue , confidenceValueInt);
                this.horses.add(horse);
                if(this.horses.size() >0){
                System.out.println("Horse added");
                }
                else{
                    System.out.println("No horses in arraylist");
                }
            }

            else{
                
                System.out.println("Invalid input");
            }

            
    
            this.setVisible(true);
    
        }

        catch(NumberFormatException ex){
            System.out.println("Invalid input");
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Submitbutton){
            AddingTheHorse();
            GUI gui = new GUI(distance, this.horses);
            dispose();


           
        }
    }

    
}