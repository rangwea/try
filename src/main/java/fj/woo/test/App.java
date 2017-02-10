package fj.woo.test;

import java.text.AttributedString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
	
	private final static String CX_SERVICE_ID="1";
    public static void main( String[] args ){
    	try {
			int a = 1/0;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println(444);
    }
    
	private static void aa(List<Map<String, String>>  orderList) {
		StringBuilder caseType = new StringBuilder();

		if (orderList.size() <= 0)
			return;
		// 确定是否有查勘订单
		Map<String, String> firstOrder = orderList.get(0);
		String orderType = firstOrder.get("orderType");
		if("0".equals(orderType)){
			caseType.append("10");
		}else{
			caseType.append("!10-");
			System.out.println(caseType);
			return;
		}

		String sourceSign = "+";
		if (orderList.size() > 1) {
			for (int i = 1; i < orderList.size(); i++) {
				// 订单来源(0独立 1追加)
				Map<String, String> otherOrder = orderList.get(i);
				String orderSource = otherOrder.get("orderSource");
				// 订单类型连接符号(都是追加为"+"， 有独立为"-" )
				if("0".equals(orderSource)){
					sourceSign = "-";
					break;
				}
			}
			caseType.append(sourceSign);
		}

		System.out.println(caseType);
	}
}
