import java.util.ArrayList;
import java.util.Iterator;

public class Sort {

	ArrayList<WebPage> webPagelist;

	public Sort(ArrayList<WebPage> webPagelist) {
		this.webPagelist = webPagelist;
	}

	public void sortSite(int leftbound, int rightbound) {
		if (leftbound < rightbound) {
			int partitionIndex = partition(leftbound, rightbound);
			sortSite(leftbound, partitionIndex - 1);
			sortSite(partitionIndex + 1, rightbound);
		}
	}

	private int partition(int leftbound, int rightbound) {
		double pivot = webPagelist.get(rightbound).getScore();
		int i = (leftbound - 1);

		for (int j = leftbound; j < rightbound; j++) {
			if (webPagelist.get(j).getScore() > pivot) { // 逆序比较
				i++;
				swap(i, j);
			}
		}

		swap(i + 1, rightbound);
		return i + 1;
	}

	private void swap(int aIndex, int bIndex) {
		WebPage temp = webPagelist.get(aIndex);
		webPagelist.set(aIndex, webPagelist.get(bIndex));
		webPagelist.set(bIndex, temp);
	}

	public void delcontact(ArrayList<WebPage> pages) {
		Iterator<WebPage> iterator = webPagelist.iterator();
		while (iterator.hasNext()) {
			WebPage page = iterator.next();
			if (page.name.contains("博客來") || page.name.contains("金石堂") || page.name.contains("誠品")
					|| page.name.contains("淘寶") || page.name.contains("商") || page.name.contains("蝦皮")
					|| page.name.contains("書店") || page.name.contains("購物") || page.name.contains("百科")
					|| page.name.contains("買")|| page.name.contains("Taobao") || page.name.contains("比價")) {
				iterator.remove(); // 使用迭代器的 remove 方法刪除元素
			}
		}
	}
}