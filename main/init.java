 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*;
 import java.sql.*;
 import java.util.*;
 import java.net.*;
 import java.io.*;
 import javax.swing.border.*;

 public class init extends JFrame 
 { 
 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4,jLabel5; 
 	 	private JLabel jLabel7; 

	private JTextField jTextField1; 
	private JComboBox jComboBox1; 
 	private JComboBox jComboBoxz; 
    private JLabel jTextField5; 
 	    private JTextField jTextField7; 
connect d;
 	private JButton jButton1; 
 	private JButton jButtonz; 
	private JButton jButton3; 
	private JButton jButton4,jButton5; 
 	private JPanel contentPane; 
	private JPanel panel;
	public Runtime r;
	int n;
	int i=0,j2;
	String cost="",cost1="";
	int portno,n1;
	String nodename = "",node,des;
	String sysname = "";
	ResultSet rs;
	Connection cs;
	Statement st;
	Border blackline,raisedetched;
		Font font = new Font("TimesRoman",Font.PLAIN,20);
public Vector  totalpeer =new Vector();
  
  public Vector v = new Vector();

 	public init() 
 	{ 
 		super(); 
		
	
 		initializeComponent(); 
 		d=new connect();
		st=d.connect();
 		this.setVisible(true); 
 	} 
  
 	 
 	public void initializeComponent() 
 	{ 
	//	ImageIcon guy = new ImageIcon("");
		JLabel pn = new JLabel();
		pn.setBounds(70,200,300,175);
 		jLabel1 = new JLabel(); 
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
		jLabel5 = new JLabel(); 
				jLabel7= new JLabel(); 

		panel=new JPanel();
 		jTextField1 = new JTextField(); 
		jTextField1.setForeground(Color.BLUE);
 		
		jTextField5 = new JLabel(); 
		jTextField5.setForeground(Color.BLUE);
			jTextField7 = new JTextField(); 
 	    jButton1 = new JButton(); 
 		jButtonz = new JButton(); 
			jButton3 = new JButton(); 
				jButton4 = new JButton(); 
				jButton5 = new JButton(); 
				jComboBox1 = new JComboBox(totalpeer); 
				jComboBox1.setForeground(Color.BLUE);
 		jComboBoxz = new JComboBox(totalpeer); 
		jComboBoxz.setForeground(Color.BLUE);
 		contentPane = (JPanel)this.getContentPane(); 
  
 		
 		jLabel2.setText("<html><font color='white'>System Name</font></html>"); 
 		
 		
		jLabel3.setText("<html><font color='white'>Name</font></html>"); 

 		
 		jLabel4.setText("<html><font color='white'>Link with</font></html>"); 
		jLabel5.setText("<html><font color='white'>Systemscount</font></html>"); 
 		
		 totalpeer.add("Select");
 		jButton1.setText("<html><font color='white'>Submit</font></html>"); 
		jButton1.setBackground(Color.black); 

 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{
				
				
		jButton1_actionPerformed(e);
		i++;
		jTextField5.setText(String.valueOf(i));
				
  
              
			
			
 				
				
		
			
		
 			} 
 		}); 
 		
 		jButtonz.setText( "<html><font color='white'>Links</font></html>");
		jButtonz.setBackground(Color.black); 

 		jButtonz.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
			connect();	
 				jButtonz.setVisible(false);
				 				jButton5.setVisible(true);
								jComboBox1.setVisible(true);
				jComboBoxz.setVisible(true);
								  jLabel3.setVisible(true);
				jLabel4.setVisible(true);

 			} 
  
 		}); 
		jButton4.setText("<html><font color='white'></font></html>"); 
		jButton4.setBackground(Color.black); 

 		jButton4.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
				try
				{
					String nodecount=jTextField5.getText();
				n=Integer.parseInt(nodecount);
				System.out.println("n:"+n);
				if(n!=0)
				{
					
				
				
				jTextField1.setEnabled(true);
				
				jButton1.setEnabled(true);

						jTextField5.setEnabled(false);
										jButton4.setEnabled(false);



				}
				}
				catch (Exception e1)
					{
					JOptionPane.showMessageDialog(null,"Please Enter Value");
				}
				
				
			
 				
 			} 
  
 		}); 
		jButton3.setText("<html><font color='white'>Exit</font></html>"); 
		jButton3.setBackground(Color.black); 

 		jButton3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
				dispose(); 				
 			} 
  
 		}); 

