import java.util.ArrayList;

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
}