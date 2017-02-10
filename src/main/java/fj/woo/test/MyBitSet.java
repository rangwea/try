package fj.woo.test;

public class MyBitSet {
	public static void main(String[] args) {
		short a=2;
		short b=2;
		System.out.println(a^b);
		byte v = (byte) Integer.parseInt("9D", 16);  
		System.out.println(v);
		int c = 0x100F;
		System.out.println(c);
		Integer z = Integer.valueOf("100F", 16);
		System.out.println(z);
		byte byteValue = z.byteValue();
		System.out.println(byteValue);
		byte byteValue2 = Integer.valueOf("11", 2).byteValue();
		System.out.println(byteValue2);  
	}
}
