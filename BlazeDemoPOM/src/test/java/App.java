import java.io.IOException;

import utils.ReadExcel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	String[][] userData = ReadExcel.getData("TestData.xlsx", "Sheet1");
    	for(int i=1 ,j=1,k=2 ;i<userData.length;i++) {
    		
    		
    			
    			System.out.println("Username = "+userData[i][j]);
    			System.out.println("password =" +userData[i][k]);
    		
    		
    		}
    		
    	}
       
    }

