package ta.bomberman.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
public class Table extends JFrame
{
    public Table(String[] c, Object[][] d){
        //headers for the table
        String[] columns = c;
         
        //actual data for the table in a 2d array
        Object[][] data = d;
        //create table with data
        JTable table = new JTable(data, columns);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
        
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
}