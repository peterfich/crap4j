package org.crap4j.complexity;

import java.io.IOException;

public class ComplexitySubject1TestFixture {

	public void method0() {
		int i = 0;
		i = i + 1;
	}
	
	public void method1(int j) {
		int i=0;
		if (j > 4) {
			i = i  +1;
		} 
	}
	
	public String method2(String in) {
		String res = null;
		if (in == null) {
			res =  "Null";
		} else if (in.equals("Hi")) {
			res = "Hi dude";
		} else if (in.equals("Yo")) {
			res =  "Yo";
		} else {
			res =  "Whatsup";
		}
		return res;
		
	}
	
	public String getAgitarEclipseApiPluginDirectory() throws IOException {
		String tmpVar = System.getProperty("java.io.tmp");
		if (null == tmpVar)
			throw new IllegalStateException("Cannot find the tmp var.");
		return tmpVar;
	}
	
	public int readFile() throws IOException {
		int i = 0;
    try {

    	i = i + 4;
    	return i;
    } finally {    
    	i = i + 5;   
    }
  }
	
	public void switcheroo(int x) {
		switch (x) {
		case 3: {
			System.out.println("3");
			return;
		}
		case 4: {
			System.out.println("4");
			return;
		}
		}
	}
}
