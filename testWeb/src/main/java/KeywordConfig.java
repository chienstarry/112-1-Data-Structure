import java.util.ArrayList;

public class KeywordConfig {

	private static final ArrayList<Keyword> DEFAULT_KEYWORDS_ZH = new ArrayList<>();
    private static final ArrayList<Keyword> DEFAULT_KEYWORDS_EN = new ArrayList<>();

	static {
		// 關鍵字權重

		// 小說網
		DEFAULT_KEYWORDS_ZH.add(new Keyword("起点中文网", 500.0));
		DEFAULT_KEYWORDS_ZH.add(new Keyword("晋江文学城", 500.0));
		DEFAULT_KEYWORDS_ZH.add(new Keyword("红袖添香", 500.0));
		DEFAULT_KEYWORDS_ZH.add(new Keyword("品书网", 500.0));
		DEFAULT_KEYWORDS_ZH.add(new Keyword("潇湘书院", 500.0));
		DEFAULT_KEYWORDS_ZH.add(new Keyword("飞卢中文网", 500.0));
		DEFAULT_KEYWORDS_ZH.add(new Keyword("讀創故事", 500.0));

		// 其他
		DEFAULT_KEYWORDS_ZH.add(new Keyword("小說", 50.0));
		DEFAULT_KEYWORDS_ZH.add(new Keyword("小說網", 20.0));
		DEFAULT_KEYWORDS_ZH.add(new Keyword("作者", 30.0));
		DEFAULT_KEYWORDS_ZH.add(new Keyword("最新", 2.0));
		DEFAULT_KEYWORDS_ZH.add(new Keyword("介紹", 1.0));

		// 排除
		// DEFAULT_KEYWORDS.add(new Keyword("商品", -5000.0));
		// DEFAULT_KEYWORDS.add(new Keyword("博客來", -10000.0));
		DEFAULT_KEYWORDS_ZH.add(new Keyword("價格", -1000.0));

	
//英文版		
		DEFAULT_KEYWORDS_EN.add(new Keyword("novel", 50.0));
        DEFAULT_KEYWORDS_EN.add(new Keyword("author", 20.0));

	}

	public static ArrayList<Keyword> getKeywords(String userInput, double weight) {
        ArrayList<Keyword> keywords;
        if (isEnglish(userInput)) {
            keywords = new ArrayList<>(DEFAULT_KEYWORDS_EN);
        } else {
            keywords = new ArrayList<>(DEFAULT_KEYWORDS_ZH);
        }
        keywords.add(0, new Keyword(userInput, weight)); // 将用户输入添加到列表的开头
        return keywords;
    }
	
	private static boolean isEnglish(String text) {
        return text.matches("[A-Za-z ]+");
    }
}

