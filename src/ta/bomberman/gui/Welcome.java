package ta.bomberman.gui;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ta.bomberman.BombermanGame;

public class Welcome {
	JLabel l1;
	JButton btn1, btn2, btn3;
	JTable table;
	JScrollPane scrollPane;
	 
	public Welcome() {
		JFrame frame = new JFrame("Welcome");
		l1 = new JLabel("Welcome " + BombermanGame.username);
		l1.setForeground(Color.blue);
	    l1.setFont(new Font("Serif", Font.BOLD, 20));

		btn1 = new JButton("New Game");
		btn2 = new JButton("Rank");
		btn3 = new JButton("History");
		
		
	    scrollPane = new JScrollPane(table);
		
		l1.setBounds(100, 30, 400, 30);
		btn1.setBounds(50, 110, 100, 30);
		btn2.setBounds(200, 110, 100, 30);  
		btn3.setBounds(350, 110, 100, 30);
	
		frame.add(l1);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		  
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(null);
		frame.setVisible(true);
		
		  
		Color color = btn1.getBackground();
		//
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
			BombermanGame.client.getMap();
			BombermanGame.isGamePlay ++;
		}  
		});
		//
		
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn2.setBackground(Color.WHITE);
			}

			@Override
            public void mouseExited(MouseEvent e) {
           	 	btn2.setBackground(color);
            }
             
		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] columns = new String[] {
			            "Rank", "User", "Win", "Lose"
			    };
				Object[][] data = new Object[][] {
		            {1, "anhphan", 3, 2 },
		            {2, "messi", 0, 0 },
		            {3, "ronaldo", 0, 1 },
		        };
				new Table(columns, data);
			}  
			});
		
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn3.setBackground(Color.WHITE);
			}

			@Override
            public void mouseExited(MouseEvent e) {
           	 	btn3.setBackground(color);
            }
             
		});
		btn3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String[] columns = new String[] {
				            "Id", "Login", "Logout"
				    };
					Object[][] data = new Object[][] {
			            {1, "2019-12-22 23:44:02", "2019-12-22 23:50:02"},
			            {2, "2019-12-23 00:00:23", "2019-12-23 00:05:23" },
			        };
					new Table(columns, data);
				}  
		});
	 }
	 
	 
	 public void actionPerformed(ActionEvent ae)
	 {
	   
	 }
}
