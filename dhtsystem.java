import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
 import javax.swing.border.*;



public class dhtsystem extends JFrame
{
	
	
 
	
	private JTextField jTextField1,sourcefield;
	private JTextField jComboBox1;
	public static JList jTextPane1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane5;
	private JButton jButton1;
	private JButton jButtonz;
	private JButton jButton3;
	private JButton jButton5;
		private JButton jButtone;
	private JButton jButtonu;
	private JButton jButtonx;

	private JTextArea sarea;
	private JTabbedPane jTabbedPane1;
	private JPanel contentPane;
	private JPanel jPanel1;
    public static JLabel jLabel5;
	private JTextPane jTextPane2;
	private JScrollPane jScrollPane2;
	private JButton jButton4;
	private JPanel jPanel2;
    private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
static String user,substr,filenamez,enz="",enc="",nuc="",t;
	String desdir,path1="";
	File f;
	String file;
	static String msg,request1,port,z,filepathz="/com/easynth/lookandfeel/";
	String path,name[],guid,encmsg="",stem;
	static dhtsystem c;
    static Vector v1,d1,mnode,mfile;
    int p,gui,slp=25000;
	logz u;
Font font = new Font("TimesRoman",Font.PLAIN,20);
show rd;
    static ServerSocket sers;
    static Socket sousoc1,soc;
    ObjectInputStream osi;
    ObjectOutputStream oso;
    String sourcename,desname;
	alg aes=new alg();
byte blp[];

	dhtip net1=new dhtip();
String network=net1.orgin();

String net[]=network.split("#");

dhtconfig nez=new dhtconfig();
String cez=nez.orgin();

String ipc[]=cez.split("#");

