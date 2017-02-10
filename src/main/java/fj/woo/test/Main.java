package fj.woo.test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.ParseException;

import org.apache.log4j.Logger;

public class Main {
	
	private static Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args) throws ParseException, UnknownHostException, IOException {
		System.out.println("011233".matches("[123]+"));
	}
	
	private static int test() throws TestException{
		try {
			int a=1/0;
		} catch (Exception e) {
			throw new TestException();
		}
		return 1;
	}
	
	public void checkDuplicates(int[] array) {
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int num0 = num - 1; // bitset starts at 0, numbers start at 1
			if (bs.get(num0)) {
				System.out.println(num);
			} else {
				bs.set(num0);
			}
		}
	}

	class BitSet {
		int[] bitset;

		public BitSet(int size) {
			bitset = new int[size >> 5]; // divide by 32
		}

		boolean get(int pos) {
			int wordNumber = (pos >> 5); // divide by 32
			int bitNumber = (pos & 0x1F); // mod 32
			return (bitset[wordNumber] & (1 << bitNumber)) != 0;
		}

		void set(int pos) {
			int wordNumber = (pos >> 5); // divide by 32
			int bitNumber = (pos & 0x1F); // mod 32
			bitset[wordNumber] |= 1 << bitNumber;
		}
	}
}
