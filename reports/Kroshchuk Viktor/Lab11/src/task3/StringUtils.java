package task3;

public class StringUtils {

    public static int levenshteinDistance(String s, String t){
        if(s == null && t.equals(" ") || s.equals(" ") && t == null){
            return -1;
        }
        else if(s == null && t == null){
            throw new NullPointerException();
        }
        else if(s.equals(" ") && t.equals(" ")){
            return 0;
        }
        else{
            String first = s.toLowerCase();
            String second = t.toLowerCase();
            int out = dist(first.toCharArray(), second.toCharArray());
            return out;
        }
    }

    public static int dist(char[] s1, char[] s2) {
        int[] prev = new int[s2.length + 1];
        for(int j = 0; j < s2.length + 1; j++) {
            prev[j] = j;
        }
        for(int i = 1; i < s1.length + 1; i++) {
            int[] curr = new int[s2.length + 1];
            curr[0] = i;
            for(int j = 1; j < s2.length + 1; j++) {
                int d1 = prev[j] + 1;
                int d2 = curr[j - 1] + 1;
                int d3 = prev[j - 1];
                if (s1[i - 1] != s2[j - 1]) {
                    d3 += 1;
                }
                curr[j] = Math.min(Math.min(d1, d2), d3);
            }
            prev = curr;
        }
        return prev[s2.length];
    }
}
