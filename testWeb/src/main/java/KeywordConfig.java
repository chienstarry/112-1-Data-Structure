import java.util.ArrayList;

public class KeywordConfig {

    private static final ArrayList<Keyword> DEFAULT_KEYWORDS = new ArrayList<>();

    static {
    	//關鍵字權重
    	
        DEFAULT_KEYWORDS.add(new Keyword("小說", 3.0));
        DEFAULT_KEYWORDS.add(new Keyword("作者", 4.0));
        DEFAULT_KEYWORDS.add(new Keyword("最新", 2.0));
        DEFAULT_KEYWORDS.add(new Keyword("介紹", 1.0));
        DEFAULT_KEYWORDS.add(new Keyword("博客來", -1000.0));
        DEFAULT_KEYWORDS.add(new Keyword("誠品", -1000.0));
        
       
    }
    public static ArrayList<Keyword> getKeywordsWithInput(String userInput, double weight) {
        ArrayList<Keyword> keywords = new ArrayList<>(DEFAULT_KEYWORDS);
        keywords.add(0, new Keyword(userInput, weight)); 
        return keywords;
    }
}
