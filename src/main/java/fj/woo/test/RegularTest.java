package fj.woo.test;

public class RegularTest {
	public static void main(String[] args) {
		String orderTypeStr = "23";
		
		System.out.println(orderTypeStr.matches("0"));
		System.out.println(orderTypeStr.matches("0[123]+"));
		System.out.println(orderTypeStr.matches("([12]+)(3*)"));
		System.out.println(orderTypeStr.matches("3+"));
	}
}
