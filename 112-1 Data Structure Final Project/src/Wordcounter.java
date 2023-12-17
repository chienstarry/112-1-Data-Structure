import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private String urlStr;
    private String content;

    public WordCounter(String urlStr) {
        this.urlStr = urlStr;
    }

    private String fetchContent() throws IOException {
        URL url = new URL(this.urlStr);
        URLConnection conn = url.openConnection();
        InputStream in = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        StringBuilder retVal = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            retVal.append(line).append("\n");
        }

        br.close();
        in.close();

        return retVal.toString();
    }

    public int countKeyword(String keyword) throws IOException {
        if (content == null) {
            content = fetchContent().toUpperCase();
        }

        keyword = keyword.toUpperCase();

        int count = 0;
        int index = content.indexOf(keyword);
        while (index != -1) {
            count++;
            index = content.indexOf(keyword, index + keyword.length());
        }

        return count;
    }
}

// http://soslab.nccu.edu.tw/Welcome.html