	public dhtsystem()throws Exception
	{
		super();
		
    }

	
	public void initializeComponent()throws Exception
	{
		
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();

		jTabbedPane1 = new JTabbedPane();
		contentPane = (JPanel)this.getContentPane();
		
		jTextField1 = new JTextField();
		sarea = new JTextArea();
		jComboBox1 = new JTextField();
		jTextPane1 = new JList();
		jScrollPane1 = new JScrollPane();
		jButton1 = new JButton();
		jButtonz = new JButton();
		jButton3 = new JButton();
		jButtonu = new JButton();

		jPanel1 = new JPanel();
	
		jPanel2 = new JPanel();
		jLabel5 = new JLabel();
		
		sourcefield = new JTextField();
		
		jButton5 = new JButton();
		jScrollPane5 = new JScrollPane(sarea);
				jButtone = new JButton();
						jButtonx = new JButton();

mnode=new Vector();
mfile=new Vector();
		
		mkdsyte();
mkdipnx();
		jLabel3.setText("<html><font color='white'>Logs</font></html>");
		
		jLabel1.setText( "<html><font color='white'>File</font></html>");
		
		jLabel4.setText("<html><font color='white'>Selected</font></html>");
		
		
		
		
		
		contentPane.setLayout(null);
		
		addComponent(contentPane, jPanel1, 15,15,510,437);
		
		jTextField1.setText("");
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		
		
		
		
		//jTextPane1.setText("");
		
		jScrollPane1.setViewportView(jTextPane1);
		
		jButton1.setText("<html><font color='white'>...</font></html>");
		jButton1.setBackground(Color.black); 

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				File f2;
				try{
		        JFileChooser jf=new JFileChooser();
		        int m1=jf.showOpenDialog(null);				
				if(m1==JFileChooser.APPROVE_OPTION)
				{
				
				   f2=jf.getSelectedFile();
				   path=f2.getPath();
				   file=f2.getName();
				   FileInputStream fis=new FileInputStream(path);
				   File f=new File(path);
	               jTextField1.setText(path); 
	               blp=new byte[fis.available()];
	               fis.read(blp);			
			       msg=new String(blp);
			      // jTextPane1.setText(msg);
				   //enz=JOptionPane.showInputDialog("Please give key");
			      // System.out.println("enz:"+enz);

				    encmsg=aes.Enc(msg);
			       //jTextPane1.setText(encmsg);

		        }
		        }
				catch(Exception e1)
				{
					e1.printStackTrace();
				}

				

				jButton1_actionPerformed(e);
			}

		});
		
		jButtonz.setText("<html><font color='white'>Shared</font></html>");
		jButtonz.setBackground(Color.black); 


		jButtonz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					File f5= new File(".","/shd/"+file);
		FileOutputStream fo=new FileOutputStream(f5,true);
				fo.write(encmsg.getBytes());
				fo.close();
				
					net=network.split("#");
					soc=new Socket(net[0],Integer.parseInt(net[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	  String sname=sourcefield.getText();
	   String desname=jComboBox1.getText();
	   oso.writeObject("most");
      osi=new ObjectInputStream(soc.getInputStream());
	 String zipname=(String)osi.readObject();
	 System.out.println("mostnode : "+zipname);
if(!zipname.equals("most"))
					{
	 soc=new Socket(net[0],Integer.parseInt(net[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	  
	   oso.writeObject("ipdetail");
	    oso.writeObject(zipname);
     osi=new ObjectInputStream(soc.getInputStream());
	 String zipdetail=(String)osi.readObject();
	 System.out.println("zipdetail : "+zipdetail);
     String zetdetail[]=zipdetail.split("#");
		soc=new Socket(zetdetail[0],Integer.parseInt(zetdetail[1]));
	    oso=new ObjectOutputStream(soc.getOutputStream());
	 
	    oso.writeObject("filecon");
	    oso.writeObject(file);
	    oso.writeObject(blp);
        oso.writeObject(t);
					}
					else
					{
	 System.out.println("mostnode : "+zipname);

					}
jTextField1.setText("");
			sourcefield.setText("");
			jComboBox1.setText("");
			//jTextPane1.setText("");
				
				 f5= new File(".",filepathz+file);
		 fo=new FileOutputStream(f5,true);
				fo.write(blp);
				fo.close();

				}
					
				
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				jButton2_actionPerformed(e);

			}

		});
		
		jButton3.setText("<html><font color='white'>Clean</font></html>");
		jButton3.setBackground(Color.black); 

		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton3_actionPerformed(e);
			}

		});
		
		jButton5.setText("<html><font color='white'>Download</font></html>");
		jButton5.setBackground(Color.black); 

		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try{
									System.out.println("down:"+z);

					String filendz[]=z.split("-");
					String fnodejx="";
					int flagz=0;
/*for (int i=0;i<fcahez.size();i++)
{
	if(filendz.equals(String.valueOffcahez.elementAt(i))))
	{
flagz=1;
	}
}*/
if(flagz==0)
					{
		        
	 int detailj=0;
		        net=network.split("#");

soc=new Socket(net[0],Integer.parseInt(net[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	  
	   oso.writeObject("ipdetail");
	    oso.writeObject(filendz[0]);
     osi=new ObjectInputStream(soc.getInputStream());
	 String zipdetail=(String)osi.readObject();
	 System.out.println("zipdetail : "+zipdetail);
     String zetdetail[]=zipdetail.split("#");
	 if(!zetdetail[0].equals("0"))
						{
		soc=new Socket(zetdetail[0],Integer.parseInt(zetdetail[1]));
	    oso=new ObjectOutputStream(soc.getOutputStream());
	 
	    oso.writeObject("filedon");
			    oso.writeObject(filendz[1]);
				  osi=new ObjectInputStream(soc.getInputStream());
	 String filesta=(String)osi.readObject();
	 System.out.println("filesta : "+filesta);
	 if(filesta.equals("y"))
	{
     byte b[]=(byte [])osi.readObject();
	 	 String display=(String)osi.readObject();
		 	 	 String dintx=(String)osi.readObject();
	 System.out.println("Key : "+dintx);

JOptionPane.showMessageDialog(null,"File :"+filendz[1]+"\n"+"Node :"+display+"\n"+"Complet");
	 new show(1,filendz[1],dintx, new String(b),b);
	
	}
	
					}
	else
	{
		net=network.split("#");
					soc=new Socket(net[0],Integer.parseInt(net[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	
	   oso.writeObject("most");
      osi=new ObjectInputStream(soc.getInputStream());
	 String zipnamt=(String)osi.readObject();
	 System.out.println("mostnodt : "+zipnamt);
if(!zipnamt.equals("most"))
					{
	 soc=new Socket(net[0],Integer.parseInt(net[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	  
	   oso.writeObject("ipdetail");
	    oso.writeObject(zipnamt);
     osi=new ObjectInputStream(soc.getInputStream());
	  zipdetail=(String)osi.readObject();
	 System.out.println("zipdetail : "+zipdetail);
     zetdetail=zipdetail.split("#");
		soc=new Socket(zetdetail[0],Integer.parseInt(zetdetail[1]));
	    oso=new ObjectOutputStream(soc.getOutputStream());
	 
	    oso.writeObject("filemos");
		oso.writeObject(filendz[1]);
				  osi=new ObjectInputStream(soc.getInputStream());
	 String filemos=(String)osi.readObject();
	 System.out.println("filemos : "+filemos);
if(filemos.equals("y"))
	{
     byte b[]=(byte [])osi.readObject();
	 	 String display=(String)osi.readObject();
		 	 	 String dintx=(String)osi.readObject();
	 System.out.println("Key : "+dintx);

	 JOptionPane.showMessageDialog(null,"File :"+filendz[1]+"\n"+"Node :"+display+"\n"+"Complet");

	 new show(1,filendz[1],dintx, new String(b),b);
	}
	}
	else
		{
		}
}
					
}
		        }
		        
				catch(Exception e1)
				{
					e1.printStackTrace();
				}

				

				jButton1_actionPerformed(e);
			}

		});
		
		jButtonu.setText("<html><font color='white'>Chek</font></html>");
		jButtonu.setBackground(Color.black); 

		jButtonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try{
String filendz=jComboBox1.getText();
net=network.split("#");
					soc=new Socket(net[0],Integer.parseInt(net[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	  
	   oso.writeObject("most");
      osi=new ObjectInputStream(soc.getInputStream());
	 String zipnamt=(String)osi.readObject();
	 System.out.println("mostnodt : "+zipnamt);
if(!zipnamt.equals("most"))
					{
	 soc=new Socket(net[0],Integer.parseInt(net[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	  
	   oso.writeObject("ipdetail");
	    oso.writeObject(zipnamt);
     osi=new ObjectInputStream(soc.getInputStream());
	 String zipdetail=(String)osi.readObject();
	 System.out.println("zipdetail : "+zipdetail);
     String zetdetail[]=zipdetail.split("#");
		soc=new Socket(zetdetail[0],Integer.parseInt(zetdetail[1]));
	    oso=new ObjectOutputStream(soc.getOutputStream());
	 
	    oso.writeObject("filenxz");
		oso.writeObject(filendz);
				  osi=new ObjectInputStream(soc.getInputStream());
				  String filemos=(String)osi.readObject();
	 System.out.println("filemos : "+filemos);
if(filemos.equals("y"))
	{
				Vector filenxz=(Vector)osi.readObject();
 System.out.println("filenxz : "+filenxz);
 jTextPane1.setListData(filenxz);
 JOptionPane.showMessageDialog(null,"File :"+filendz+"\n"+"is availble in same");

	}
	else
						{
JOptionPane.showMessageDialog(null,"File :"+filendz+"\n"+"is not in same");
net=network.split("#");
					soc=new Socket(net[0],Integer.parseInt(net[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	  
	   oso.writeObject("netz");
      osi=new ObjectInputStream(soc.getInputStream());
	 String nextipz=(String)osi.readObject();
	 String nextipf[]=nextipz.split("#");
	 System.out.println("nextipz : "+nextipz);
soc=new Socket(nextipf[0],Integer.parseInt(nextipf[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	  
	   oso.writeObject("most");
      osi=new ObjectInputStream(soc.getInputStream());
	  zipnamt=(String)osi.readObject();
	 System.out.println("mostnodt : "+zipnamt);
if(!zipnamt.equals("most"))
					{
	 soc=new Socket(nextipf[0],Integer.parseInt(nextipf[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	  
	   oso.writeObject("ipdetail");
	    oso.writeObject(zipnamt);
     osi=new ObjectInputStream(soc.getInputStream());
	  zipdetail=(String)osi.readObject();
	 System.out.println("zipdetail : "+zipdetail);
      zetdetail=zipdetail.split("#");
		soc=new Socket(zetdetail[0],Integer.parseInt(zetdetail[1]));
	    oso=new ObjectOutputStream(soc.getOutputStream());
	 
	    oso.writeObject("filenxz");
		oso.writeObject(filendz);
				  osi=new ObjectInputStream(soc.getInputStream());
				   filemos=(String)osi.readObject();
	 System.out.println("filemos : "+filemos);
if(filemos.equals("y"))
	{
			Vector	 filenxz=(Vector)osi.readObject();
 System.out.println("filenxz : "+filenxz);
 jTextPane1.setListData(filenxz);
 JOptionPane.showMessageDialog(null,"File :"+filendz+"\n"+"is availble in netz");

	}

						}
						else
							{

							}
						}
					}
					else
					{
System.out.println("waste");
					}
				}
				catch(Exception u)
				{
				}
			}
			});

jTextPane1.addListSelectionListener(new ListSelectionListener() { 
 			
			public void valueChanged(ListSelectionEvent e) 
 			{ 
 				//jList1_valueChanged(e); 
				Object o = jTextPane1.getSelectedValue(); 
				z=o.toString();
				System.out.println("z:"+z);

 			} }); 

jButtonx.setText("<html><font color='white'>Exit</font></html>");
		jButtonx.setBackground(Color.black); 

		jButtonx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try{
net=network.split("#");
					soc=new Socket(net[0],Integer.parseInt(net[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	  
	   oso.writeObject("exit");
	   	   oso.writeObject(t);
		   System.exit(0);

				}
				catch(Exception x)
				{}
			}
		});
		jPanel1.setLayout(null);
	  //  jPanel1.setBackground(new Color(255,255,255));
		addComponent(jPanel1, jLabel3, 50,230,100,25);
	    addComponent(jPanel1, jLabel4, 25,50,100,25);
		addComponent(jPanel1, jLabel2, 410,230,100,25);

		addComponent(jPanel1, jTextField1, 144,50,180,25);
		addComponent(jPanel1, jLabel1, 25,150,100,25);
        addComponent(jPanel1,jComboBox1, 144,150,100,25);
		addComponent(jPanel1, jScrollPane1, 50,250,300,200);

		addComponent(jPanel1, jButton1, 330,50,39,25);
		addComponent(jPanel1, jButtonz, 390,100,100,25);
		addComponent(jPanel1, jButton3, 396,150,100,25);
	    addComponent(jPanel1, jButton5, 410,195,100,25);
				addComponent(jPanel1, jButtonu, 150,190,100,25);
		addComponent(jPanel1, jButtonx, 430,250,100,25);

	addComponent(jPanel1, jLabel5, 250,75,125,25);
	
		jPanel1.setBackground(Color.blue);
		contentPane.setBackground(Color.black);
		
		
		jButtone.setText("<html><font color='white'>Exit</font></html>");
		jButtone.setBackground(Color.black); 

		jButtone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try{
net=network.split("#");
					soc=new Socket(net[0],Integer.parseInt(net[1]));
	   oso=new ObjectOutputStream(soc.getOutputStream());
	
	   oso.writeObject("exit");
	   System.exit(0);
				}
				catch(Exception x)
				{
				}
			}
			});
		


		
		//contentPane.setBackground(Color.LIGHT_GRAY);
		this.setTitle("Welcome :    "+t );
		this.setLocation(new Point(2, 0));
		this.setSize(new Dimension(550, 500));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

public void listen()throws Exception
	{
 osi=new ObjectInputStream(u.ss1.getInputStream());
	  String listen=(String)osi.readObject();
	
	String listenz[]=listen.split(">");
	if(listenz[0].equals(sourcename))
		{
		
		}
		
		else if(listenz[0].equals("most"))
		{
 
	
jLabel5.setText("IPNODE");

	   mkdipne();
	  
		}

else if(listenz[0].equals("filedon"))
		{
		String	filenam=(String)osi.readObject();
		File x=new File(".",filepathz+filenam);
		if(x.exists())
			{
				 System.out.println("filedon :y");

		FileInputStream f=new FileInputStream(x);
			
				byte blz[]=new byte[f.available()];
	               f.read(blz);	
 oso=new ObjectOutputStream(u.ss1.getOutputStream());
	 
	    oso.writeObject("y");
 oso.writeObject(blz);
 oso.writeObject(t);
 Random d=new Random();
 int dintz=d.nextInt(1000);
  oso.writeObject(t+String.valueOf(dintz));

			}
			else
			{
								 System.out.println("filedon :n");

 oso=new ObjectOutputStream(soc.getOutputStream());
	 
	    oso.writeObject("n");
			}
		
		}
		else if(listenz[0].equals("filemos"))
		{
		String	filenam=(String)osi.readObject();
		File x=new File(".",filepathz+filenam);
		if(x.exists())
			{
		FileInputStream f=new FileInputStream(x);
			
				byte blz[]=new byte[f.available()];
	               f.read(blz);	
 oso=new ObjectOutputStream(u.ss1.getOutputStream());
	 
	    oso.writeObject("y");
 oso.writeObject(blz);
 	    oso.writeObject("IPNODE");
 Random d=new Random();
 int dintz=d.nextInt(1000);
  oso.writeObject(t+String.valueOf(dintz));
			}
			else
			{
 oso=new ObjectOutputStream(u.ss1.getOutputStream());
	 
	    oso.writeObject("n");
			}
		
		}

		else if(listenz[0].equals("filenxz"))
		{
		String	filenam=(String)osi.readObject();
		int flagi=0;
Vector mnodezj=new Vector();
Vector mfilezj=new Vector();
for(int zn=0;zn<mfile.size();zn++)
		  {
			int flagj=0;

		  String filenas=String.valueOf(mfile.elementAt(zn));
		  File fzn=new File(".","/ipnodez/"+filenas);
		  FileInputStream f=new FileInputStream(fzn);
			
				byte blz[]=new byte[f.available()];
	               f.read(blz);	
		  String stz=new String(blz); // covert byte into string
				StringTokenizer token=new StringTokenizer(stz); // split the file content into the individual string
				while(token.hasMoreTokens())
				{
					String s= token.nextToken();

if(s.equalsIgnoreCase(filenam) && flagj==0)
			  {
System.out.println("yes");
mnodezj.add(String.valueOf(mnode.elementAt(zn))+"-"+filenas+"-"+"neta"+"-");
//mfilezj.add(filenams);
System.out.println("che");
flagi=1;
flagj=1;
			  }
				}
		  }
		  System.out.println("flagi"+flagi);
		 // System.out.println("flagj"+flagj);

			 if(flagi==0)
			{
		  oso=new ObjectOutputStream(u.ss1.getOutputStream());
	 
	    oso.writeObject("n");
			}
			else
			{
  oso=new ObjectOutputStream(u.ss1.getOutputStream());
	 
	    oso.writeObject("y");
        oso.writeObject(mnodezj);

        //oso.writeObject(mfilezj); 
			}
		
		
		}
		
		else if(listenz[0].equals("filecon"))
		{
		String	filenam=(String)osi.readObject();
		byte	blz[]=(byte[])osi.readObject();
		String	nodemz=(String)osi.readObject();
File f5= new File(".","/ipnodez/"+filenam);
		FileOutputStream fo=new FileOutputStream(f5,true);
				fo.write(blz);
				String blzstn=new String(blz);
				stem x=new stem();
				x.init();
				    ArrayList stn = x.steu(blzstn);
					String	contez="";
for(int zn=0;zn<stn.size();zn++)
		  {
contez=contez+stn.get(zn)+",";
		  }
		 
				 f5= new File(".","/index/"+filenam);
		fo=new FileOutputStream(f5,true);
			fo.write(contez.getBytes());
mnode.add(nodemz);
mfile.add(filenam);
		}
		
		}

	public int connection()throws Exception
	{
sousoc1=new Socket(net[0],Integer.parseInt(net[1]));
 oso=new ObjectOutputStream(sousoc1.getOutputStream());
	 

	
	   oso.writeObject("hai");
	   
	   osi=new ObjectInputStream(sousoc1.getInputStream());
	   port=(String)osi.readObject();
	
	   System.out.println("port:"+port);
	
	   p=Integer.parseInt(port);
	  
	   return p;

	}

	public void user(String username)throws Exception
	{
	sousoc1=new Socket(net[0],Integer.parseInt(net[1]));
	oso=new ObjectOutputStream(sousoc1.getOutputStream());
 oso.writeObject("user");
 t=username;
  String ia=InetAddress.getLocalHost().getHostName();
 oso=new ObjectOutputStream(sousoc1.getOutputStream());
 oso.writeObject(username+"&"+ia+"&"+String.valueOf(p));
	    System.out.println("username:"+username);
		
		 osi=new ObjectInputStream(sousoc1.getInputStream());
	  String z1=(String)osi.readObject();
	  if(z1.equals("exist"))
		{
		  JOptionPane.showMessageDialog(null,"Already Exist ");
		  System.exit(0);
		}
		  if(z1.equals("no"))
		{
		  JOptionPane.showMessageDialog(null,"You are not Authorized Member");
		  System.exit(0);
		}
	}

	private void jTabbedPane1_stateChanged(ChangeEvent e)
	{
		System.out.println("\njTabbedPane1_stateChanged(ChangeEvent e) called.");

	}

	private void jTextField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");

	}

	

	private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		
	}

	private void jButton2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
		
	}


private void jButton3_actionPerformed(ActionEvent e)
	{
		try
		{
			jTextField1.setText("");
			sourcefield.setText("");
			jComboBox1.setText("");
	//		jTextPane1.setText("");

		}
		catch (Exception z)
		{
		}
		 
	}





public void mkdsyte() throws Exception
		{
	File fd5=new File(".","/shd");
			boolean bo7=fd5.exists();
			System.out.println("bo7:"+bo7);
			if(bo7==false)
				{

bo7=fd5.mkdir();
System.out.println("bo7:"+bo7);

				}
				else
			{
String fd7list[]=fd5.list();
for(int zn=0;zn<fd7list.length;zn++)
		  {
		  String sharestring=fd7list[zn];
		  File fzn=new File(".","/shd/"+sharestring);
		  boolean fznboolean=fzn.delete();
		 			  		  System.out.println("fznboolean:"+fznboolean);

		  }
 boolean fznboolean7=fd5.delete();
		 			  		  System.out.println("fznboolean7:"+fznboolean7);
System.out.println("6");
bo7=fd5.mkdir();
System.out.println("bo7:"+bo7);
System.out.println("else");

		}




		}

public void mkdipne() throws Exception
		{
	File fd5=new File(".","/ipnodez");
			boolean bo7=fd5.exists();
			System.out.println("bo7:"+bo7);
			if(bo7==false)
				{

bo7=fd5.mkdir();
System.out.println("bo7:"+bo7);

				}
				else
			{
String fd7list[]=fd5.list();
for(int zn=0;zn<fd7list.length;zn++)
		  {
		  String sharestring=fd7list[zn];
		  File fzn=new File(".","/ipnodez/"+sharestring);
		  boolean fznboolean=fzn.delete();
		 			  		  System.out.println("fznboolean:"+fznboolean);

		  }
 boolean fznboolean7=fd5.delete();
		 			  		  System.out.println("fznboolean7:"+fznboolean7);
System.out.println("6");
bo7=fd5.mkdir();
System.out.println("bo7:"+bo7);
System.out.println("else");

		}




		}
public void mkdipnx() throws Exception
		{
	File fd5=new File(".","/index");
			boolean bo7=fd5.exists();
			System.out.println("bo7:"+bo7);
			if(bo7==false)
				{

bo7=fd5.mkdir();
System.out.println("bo7:"+bo7);

				}
				else
			{
String fd7list[]=fd5.list();
for(int zn=0;zn<fd7list.length;zn++)
		  {
		  String sharestring=fd7list[zn];
		  File fzn=new File(".","/index/"+sharestring);
		  boolean fznboolean=fzn.delete();
		 			  		  System.out.println("fznboolean:"+fznboolean);

		  }
 boolean fznboolean7=fd5.delete();
		 			  		  System.out.println("fznboolean7:"+fznboolean7);
System.out.println("6");
bo7=fd5.mkdir();
System.out.println("bo7:"+bo7);
System.out.println("else");

		}




		}

}
