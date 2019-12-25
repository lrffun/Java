/*
 * 类名：CardData
 * 主要方法：getRandomCardData();(静态)static{}
 * 作用：初始话卡牌名称数据集合，将卡牌名称数据集合乱序排列达到洗牌目的
 */
package Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardData {
	private static List<String> cardData = new ArrayList<>();		//卡牌名称集合
	
	static {		//上课刚学的方法
		for(int i = 1;i <= 4;i++) {				//将所有的卡牌名称初始化进集合中
			for(int j = 1;j <= 13;j++) {
				String cardName = i + "-" + j;
				cardData.add(cardName);
			}
		}
		cardData.add("5-1");
		cardData.add("5-2");
	}
	
	public static List<String> getRandomCardData() {		//将卡牌打乱顺序返回出去
		Collections.shuffle(cardData);
		return cardData;
	}
}
