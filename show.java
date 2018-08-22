import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import org.gui.JDirectoryDialog; // External Tool for Jfile Chooser
import javax.swing.event.*;


class show extends JFrame implements ActionListener
{

	
	
    JButton jButton1;
	JButton jButton2;
	JButton jButton3;

	static String desdir="",filez="",clj="",enl="",dez="";
File f5;
public	JDirectoryDialog directoryDialog;

	alg aes=new alg();
byte b[];
		JPanel panel=new JPanel();
	static JTextArea text=new JTextArea();
static JScrollPane pane=new JScrollPane(text);


	public show(int f,String filenamez,String enc,String cln,byte blz[])throws Exception
	{
		jButton1=new JButton();
	    jButton2=new JButton();
		jButton3=new JButton();

		jButton1.setText("Save");
		jButton2.setText("Cancel");
		jButton3.setText("Dec");

        panel.setLayout(null);
		panel.add(pane);
		panel.add(jButton1);
	    panel.add(jButton3);
		panel.add(jButton2);
		pane.setBounds(5,5,390,350);
		jButton1.setBounds(75,400,100,25);
		jButton2.setBounds(200,400,100,25);
		jButton3.setBounds(75,400,100,25);

		add(panel);
		filez=filenamez;
		enl=enc;
		clj=cln;
		//b=new byte[cln.length()];
		//b=cln.getBytes();
     b=blz;
		dez=aes.Dec(clj);
		text.setText(dez);
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		jButton3.addActionListener(this);
       jButton1.setVisible(false);
		setSize(400,500);
        setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==jButton1)
			{
				if(directoryDialog == null)
				{
					directoryDialog = new JDirectoryDialog(show.this);
				}
				if(directoryDialog.showDirectoryDialog())
				{
					File destFile = directoryDialog.getSelectedFolder();
					desdir=destFile.getAbsolutePath();
					
				}
				 f5=new File(desdir,filez); 


 
				 if(f5.exists())
					 JOptionPane.showMessageDialog(null,"File Already Exist");

				else
				{
				FileOutputStream fo=new FileOutputStream(f5,true);
				fo.write(b);
				}
				dispose();
			
				
			}
			if(e.getSource()==jButton3)
			{
				 			System.out.println("Dec"); 

				String enz=JOptionPane.showInputDialog("Please give key");
			if(enz.equals(enl))
				{
				JOptionPane.showMessageDialog(null,"Key matched");
				text.setText(clj);
					jButton1.setVisible(true);

				        jButton3.setVisible(false);

				}
				else
				{
				JOptionPane.showMessageDialog(null,"Key not matched");
				}
			}
			if(e.getSource()==jButton2)
			{
		     dispose();
			}

		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}

		
	}
		public static void main(String[] args) 
 	{ 
 		JFrame.setDefaultLookAndFeelDecorated(true); 
 		JDialog.setDefaultLookAndFeelDecorated(true); 
 		try 
 		{ 
	
 		} 
 		catch (Exception ex) 
 		{ 
 			System.out.println("Failed loading L&F: "); 
 			System.out.println(ex); 
 		} 
	}
}
