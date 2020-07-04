import java.util.*;

public class WordLadder {
    /* Given two words: beginword and endword and a dictionary word list, find the length of the sortes transformation
     sequence from beginword to endword such that only one letter can be changed at a time and each transformed word
     must exist in the word list
     */
    public static void main(String args[]) {
        String beginWord = "hit", endWord = "cog";
        String arr[]={"m","mv"};
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(findMinLength(wordList, beginWord, endWord));
    }

    private static int findMinLength(List<String> wordList, String beginWord, String endWord) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                char curr[] = q.poll().toCharArray();
                for (int j = 0; j < curr.length; j++) {
                    char temp = curr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curr[j] = c;
                        String next = new String(curr);
                        if (set.contains(next)) {
                            if (next.equals(endWord))
                                return count + 1;
                            q.add(next);
                            set.remove(next);
                        }
                    }
                    curr[j] = temp;
                }
            }
            count++;
        }
        return 0;
    }
}
