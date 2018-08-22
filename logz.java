  import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 import java.net.*;
  import javax.swing.border.*;

 public class logz extends JFrame 
 { 
	 public static ServerSocket ssoc1;

	public static Socket sousoc1,ss1;
 	private JLabel label; 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4; 
 	private JLabel jLabel5; 
 	private JTextField field; 
 	private JPasswordField jPassField1; 
 	private JButton login; 
 	private JButton clean; 
 	private JPanel contentPane; 
static   dhtsystem pe1;
  public static String username="";
  static int n;
  		Font font = new Font("TimesRoman",Font.PLAIN,20);

 	public logz() throws Exception
 	{ 
 		super(); 
 		initializeComponent(); 
 		
         
 		this.setVisible(true); 
 	} 
  
 	
 	private void initializeComponent() 
 	{ 
		//ImageIcon guy = new ImageIcon("login.jpg");
		JLabel pn = new JLabel();
		//pn.setBounds(70,200,200,175);
 		label = new JLabel(); 
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
 		jLabel5 = new JLabel(); 
 		field = new JTextField(); 
		field.setForeground(Color.BLUE);
 		jPassField1 = new JPasswordField(); 
 		login = new JButton(); 
 		clean = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		label.setHorizontalAlignment(SwingConstants.CENTER); 
 		label.setHorizontalTextPosition(SwingConstants.CENTER); 
 		label.setText("<html><font color='white'>Name</font></html>"); 
 		
 	
 	
 
 		
 		
 		
 		
 		//userlogin.setText("Login"); 
		login.setText("<html><font color='white'>Login</font></html>"); 
		login.setBackground(Color.black); 

 		login.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				userlogin_actionPerformed(e); 
 			} 
  
 		}); 
 		 
 		//clear.setText("Reset"); 
		clean.setText("<html><font color='white'>clean</font></html>"); 
		clean.setBackground(Color.black); 

 		clean.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				clean_actionPerformed(e);
 			} 
  
 		}); 
 		JPanel panel=new JPanel();
 		contentPane.setLayout(null); 
 		panel.setLayout(null);
 		addComponent(panel, label, 76,80,70,18); 
 		addComponent(panel, jLabel3, 50,25,100,200); 
 		addComponent(panel, field, 202,80,100,28); 
 		addComponent(panel, login, 202,105,100,28); 
 		addComponent(panel, clean, 202,150,100,28); 
		addComponent(panel, pn, 20,60,200,175); 
		//contentPane.add(pn);
		 		addComponent(contentPane, panel, 15,15,370,190); 

 		Border etched=BorderFactory.createEtchedBorder();
		Border border=BorderFactory.createTitledBorder(etched,"",TitledBorder.LEFT,TitledBorder.DEFAULT_JUSTIFICATION,font,Color.blue);
 		this.setTitle("Login"); 
		//contentPane.setBorder(border);
		contentPane.setBackground(Color.black);
				panel.setBackground(Color.blue);

 		this.setLocation(new Point(300, 300));
 		this.setSize(new Dimension(400, 250)); 
 		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
 		this.setResizable(false); 
 	} 
  
 	private void addComponent(Container container,Component c,int x,int y,int width,int height) 
 	{ 
 		c.setBounds(x,y,width,height); 
 		container.add(c); 
 	} 
  
 	 
 	private void userfield_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nuserfield_actionPerformed(ActionEvent e) called."); 
  
 	} 
  
 	private void jPasswordField1_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njPasswordField1_actionPerformed(ActionEvent e) called."); 
  
 	} 
  
 	private void userlogin_actionPerformed(ActionEvent e) 
 	{ 
		try
		{
			username=field.getText();
			

System.out.println("server port:"+n);
		
		pe1.user(username);
	  pe1.initializeComponent();
        dispose();
		
			
			
		}
		catch (Exception e1)
		{
		}
		
 		System.out.println("\nuserlogin_actionPerformed(ActionEvent e) called."); 
  
 	} 
  
 	private void clean_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nclear_actionPerformed(ActionEvent e) called."); 
 		
  field.setText("");
 	} 
  
 	
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
  
 //============================= Testing ================================// 
 //=                                                                    =// 
 //= The following main method is just for testing this class you built.=// 
 //= After testing,you may simply delete it.                            =// 
 //======================================================================// 
 	public static void main(String[] args) 
 	{ 
 		//JFrame.setDefaultLookAndFeelDecorated(true); 
 		//JDialog.setDefaultLookAndFeelDecorated(true); 
 		try 
 		{ 
 pe1=new dhtsystem();
		new logz(); 
		
		n=pe1.connection();
		System.out.println("server port:"+n);
ssoc1=new ServerSocket(n);
		while(true)
		{
		ss1=ssoc1.accept();

		pe1.listen();
		}
			
	
 		} 
 		catch (Exception ex) 
 		{ 
 			System.out.println("Failed loading L&F: "); 
 			System.out.println(ex); 
 		} 
 		
		
		
		
		
		
	
 	} 

  
  
 } 
  
 