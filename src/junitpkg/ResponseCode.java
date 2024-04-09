package junitpkg;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Test;

public class ResponseCode {
	
	String link="https://www.facebook.com";
	
	@Test
	public void test()
	{
		try {
			URL obj=new URL(link);
			HttpURLConnection conn=(HttpURLConnection) obj.openConnection();
			int code=conn.getResponseCode();
			System.out.println(code);
		}
		catch(Exception e)
		{
			System.out.println("null");
		}
	}
}
