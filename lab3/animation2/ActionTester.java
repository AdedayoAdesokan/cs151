import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionTester
{
   static int count = 1;
	public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FIELD_WIDTH = 20;
      JTextField textField = new JTextField(FIELD_WIDTH);
      textField.setText("Click a button!");

      JButton helloButton = new JButton("Say Hello");
            
      helloButton.addActionListener(event ->
         textField.setText("Hello " + count));
    
      JButton goodbyeButton = new JButton("Say Goodbye");

      goodbyeButton.addActionListener(event ->
         textField.setText("Goodbye " + count));
      goodbyeButton.setEnabled(false);

      frame.setLayout(new FlowLayout());

      frame.add(helloButton);
      frame.add(goodbyeButton);
      frame.add(textField);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      
      while (helloButton.isEnabled())
      {
    	  helloButton.addActionListener(event ->
          helloButton.setEnabled(false));
    	  helloButton.addActionListener(event ->
          goodbyeButton.setEnabled(true));
    	  if (!helloButton.isEnabled())
          {
    		  goodbyeButton.addActionListener(event ->
              helloButton.setEnabled(true));
              goodbyeButton.addActionListener(event ->
              goodbyeButton.setEnabled(false));
              helloButton.addActionListener(event ->
              count = count + 1);
          }
      } 
   }
}
