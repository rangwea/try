package fj.woo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ReadFile {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		try {
			InputStream in = new FileInputStream(new File("f:/新建文本文档.txt"));
			byte[] b = new byte[128];
			while (in.read(b) > 0) {  
	            System.out.println(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
