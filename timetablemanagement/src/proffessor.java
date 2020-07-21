import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.sql.*;
class timetable
{
    
    timetable()
    {
    	JLabel jlab;
        JFrame jfrm=new JFrame("Time-table-management");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel name=new JLabel("NAME:");
        JTextField namefld=new JTextField(45);
        JLabel dept=new JLabel("DEPT:");
        JTextField deptfld=new JTextField(45);
        JLabel age=new JLabel("AGE:");
        JTextField agefld=new JTextField(45);
        JLabel hours=new JLabel("AV-HOURS:");
        JTextField hoursfld=new JTextField(45);
        JButton submit=new JButton("SUBMIT");
        jfrm.add(name);
        jfrm.add(namefld);
        jfrm.add(dept);
        jfrm.add(deptfld);
        jfrm.add(age);
        jfrm.add(agefld);
        jfrm.add(hours);
        jfrm.add(hoursfld);
        jfrm.add(submit);
        jfrm.setVisible(true);
        submit.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {   
                    String pname,pdept;
                    int page,phrs;
                    pname=namefld.getText();
                    pdept=deptfld.getText();
                    page=Integer.parseInt(agefld.getText());
                    phrs=Integer.parseInt(hoursfld.getText());
                    System.out.println(pname);
                    System.out.println(pdept);
                    System.out.println(page);
                    System.out.println(phrs);
                    java.sql.Connection conn=null;
	                try{
	                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	                    //conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship?user=root&password=");
	                    //java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship","root","");
	                    conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtimetable","root","");
	                    //PreparedStatement s=conn.prepareStatement("INSERT INTO signup values ("+uname+","+pass+")");
	                    //ResultSet res=s.execute();
	                }
	                catch(ClassNotFoundException e)
	                {
	                    System.out.println("class not found exception");
	                    System.exit(1);
	                }
	                catch(Exception e)
	                {
	                    System.out.println("hi");
	                    System.exit(1);
	                }
	                System.out.println("Connectiom Established");
	                
	                try{
	                    java.sql.Statement s=conn.createStatement();
	                    String query="INSERT INTO profdetails values ('"+pname+"','"+pdept+"','"+page+"','"+phrs+"')";
	                    //String query="INSERT INTO signup values ('akshit','akki')";
	                    s.execute(query);
	                    System.out.println("Data inserted");
	                }
	                catch(Exception e)
	                {
	                    System.out.println("Insert exception" + e);
	                    System.exit(1);
	                }
	               }
            });
           
    }
    public static void main(String args[])
    {   
       /* SwingUtilities.invokeLater(
            new Runnable()
            {
                public void run()
                {
                    new timetable();
                }
            }
        );  */
    	new timetable();
}
    }