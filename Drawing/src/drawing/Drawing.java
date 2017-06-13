/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

/**
 *
 * @author untitled
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Drawing extends JFrame
     implements ActionListener,MouseListener {

	
	private int x,y,x2,y2;
    private int count=0;
	 
	private static final long serialVersionUID = 1L;
	private boolean drawLine = false;
     private boolean drawRect = false;
     private boolean drawOval = false;
     private JButton line;
     
     private JPanel buttonPanel;
     private DrawStuff drawPanel = new DrawStuff();

     

     public Drawing() {
         super("Drawing");
         setSize(600, 400);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         buttonPanel = new JPanel();
         
         line = new JButton("LINE");
         line.addActionListener(this);
         buttonPanel.add(line);

         


         Container contentPane = this.getContentPane();
         contentPane.add(buttonPanel, BorderLayout.SOUTH);
         add(drawPanel);
         
         addMouseListener(this);
    }
     public void mouseClicked(MouseEvent mouse){   

         count++;

         if(count==1){
             x=mouse.getX();
             y=mouse.getY();
         }

         if(count==2){
             x2 = mouse.getX();
             y2 = mouse.getY();
         }         
}

     public void mouseEntered(MouseEvent mouse){ }   
     public void mouseExited(MouseEvent mouse){ }
     public void mousePressed(MouseEvent mouse){ }
     public void mouseReleased(MouseEvent mouse){ }


    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == line) {
            count=0;
            drawLine = true;
            repaint();
        }
    }

    public static void main(String[] args) {
        Drawing draw = new Drawing();
        draw.setVisible(true);
    }

    class DrawStuff extends JPanel {

		private static final long serialVersionUID = 1L;

		@Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (drawLine) {
            	
            	g.drawLine(x, y, x2, y2);
                drawLine = false;
                
            } 
        }
    }
}
