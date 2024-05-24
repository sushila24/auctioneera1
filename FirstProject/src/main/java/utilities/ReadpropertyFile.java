package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
FileReader fr=new FileReader("E:\\workspaceApril\\FirstProject\\src\\test\\resources\\configfiles\\config.properties");
Properties prop=new Properties();
prop.load(fr);
//System.out.println(prop.getProperty("browser"));
//System.out.println(prop.getProperty("testurl"));
	}

}
