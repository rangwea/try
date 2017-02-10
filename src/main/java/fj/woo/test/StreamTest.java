package fj.woo.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class StreamTest {
	private static InputStream in = null; 
	
	static{
		try {
			in = new FileInputStream(new File("f:/新建文本文档.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		//转成buffer型
		in = new BufferedInputStream(in);
		StringBuilder stringBuilder1 = new StringBuilder(); 
		byte[] b = new byte[128];
		//标记
		in.mark(0);
		while (in.read(b) > 0) {  
            stringBuilder1.append(b.toString());
		}
		System.out.println(stringBuilder1.toString());		
		System.out.println("-------------------------------------------");
		//重置
		in.reset();
		StringBuilder stringBuilder2= new StringBuilder(); 
		while (in.read(b)> 0) {  
            stringBuilder2.append(b.toString());  
		}
		System.out.println(stringBuilder2.toString());		
	}
}
