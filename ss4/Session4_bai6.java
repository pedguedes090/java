package Session4;
import java.util.regex.Pattern;
public class Session4_bai6 {
    static String censorWithReplaceAll(String text, String[] blacklist, String mask) {
        if (text == null) return "";
        String[] escaped = new String[blacklist.length];
        for (int i = 0; i < blacklist.length; i++) {
            escaped[i] = Pattern.quote(blacklist[i].trim());
        }
        String regex = "(?i)\\b(" + String.join("|", escaped) + ")\\b";
        return text.replaceAll(regex, mask);
    }


    static String shortenWithoutBreakingWord(String text, int maxLen) {
        if (text == null) return "";
        if (text.length() <= maxLen) return text;
        int cut = maxLen;
        while (cut > 0 && !Character.isWhitespace(text.charAt(cut - 1))) {
            cut--;
        }
        if (cut == 0) cut = maxLen;
        StringBuilder sb = new StringBuilder();
        sb.append(text.substring(0, cut).trim());
        sb.append("...");
        return sb.toString();
    }


    public static void main(String[] args) {
        String review = "Cuon sach nay rat te, noi dung that la ngu ngoc va khong dang doc. ";
        String[] blacklist = {"te", "ngu ngoc", "khong dang doc", "ngu"};
        String filtered = censorWithReplaceAll(review, blacklist, "***");
        filtered = shortenWithoutBreakingWord(filtered, 200);
        System.out.println(filtered);
    }
}
