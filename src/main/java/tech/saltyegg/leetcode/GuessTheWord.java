package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessTheWord {

    interface Master {
        int guess(String word);
    }

    public void findSecretWord(String[] wordlist, Master master) {
        if (wordlist == null || wordlist.length == 0)
            return;

        int index = new Random().nextInt(wordlist.length);
        String str = wordlist[index];
        int match = master.guess(str);

        if (match == 6)
            return;

        List<String> list = new ArrayList<>();
        for (String s : wordlist) {
            if (s.equals(str))
                continue;
            if (countMatch(s, str) == match)
                list.add(s);
        }

        findSecretWord(list.toArray(new String[0]), master);
    }

    private int countMatch(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i))
                count++;
        }
        return count;
    }
}
