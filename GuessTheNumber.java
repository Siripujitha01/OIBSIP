import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuessTheNumber extends JFrame implements ActionListener
{
	JButton b1,b2,b3;
	JLabel l1;
	JTextField t1,t2;
	static int score=0;
	public GuessTheNumber(){
		super("Guess The Number");
		b1=new JButton("START");
		b2=new JButton("RETRY");
		b3=new JButton("RESTART");
		l1=new JLabel("Enter a Number from 0 to 100:");
		t1=new JTextField(5);
		t2=new JTextField(40);
		t2.setEditable(false);
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
		add(b1);
		add(t2);
		add(b2);
		add(b3);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
        setSize(500,500);
        setLocation(500,250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
    {
		if(ae.getActionCommand().equals("START"))
    	{
    	  try{
    		  int s=Integer.parseInt(t1.getText());
    		  int r=(int)(Math.random()*101);
    		  if(s==r){
    			  score+=100;
    			  t2.setText("Hurry You Got the Right One \t Your Score is:"+score);
    		  }
    		  else if(s>r){
    			  t2.setText("OOPS! \t Your Number Was Greater");
    			  b1.setEnabled(false);
    			  b2.setEnabled(true);
    			  b3.setEnabled(true);
    		  }
    		  else{
    			  t2.setText("OOPS! \t Your Number Was Smaller");
    			  b1.setEnabled(false);
    			  b2.setEnabled(true);
    			  b3.setEnabled(true);
    		  }
    	  }
    	  catch(NumberFormatException ne){
    		  JOptionPane.showMessageDialog(null, "Enter a Valid Number");
    	  }
    	}
		else if(ae.getActionCommand().equals("RESTART")){
			JOptionPane.showMessageDialog(null, "Restarting The Game");
			b1.setEnabled(true);
			b3.setEnabled(false);
			b2.setEnabled(false);
			score=0;
		}
		else{
			score-=100;
			if(score<0){
				JOptionPane.showMessageDialog(null, "Your Score was not Sufficient");
				b1.setEnabled(false);
				b2.setEnabled(false);
				b3.setEnabled(true);
			}
			else{
				b1.setEnabled(true);
			}
		}
    }
	public static void main(String[] args) {
		 new GuessTheNumber();
	}

}
