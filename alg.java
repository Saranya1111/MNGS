import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;


public class alg 
{
	KeyGenerator kgen;
	SecretKey skey;
	byte[] raw;
	SecretKeySpec skeySpec;
	String text,ency,ency1;
	byte[] encrypted,encrypted1;

	public alg()throws Exception
	{
		kgen = KeyGenerator.getInstance("RC4");
        skey = kgen.generateKey();
        raw = skey.getEncoded();
        skeySpec = new SecretKeySpec(raw, "RC4");
	}


	public String Enc(String text) throws Exception{
		
		Cipher cipher = Cipher.getInstance("RC4");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        encrypted = cipher.doFinal(text.getBytes());
		ency = new String(encrypted);
		//System.out.println(ency);
		return ency;
	}
	
	public String Dec(String text)throws Exception{

		Cipher cipher1 = Cipher.getInstance("RC4");
        cipher1.init(Cipher.DECRYPT_MODE,skeySpec);
        encrypted1 = cipher1.doFinal(text.getBytes());
		ency1 = new String(encrypted1);
		//System.out.println(ency1);
		return ency1;
	
	}
	
	
}