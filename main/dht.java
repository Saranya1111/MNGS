 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*;
 import java.sql.*;
 import java.io.*;
 import java.net.*;
 import javax.swing.table.*;
import java.util.*;
import javax.swing.border.*;

 public class dht extends JFrame 
 { 
    static ServerSocket sersoc;
	static Socket soc,soc1;
	ObjectInputStream dis,dis1;
	ObjectOutputStream dos,dos1,oso;
	InputStream is;
	OutputStream os;
	private JPanel contentPane;
    private connect z;
	ResultSet rs,rs1;
	Connection cs;
	Statement st,st1;
	Vector v,v1,v2;
    static String n="",ip="",ip1="",mostefj="";
   String a[]=new String[100];
   static dht m;
   int portno=9000,port,port1;
   int number;
   static int networkport=5000,f,lazdetj=0;
Font font = new Font("TimesRoman",Font.PLAIN,20);
        JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
	 JScrollPane jsp;
	 static String neta="127.0.0.1#5000";
	 static String netz="127.0.0.1#5007";
	 String serverip="";
	 String nn="";
 	public dht()throws Exception
 	{ 
 		super(); 
		z = new connect();
     	st=z.connect();
st1=z.connect();
        new init();
        nserver();
		String ia=InetAddress.getLocalHost().getHostName();
 		serverip=ia;
 	} 
  
 	
 
  
 		public void nserver()throws Exception
	 {
		 st.execute("delete from nodeinformation");
		   st.execute("delete from connection");
		    
	 }
 	
 		
 		
  
 	
 	
	
public String node()throws Exception
	 {
	 System.out.println("11");
	String 	 node1[],nod="most";
	int i1=0,count1=0,checkcount=0;
	int nodecount[],checkcount1=0;
	rs=st.executeQuery("select count(*) from nodeinformation where status='ON'");
	if(rs.next())
		 {
count1=Integer.parseInt(rs.getString(1));
		 }
		 if(count1>1)
		 {
		  System.out.println("count1:"+count1);
		 node1=new String[count1];
		 nodecount=new int[count1];
	rs=st.executeQuery("select * from nodeinformation where status='ON'");
	while(rs.next())	 
	{
	node1[i1]=rs.getString(1);
		i1++;
	}
	 System.out.println("nodelength:"+node1.length);
	for(int i2=0;i2<node1.length;i2++)
		 {
		 System.out.println("i2");
	rs=st.executeQuery("select count(*) from connection where NodeName='"+node1[i2]+"' or neighbour='"+node1[i2]+"'");
	if(rs.next())
			 {
nodecount[i2]=Integer.parseInt(rs.getString(1));
		 System.out.println(node1[i2]+"'s Connection Count:"+nodecount[i2]);

if(checkcount<nodecount[i2])
				 {
	checkcount=nodecount[i2];
	nod=node1[i2];
				 }
			 }
		 }

 		 System.out.println("Most Deliverable Node is :"+nod+"'s Connection Count:"+checkcount);
		 }
		  System.out.println("nod:"+nod);
mostefj=nod;
if(!nod.equals("most"))
		 {
lazdetj=1;
String sip="",sit="";
 rs=st.executeQuery("Select systemname from nodeinformation where NodeName='"+nod+"'");
		   
	  if(rs.next())
		 {
		 sip=rs.getString(1);
		 }
		 rs=st.executeQuery("Select portno  from nodeinformation where NodeName='"+nod+"'");
		   
	  if(rs.next())
		 {
		sit=rs.getString(1);
		 }
		 		
soc1=new Socket(sip,Integer.parseInt(sit));
	   oso=new ObjectOutputStream(soc1.getOutputStream());
	 
	   oso.writeObject("most");
	 
		 }
return nod;
	 }
	 
  
		
 
	public void listenz()throws Exception
	 {
     
      int port=0;
	  dis=new ObjectInputStream(soc.getInputStream());
	  String listen=(String)dis.readObject();
	System.out.println("listen:"+listen);
	  if(listen.equals("path"))
		 {
	
		 }
		 


		 else if(listen.equals("nodes"))
		 {
			Vector zipname=new Vector();
			   rs=st.executeQuery("select * from nodeinformation where status='ON'");
	while(rs.next())	 
	{
	zipname.add(rs.getString(1));
	}

dos=new ObjectOutputStream(soc.getOutputStream());

dos.writeObject(zipname);
System.out.println("1");	


		 }
else if(listen.equals("ipdetail"))
		 {
		
	  System.out.println("1");
	   String nodes=(String)dis.readObject();
	  
	  	  System.out.println("nodes:"+nodes);
       ip="0";
		   rs=st.executeQuery("Select PortNo from nodeinformation where NodeName='"+nodes+"' ");
		   
	  if(rs.next())
		 {
		 port=Integer.parseInt(rs.getString(1));
		 }
	 rs=st.executeQuery("Select SystemName from nodeinformation where NodeName='"+nodes+"' ");
		   
	  if(rs.next())
		 {
		 ip=rs.getString(1);
		 }
dos=new ObjectOutputStream(soc.getOutputStream());

 String p=String.valueOf(port);
 System.out.println("p:"+p);
 System.out.println("ip:"+ip);
dos.writeObject(ip+"#"+p);
System.out.println("send 1");
	
			
		 }
		 
		  else if (listen.equals("exit"))
		 {
			  //dis=new ObjectInputStream(soc.getInputStream());
			String nn=(String)dis.readObject();
			 System.out.println("z:"+nn);
			 if(nn.equals(mostefj))
			 {
				 			 lazdetj=0;

node();
			 }

			st.executeUpdate( "update nodeinformation set SystemName='0' where NodeName='"+nn+"'" );

		 }
 else if (listen.equals("nodesta"))
		 {
	 			String nn=(String)dis.readObject();
				String nodesta="";
 rs=st.executeQuery("Select status from nodeinformation where NodeName='"+nn+"' ");
		   
	  if(rs.next())
		 {
		 nodesta=rs.getString(1);
		 }
dos=new ObjectOutputStream(soc.getOutputStream());
dos.writeObject(nodesta);

		 }
 else if(listen.equals("most"))
		 {
	 	System.out.println("most:");

String mostndez="";
if(lazdetj==1)
mostndez=mostefj;
else
			 {
mostndez=node();
			 }
	 	System.out.println("mostndez:"+mostndez);

dos=new ObjectOutputStream(soc.getOutputStream());

 

 
	 dos.writeObject(mostndez);
			 
		 }

else if(listen.equals("neta"))
		 {
	dos=new ObjectOutputStream(soc.getOutputStream());

 

 
	 dos.writeObject(neta);
		 }
		 else if(listen.equals("netz"))
		 {
	dos=new ObjectOutputStream(soc.getOutputStream());

 

 
	 dos.writeObject(netz);
		 }
		 
else if(listen.equals("join"))
		 {
	
	dis=new ObjectInputStream(soc.getInputStream());
	System.out.println("1");
 String details=(String)dis.readObject();
 System.out.println("2");
String z[]=details.split("&");
System.out.println("3");
 rs=st.executeQuery("Select * from connection where NodeName='"+z[0]+"' ");
		   
	  if(rs.next())
		 {
		
st.executeUpdate( "insert into nodeinformation values('"+z[0]+"','"+z[2]+"','"+z[1]+"','ON')" );

dos=new ObjectOutputStream(soc.getOutputStream());

 

 
	 dos.writeObject("exist");
			 }
			 else
			 {
st.executeUpdate( "insert into nodeinformation values('"+z[0]+"','"+z[2]+"','"+z[1]+"','ON')" );

st.executeUpdate( "insert into connection values('"+z[0]+"','"+z[3]+"','0','0')" );

st.executeUpdate( "insert into connection values('"+z[3]+"','"+z[0]+"','0','0')" );

				  dos=new ObjectOutputStream(soc.getOutputStream());

 

 
	 dos.writeObject("Submit");
System.out.println(number);
			 }


 

		 }
else if(listen.equals("user"))
		 {
	int flag=0;
	dis=new ObjectInputStream(soc.getInputStream());
	System.out.println("1");
 String details=(String)dis.readObject();
 System.out.println("2");
String z[]=details.split("&");
System.out.println("3");
number=5;
 rs=st.executeQuery("Select PortNo from nodeinformation where NodeName='"+z[0]+"' ");
		   
	  if(rs.next())
		 {
		 number=Integer.parseInt(rs.getString(1));
		 flag=1;
		 }
		 if(flag==1)
			 {
		 if(number==0)
			 {
st.executeUpdate( "update nodeinformation set PortNo='"+z[2]+"' where NodeName='"+z[0]+"'" );
System.out.println("4");
st.executeUpdate( "update nodeinformation set SystemName='"+z[1]+"' where NodeName='"+z[0]+"'" );
System.out.println("5");
dos=new ObjectOutputStream(soc.getOutputStream());

 

 
	 dos.writeObject("ok");
			 }
			 else
			 {
				  dos=new ObjectOutputStream(soc.getOutputStream());

 

 
	 dos.writeObject("exist");
System.out.println(number);
			 }
			 }
			 else
			 {
 dos=new ObjectOutputStream(soc.getOutputStream());

 

 
	 dos.writeObject("no");
			 }

 

		 }
         else
		 {
	 dos=new ObjectOutputStream(soc.getOutputStream());
portno=portno+1;

 String p=String.valueOf(portno);
 System.out.println("p:"+p);


 
	 dos.writeObject(p);
	
System.out.println("send");
		 }
	 }
	 
  

 	public static void main(String[] args) 
 	{ 
 		//JFrame.setDefaultLookAndFeelDecorated(true); 
 		//JDialog.setDefaultLookAndFeelDecorated(true); 
 		try 
 		{ 
			
			sersoc=new ServerSocket(5000);
			m=new dht();
			while(true)
			{
			soc=sersoc.accept();
			m.listenz();
			} 
 		} 
 		catch (Exception ex) 
 		{ 
 			System.out.println("Failed loading L&F: "); 
 			System.out.println(ex); 
 		} 
 		
 	} 
  
  
 } 