jButton5.setText("<html><font color='white'>Connect</font></html>"); 
jButton5.setBackground(Color.black); 

 		jButton5.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
						jButton5_actionPerformed(e); 
 			} 
  
 		}); 
 		
			
		jTextField5.setEnabled(false);

				jComboBox1.setVisible(false);
				jComboBoxz.setVisible(false);
				jButton5.setVisible(false);
				jLabel3.setVisible(false);
				jLabel4.setVisible(false);
 		contentPane.setLayout(null); 
		 		panel.setLayout(null); 

 	
		//Font font = new Font("TimesRoman", Font.PLAIN, 2);
 		addComponent(contentPane,panel, 15,15,535,450); 
		addComponent(panel, jLabel2, 65,120,109,25); 
 		addComponent(panel, jLabel3, 65,165,109,25); 
 		addComponent(panel, jLabel4, 65,230,109,25); 
		addComponent(panel, jTextField1, 204,120,109,25); 
 		addComponent(panel, jComboBox1, 204,165,109,25); 
 		addComponent(panel, jComboBoxz, 203,230,109,25); 
		addComponent(panel, jButton1, 360,120,109,25); 
	    addComponent(panel, jButtonz, 360,165,109,25); 
        addComponent(panel, jButton3, 360,230,109,25); 
		addComponent(panel, jButton5, 360,165,109,25); 
        addComponent(panel, jLabel5, 65,75,109,25); 
 	    addComponent(panel, jTextField5, 203,75,109,25); 
 	   
 		//addComponent(panel, jButton4, 325,120,100,25); 
		
		panel.add(pn);
		//blackline=BorderFactory.createLineBorder(Color.black);
		//raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		Border etched=BorderFactory.createEtchedBorder();
		Border border=BorderFactory.createTitledBorder(etched,"",TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION,font,Color.white);
		
		panel.setBorder(border);
		panel.setBackground(Color.blue);
		contentPane.setBackground(Color.black);
 		this.setTitle("Details"); 
		//this.setFont(font);
 		this.setLocation(new Point(300, 300));
 		this.setSize(new Dimension(575, 509)); 
 		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
 		this.setResizable(false); 
 	} 
  
 	private void addComponent(Container container,Component c,int x,int y,int width,int height) 
 	{ 
 		c.setBounds(x,y,width,height); 
	//	c.setBorder(blackline);
	//	c.setFont(font);
 		container.add(c); 
		
 	} 
  
 	
 	
 	
  
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 

	
			nodename = jTextField1.getText();
			
				
			if(nodename.equals("")  )
		{
				            	JOptionPane.showMessageDialog(this,"Please enter the corrct value");

		}
		
		else
		{
			try
		{

			
			rs= st.executeQuery("select * from NodeInformation where NodeName LIKE '"+nodename+"' ");  
			if(rs.next())
            {
            	JOptionPane.showMessageDialog(this,"The given Data already Exists");
				i--;
            }
            else
            	{	String query = "insert into NodeInformation values('"+nodename+"','0','127.0.0.1','ON')";
            		st.execute(query);	
            		JOptionPane.showMessageDialog(this,"Node Registered Successfully");
					jTextField1.setText("");

            	  }
		}
			
			catch(Exception ee)
				{
				JOptionPane.showMessageDialog(this,"Specify the Correct Value");
				System.out.println("Connectivity Error");
				ee.printStackTrace();
				i--;
				}
		}
				
			} 
  
 	private void jButton5_actionPerformed(ActionEvent e) 
 	{ 
		try
		{
			
		
		node = (String)jComboBox1.getSelectedItem();
		 des = (String)jComboBoxz.getSelectedItem();
		cost1 = jTextField7.getText();
			System.out.println(""+node);
			System.out.println(""+des);
		
			if(node.equals("Select")||des.equals("Select"))
		{
			JOptionPane.showMessageDialog(this,"Specify the Nodes");
			}
			else if (node.equals(des))
			{
				JOptionPane.showMessageDialog(this,"Specify a Valid Neighbour");
			}
			
			else
		{
		

			try
		{
												// n1=Integer.parseInt(cost1);

			
			rs= st.executeQuery("select * from Connection where NodeName LIKE '"+node+"' AND Neighbour LIKE '"+des+"'");  //OR SystemName LIKE '"+sysname+"'
            System.out.println("1");
			if(rs.next())
            {
            	JOptionPane.showMessageDialog(this,"The given Data already Exists");
           }
            else
            	{
				

				String query = "insert into Connection values('"+node+"','"+des+"',1,'0')";
				String query1= "insert into Connection values('"+des+"','"+node+"',1,'0')";
				
            		st.executeUpdate(query);	
					
					st.executeUpdate(query1);

            		JOptionPane.showMessageDialog(this,"Node "+node+" connected with "+des+" successfully");
            	}
								   					jTextField7.setText("");

			}
			catch(SQLException ee)
				{
				JOptionPane.showMessageDialog(this,"Specify the Correct Value");
				System.out.println("Connectivity Error");
				ee.printStackTrace();
				}

  
 	} 
		}
		
		catch (Exception e3)
		{
			JOptionPane.showMessageDialog(this,"Exception");
			e3.printStackTrace();
			
		}

		}
  public Vector connect()
 {
     
     try
     {
         ResultSet rs=st.executeQuery("select NodeName from NodeInformation");
  		 totalpeer.add("Select");
		
         while(rs.next())
    	 {
		    totalpeer.addElement(rs.getString(1).trim());
			System.out.println(""+totalpeer);
         }
	 }
     catch (Exception ex)
     {
	   ex.printStackTrace();
     }
     return totalpeer;
  }
 	
  

	 
	
  
   

  
  
 } 