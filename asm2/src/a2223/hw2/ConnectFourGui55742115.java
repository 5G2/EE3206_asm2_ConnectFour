//====================================================================================
// DO NOT MODIFY THE GIVEN CODE IN THIS TEMPLATE
//====================================================================================
package a2223.hw2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * EE3206 Assignment 3
 * 
 * The goal of this assignment is to implement the GUI for the board game "Connect Four".
 *
 * You should follow the instructions below to complete this template.
 * 
 * 1. Create a project with the Java package a2223.hw2.
 * 2. Put these three files in the package:
 *       - ConnectFour.java             (the file in assignment 2)
 *       - ConnectFourXXXXXXXX.java     (the file in assignment 2)
 *       - ConnectFourGuiXXXXXXXX.java  (this template)
 * 3. The X-string above is your student ID. 
 * 4. Implement the constructor and the listener in this template.
 * 5. Define additional private fields and methods as needed. These fields are for your
 *    internal use and do not form a public API.
 * 6. You may fix/update your class <ConnectFourXXXXXXXX> if needed.
 *
 */

/**
 * The graphical front-end of a simple connection board game �� Connect Four. 
 * 
 * This front-end does not implement the core game logic by itself. The core game
 * logic remains in <ConnectFourXXXXXXXX>. This front-end provides a graphical view
 * of an instance of <ConnectFourXXXXXXXX>. They communicate through the interface
 * <ConnectFour> and synchronize their game state continuously.
 *
 * @author vanting
 */
public class ConnectFourGui55742115 extends JFrame {
    
    private final String sid;       
    private final ConnectFour game;
    int l0=5;
    int l1=5;
    int l2=5;
    int l3=5;
    int l4=5;
    int l5=5;
    int l6=5;
    
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JLabel labels[][] = new JLabel[6][7];
    JButton buttons[] = new JButton[7];
    JButton buttonR = new JButton("Restart");
    
    JLabel message = new JLabel("Game Start. Player turn: X");
    /**
     * Create a 700x600 main window for the game.
     */
    public static void main(String[] args) {
        ConnectFourGui55742115 gui = new ConnectFourGui55742115();
        gui.setSize(700, 600);
        gui.setLocationRelativeTo(null); 
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }

    /** 
     * Initialize the internal game states, UI and event handlers.
     */
    public ConnectFourGui55742115 () {
        
        // 1. Initialize your own non-graphical Connect Four game object.
        String className = this.getClass().getName();
        sid = className.substring(className.length() - 8);
        this.setTitle("Connect Four created by " + sid);
        game = ConnectFour.newInstance(sid);
        game.init();
        // 2. Add your graphical components to this window.
        setLayout(new BorderLayout(5, 5));
        
        p1.add(buttonR);
        buttonR.addActionListener(new ButtonActionListener());
        p2.setLayout(new GridLayout(7, 7,5,5));
        p2.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
       
        
        for(int i =0;i<7;i++) {
        	buttons[i]=new JButton();
        	buttons[i].setText(String.valueOf(i));
        	buttons[i].addActionListener(new ButtonActionListener());
        	p2.add(buttons[i]);
        }
        
        
        for(int i =0;i<6;i++) {
        	for(int j =0;j<7;j++) {
        		labels[i][j]= new JLabel("[ _ ]", SwingConstants.CENTER);
        		p2.add(labels[i][j]);
        	}
        }
        
        
        p3.add(message);
        
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
        
        /*
                The UI should at least contains the following elements:
                - A restart button to reset the game to initial state.
                - Seven number buttons (0-6) for the user to drop a token.
                - A grid to show the current placement.
                - A message panel to display game messages, such as game 
                  start/end, player turn, winner and error messages.
                
                Below is a reference design.
        
                      {restart}
                {0}{1}{2}{3}{4}{5}{6}   
                =====================
                [_][_][_][_][_][_][_]
                [_][_][_][_][_][_][_]
                [_][_][_][_][_][_][_]
                [_][_][_][_][_][_][_]
                [_][_][_][O][_][_][_]
                [_][X][X][O][_][_][_]
                =====================
                +-------------------+
                |   game messages   |
                +-------------------+
        
        */
        
        // 3. Add your listeners to the event source (buttons that control the game).
       
    }
    

    /**
     * This listener class handles the following events:
     * 1. A user presses a number button to drop a token in the corresponding column.
     * 2. A user presses a restart button to reset the game.
     */
    
    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // 1. Identify event source
        	String turn = game.getTurn().toString();
        	if(e.getActionCommand().equals("Restart"))
        	{
        		game.init();
                for(int i =0;i<6;i++) {
                	for(int j =0;j<7;j++) {
                		labels[i][j].setText("[ _ ]");
                	}
                }
                l0=5;
                l1=5;
                l2=5;
                l3=5;
                l4=5;
                l5=5;
                l6=5;
        		message.setText("Game Start. Player turn:" + game.getTurn());
        		repaint();
        		return;
        	}
        	if(!game.hasNext())	return;
        	switch(e.getActionCommand()) {

        	case "0":
        		try {
        			game.drop(0);
        			labels[l0--][0].setText(turn);
        		}
        		catch(IllegalStateException err){
        			message.setText("This column is full");
        			return;
        		}
        		break;
        	case "1":
        		try {
        			game.drop(1);
        			labels[l1--][1].setText(turn);
        		}
        		catch(IllegalStateException err){
        			message.setText("This column is full");
        			return;
        		}
        		break;
        	case "2":
        		try {
        			game.drop(2);
        			labels[l2--][2].setText(turn);
        		}
        		catch(IllegalStateException err){
        			message.setText("This column is full");
        			return;
        		}
        		break;
        	case "3":
        		try {
        			game.drop(3);
        			labels[l3--][3].setText(turn);
        		}
        		catch(IllegalStateException err){
        			message.setText("This column is full");
        			return;
        		}
        		break;
        	case "4":
        		try {
        			game.drop(4);
        			labels[l4--][4].setText(turn);
        		}
        		catch(IllegalStateException err){
        			message.setText("This column is full");
        			return;
        		}
        		break;
        	case "5":
        		try {
        			game.drop(5);
        			labels[l5--][5].setText(turn);
        		}
        		catch(IllegalStateException err){
        			message.setText("This column is full");
        			return;
        		}
        		break;
        	case "6":
        		try {
        			game.drop(6);
        			labels[l6--][6].setText(turn);
        		}
        		catch(IllegalStateException err){
        			message.setText("This column is full");
        			return;
        		}
        		break;
        	
        	}
            String m1 = "Player turn:";
            m1+=game.getTurn().toString();
            if(!e.getActionCommand().equals("Restart")) message.setText(m1);
            if(!game.hasNext()) {
            	if(game.hasWinner()) 	message.setText("Winner is " +game.getWinner());
            	else	message.setText("Draw");
            }
            
            repaint();
        }
    }
}
