import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Calculator implements ActionListener
{
	JFrame frame;
	JTextField textfield;
	JButton[] button=new JButton[10];
	JButton[] fbutton=new JButton[7];
	JButton addbutton,subbutton,multibutton,divibutton;
	JButton dotbutton,equalbutton,clearbutton;
	JPanel panel;
	char operator;
	Font font=new Font("Helvetica",Font.ITALIC,20);
	{
		frame=new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(330,450);
		frame.setLayout(null);
		textfield=new JTextField();
		textfield.setBounds(30,20,250,50);
		textfield.setFont(font);
		textfield.setEditable(false);
		addbutton=new JButton("+");
		subbutton=new JButton("-");
		multibutton=new JButton("*");
		divibutton=new JButton("/");
		dotbutton=new JButton(".");
		equalbutton=new JButton("=");
		clearbutton=new JButton("clear");
		fbutton[0]=addbutton;
		fbutton[1]=subbutton;
		fbutton[2]=multibutton;
		fbutton[3]=divibutton;
		fbutton[4]=clearbutton;
		fbutton[5]=equalbutton;
		fbutton[6]=dotbutton;
		for(int i=0;i<7;i++)
		{
			fbutton[i].addActionListener(this);
			fbutton[i].setFont(font);
			fbutton[i].setFocusable(false);
		}
		for(int i=0;i<10;i++)
		{
			button[i]=new JButton(String.valueOf(i));
			button[i].addActionListener(this);
			button[i].setFont(font);
			button[i].setFocusable(false);
		}
		clearbutton.setBounds(30,80,100,40);
		panel=new JPanel();
		panel.setBounds(30,125,250,280);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.add(button[7]);
		panel.add(button[8]);
		panel.add(button[9]);
		panel.add(addbutton);
		panel.add(button[4]);
		panel.add(button[5]);
		panel.add(button[6]);
		panel.add(subbutton);
		panel.add(button[1]);
		panel.add(button[2]);
		panel.add(button[3]);
		panel.add(multibutton);
		panel.add(dotbutton);
		panel.add(button[0]);
		panel.add(equalbutton);
		panel.add(divibutton);
		frame.add(panel);
		frame.add(clearbutton);
		frame.add(textfield);
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		Calculator cal=new Calculator();
	}
	public void actionPerformed(ActionEvent e) 
	{
		for(int i=0;i<10;i++)
		{
			if(e.getSource()==button[i])
			{
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==clearbutton)
		{
			textfield.setText("");
		}
		if(e.getSource()==addbutton)
		{
			String str=textfield.getText();
			String substr[]=str.split("\\s");
			for(int i=0;i<substr.length;i++)
			{	
				if(!(substr[substr.length-1].contains("+")))
				{
					textfield.setText(textfield.getText()+" + ");
					break;
				}
			}
		}
		if(e.getSource()==subbutton)
		{
			String str=textfield.getText();
			String substr[]=str.split("\\s");
			for(int i=0;i<substr.length;i++)
			{	
				if(!(substr[substr.length-1].contains("-")))
				{
					textfield.setText(textfield.getText()+" - ");
					break;
				}
			}
		}
		if(e.getSource()==multibutton)
		{
			String str=textfield.getText();
			String substr[]=str.split("\\s");
			for(int i=0;i<substr.length;i++)
			{	
				if(!(substr[substr.length-1].contains("*")))
				{
					textfield.setText(textfield.getText()+" * ");
					break;
				}
			}
		}
		if(e.getSource()==divibutton)
		{
			String str=textfield.getText();
			String substr[]=str.split("\\s");
			for(int i=0;i<substr.length;i++)
			{	
				if(!(substr[substr.length-1].contains("/")))
				{
					textfield.setText(textfield.getText()+" / ");
					break;
				}
			}
		}
		if(e.getSource()==dotbutton)
		{
			String str1=textfield.getText();
			String substr1[]=str1.split("\\s");
			for(int i=0;i<substr1.length;i++)
			{	
				if(!(substr1[substr1.length-1].contains(".")))
				{
					textfield.setText(textfield.getText().concat("."));
					break;
				}
			}
		}
		if(e.getSource()==equalbutton)
		{
			textfield.setText(textfield.getText()+" = ");
			String str=textfield.getText();
			String substr[]=str.split("\\s");
			double temp=0;
			for(int i=0;i<substr.length;i++)
			{
				if(substr[i].equals("+"))
				{
					temp=Double.parseDouble(substr[i-1])+Double.parseDouble(substr[i+1]);
					substr[i+1]=Double.toString(temp);
				}
				if(substr[i].equals("-"))
				{
					temp=Double.parseDouble(substr[i-1])-Double.parseDouble(substr[i+1]);
					substr[i+1]=Double.toString(temp);
				}
				if(substr[i].equals("*"))
				{
					temp=Double.parseDouble(substr[i-1])*Double.parseDouble(substr[i+1]);
					substr[i+1]=Double.toString(temp);
				}
				if(substr[i].equals("/"))
				{
					temp=Double.parseDouble(substr[i-1])+Double.parseDouble(substr[i+1]);
					substr[i+1]=Double.toString(temp);
				}
			}
			textfield.setText(String.valueOf(temp));
		}
	}

}
