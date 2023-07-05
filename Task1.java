// Oasis Infobyte (Java Internship) Task 1. Number Guessing Game.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Guess extends JFrame 
{
    JTextField t1, t2, t3, t4;
    JLabel j4;
    ButtonListener bl1;

    int rand = (int) (Math.random() * 100);
    int count = 0;

    public Guess() 
    {
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        JLabel j = new JLabel("Random Number Guess Game");
        j.setForeground(Color.yellow);
        j.setFont(new Font("tunga", Font.BOLD, 22));
        j.setSize(400, 40);
        j.setLocation(110, 10);

        JLabel j1 = new JLabel("Enter a number 1-100 : ");
        j1.setForeground(Color.WHITE);
        j1.setFont(new Font("tunga", Font.PLAIN, 20));
        j1.setSize(380, 150);
        j1.setLocation(135, 25);

        t1 = new JTextField(10);
        t1.setSize(50, 25);
        t1.setLocation(350, 90);

        j4 = new JLabel("Guess No in minimum guesses");
        j4.setForeground(Color.red);
        j4.setFont(new Font("tunga", Font.PLAIN, 18));
        j4.setSize(270, 20);
        j4.setLocation(160, 130);

        JLabel j5 = new JLabel("Number of Guess : ");
        j5.setForeground(Color.WHITE);
        j5.setFont(new Font("tunga", Font.PLAIN, 18));
        j5.setSize(270, 20);
        j5.setLocation(170, 190);

        t3 = new JTextField(10);
        t3.setSize(40, 20);
        t3.setLocation(326, 190);

        JLabel j6 = new JLabel("Best Score :");
        j6.setForeground(Color.WHITE);
        j6.setFont(new Font("tunga", Font.PLAIN, 18));
        j6.setSize(270, 20);
        j6.setLocation(190, 220);

        t2 = new JTextField(10);
        t2.setSize(40, 20);
        t2.setLocation(298, 222);

        JButton b1 = new JButton("Enter");
        b1.setSize(75, 22);
        b1.setLocation(225, 280);
        bl1 = new ButtonListener();
        b1.addActionListener(bl1);

        c.add(j5);
        c.add(j4);
        c.add(j);
        c.add(j1);
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(b1);
        c.add(j6);
        t2.setEditable(false);
        t3.setEditable(false);

        setTitle("Brain Booster");

        setSize(550, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener 
    {
        int bestScore = 100;

        public void actionPerformed(ActionEvent e) 
        {
            int Number = Integer.parseInt(t1.getText());
            count = count + 1;

            if(Number>=101 || Number<=-1)
            {
                j4.setText("Enter between 1 to 100 only");
            }
            else if (Number < rand) 
            {
                j4.setText(Number + " is Low, Guess Higher");
            } 
            
            else if (Number > rand) 
            {
                j4.setText(Number + " is High, Guess Lower");
            } 
            
            else 
            {
                j4.setText("YOU WON!!!");
                if (count < bestScore) 
                {
                    bestScore = count;
                    t2.setText(bestScore + "");
                }
                count=0;
                rand = (int) (Math.random() * 100);
                t2.setText("" + bestScore);
            }

            t1.requestFocus();
            t1.setText("");
            t3.setText(count + "");
        
        }
}

    public class Task1 
    {
        public static void main(String args[]) 
        {
            new Guess();
        }
    }
}