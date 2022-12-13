package problem3;

public final class Problem3 {

    public static void main(String[] args) {

        String case1 = "ggububgvfk";
        int max = lengthOfLongestSubstring(case1);
        System.out.println("max = " + max);
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) {
            return 0;
        }

        return lengthOfLongestSubstring(s, "", 1);
    }

    public static int lengthOfLongestSubstring(String s, String nonConsecutive, int maxNonconsecutive) {

        String sEval = s.substring(0,1);

        if(s.length()==1) {
            if(!nonConsecutive.contains(sEval)) {
                nonConsecutive = nonConsecutive + s.charAt(0);
                maxNonconsecutive = Math.max(nonConsecutive.length(), maxNonconsecutive);
            }

            return maxNonconsecutive;
        }
        else if(!nonConsecutive.contains(sEval)) {
            nonConsecutive = nonConsecutive + s.charAt(0);
            maxNonconsecutive = Math.max(nonConsecutive.length(), maxNonconsecutive);
            return lengthOfLongestSubstring(s.substring(1), nonConsecutive, maxNonconsecutive);
        }
        else {
            if(nonConsecutive.startsWith(sEval)) {
                return lengthOfLongestSubstring(s, nonConsecutive.substring(1), maxNonconsecutive);
            }
            else if (nonConsecutive.endsWith(sEval)){
                return lengthOfLongestSubstring(s, nonConsecutive.substring(1), maxNonconsecutive);
            }
            else {
                return lengthOfLongestSubstring(s.substring(s.indexOf(nonConsecutive)+1),
                        nonConsecutive.substring(nonConsecutive.indexOf(s.charAt(0))),
                        maxNonconsecutive);
            }
        }
    }
}
