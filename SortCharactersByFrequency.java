import java.util.*;

public class SortCharactersByFrequency {
    //problem link: https://leetcode.com/problems/sort-characters-by-frequency/description/

    static class UsingHashmap {
        static String frequencySort(String s) {
            Map<Character, Integer> charCount = new HashMap<>();
            for (char c : s.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }

            List<Character> sortedChars = new ArrayList<>(charCount.keySet());
            Collections.sort(sortedChars, (a, b) -> charCount.get(b) - charCount.get(a));
            StringBuilder result = new StringBuilder();
            for (char c : sortedChars) {
                result.append(String.valueOf(c).repeat(charCount.get(c)));
            }

            return result.toString();
        }
    }
    static class WithoutUsingMap {
            public static String frequencySort(String s) {
                char[] str=s.toCharArray();
                int[] freq=new int[128];
                // for(char ch:s) freq[ch]++;
                for (char c : str) freq[c]++;

                for(int i=0;i<str.length;){
                    char cmax=',';
                    for(int j=0;j<128;j++){
                        if(freq[j]>freq[cmax]) cmax=(char)j;
                    }
                    while(freq[cmax]!=0){
                        str[i++]=cmax;
                        freq[cmax]--;
                    }
                }
                return new String(str);
            }
        }
    public static void main(String[] args) {
        System.out.println(UsingHashmap.frequencySort("tree"));
        System.out.println(WithoutUsingMap.frequencySort("tree"));
    }
}
