/*
 * ������CardData
 * ��Ҫ������getRandomCardData();(��̬)static{}
 * ���ã���ʼ�������������ݼ��ϣ��������������ݼ����������дﵽϴ��Ŀ��
 */
package Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardData {
	private static List<String> cardData = new ArrayList<>();		//�������Ƽ���
	
	static {		//�Ͽθ�ѧ�ķ���
		for(int i = 1;i <= 4;i++) {				//�����еĿ������Ƴ�ʼ����������
			for(int j = 1;j <= 13;j++) {
				String cardName = i + "-" + j;
				cardData.add(cardName);
			}
		}
		cardData.add("5-1");
		cardData.add("5-2");
	}
	
	public static List<String> getRandomCardData() {		//�����ƴ���˳�򷵻س�ȥ
		Collections.shuffle(cardData);
		return cardData;
	}
}
