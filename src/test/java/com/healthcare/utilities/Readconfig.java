package com.healthcare.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	
	public static Properties initializeproperties() throws IOException {
		Properties pro=new Properties();
		File file=new File("./Configurations/config.properties");
		try {
		FileInputStream fi=new FileInputStream(file);
		pro.load(fi);
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return pro;
	}

}

