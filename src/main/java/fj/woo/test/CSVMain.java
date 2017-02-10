package fj.woo.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

public class CSVMain {
	
	public static void main(String[] args) throws FileNotFoundException {
		CsvWriterSettings writerSettings = new CsvWriterSettings();
		// Any null values will be written as ?
		writerSettings.setNullValue("");
		writerSettings.setRowWriterProcessor(new BeanWriterProcessor<TestBean>(TestBean.class));
	    writerSettings.setHeaders("姓名", "年龄");

	    CsvWriter writer = new CsvWriter(new File("F:\\a.csv"), writerSettings);

	    writer.writeHeaders();
	    
	    List<TestBean> results = new ArrayList<CSVMain.TestBean>();
	    
	    CSVMain csvMain = new CSVMain();
	    TestBean testBean = csvMain.new TestBean();
    	testBean.setName("aaaa");
    	testBean.setAge("12545545,4888455\t");
    	results.add(testBean);
	    
    	TestBean testBean2 = csvMain.new TestBean();
    	testBean2.setName("bbb");
    	testBean2.setAge("13:\"fdfdsdf\"");
    	results.add(testBean2);
    	
    	TestBean testBean3 = csvMain.new TestBean();
    	testBean3.setName("bbb");
    	testBean3.setAge("13");
    	results.add(testBean3);
    	
    	writer.processRecordsAndClose(results);
	    

	    System.out.println("完成……");

	}
	
	public class TestBean{
		@Parsed(field="姓名")
		private String name;
		
		@Parsed(field="年龄")
		private String age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
	}

}
