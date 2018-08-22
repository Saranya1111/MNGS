import java.net.*;
import java.util.*;
import java.io.*;
class  dhtip
{
	int ch;
	String host="";
	FileInputStream fis;
	
	public String orgin() 
	{
	
		try
		{
			fis=new FileInputStream("network.txt");
			while((ch=fis.read())!=-1)
				host+=(char)ch;
			host.trim();
			System.out.println("The Address is "+host);

		}
		catch(Exception e)
		{
			System.out.println("File Read Exception "+e);
		}

		return host;
		
	}
	
}
