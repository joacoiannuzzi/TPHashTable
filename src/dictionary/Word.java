package dictionary;

import hashTable.Hashable;

public class Word implements Hashable, Comparable<Word> {

    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public int hash(int M) {
        String some = Soundex.soundex(word);
        String[] s = some.split("");
        int h = (int) some.charAt(0);
        String j = "" + h + s[1] + s[2] + s[3];
        int f = Integer.parseInt(j);
        return f % M;
    }

    @Override
    public int compareTo(Word o) {
        return word.compareTo(o.getWord());
    }

    public String getWord() {
        return word;
    }
}
