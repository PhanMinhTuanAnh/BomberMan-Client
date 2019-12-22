package ta.bomberman.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ta.bomberman.BombermanGame;

public class Login extends JFrame implements ActionListener{
	 JLabel l1, l2, l3, l4;
	 JTextField tf1;
	 JButton btn1;
	 JPasswordField p1;
	 
	 public Login() {
		  JFrame frame = new JFrame("Login Form");
		  l1 = new JLabel("Login Form");
		  l1.setForeground(Color.blue);
		  l1.setFont(new Font("Serif", Font.BOLD, 20));
		
		  l2 = new JLabel("Username");
		  l3 = new JLabel("Password");
		  l4 = new JLabel("Login Again");
		  tf1 = new JTextField();
		  p1 = new JPasswordField();
		  btn1 = new JButton("Login");
		
		  l1.setBounds(100, 30, 400, 30);
		  l2.setBounds(80, 70, 200, 30);
		  l3.setBounds(80, 110, 200, 30);
		  l4.setBounds(80,250, 200, 50);
		  l4.setForeground(Color.red);
		  l4.setVisible(false);
		  tf1.setBounds(300, 70, 200, 30);
		  p1.setBounds(300, 110, 200, 30);
		  btn1.setBounds(150, 160, 100, 30);
		  
		
		  frame.add(l1);
		  frame.add(l2);
		  frame.add(l4);
		  frame.add(tf1);
		  frame.add(l3);
		  frame.add(p1);
		  frame.add(btn1);
		
		  frame.setSize(600, 400);
		  frame.setLayout(null);
		  frame.setVisible(true);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  Color color = btn1.getBackground();
		  
		  btn1.addMouseListener(new MouseAdapter() {
			  @Override
              public void mouseEntered(MouseEvent e) {
                  btn1.setBackground(Color.WHITE);
              }

              @Override
              public void mouseExited(MouseEvent e) {
            	  btn1.setBackground(color);
              }
              
		  });
		  btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = tf1.getText().trim();
				String password = p1.getText().trim();
				boolean response = BombermanGame.client.checkLogin(username, password);
				if(response) {
					BombermanGame.isLogin = true;
					BombermanGame.username = username;
					frame.dispose();
				}
				else {
					l4.setVisible(true);
				}
			}
			  
		  });
	 }
	 
	 
	 public void actionPerformed(ActionEvent ae)
	 {
	   
	 }

 }
