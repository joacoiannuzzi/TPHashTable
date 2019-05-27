package dictionary;

import hashTable.HashTable;

import java.io.*;
import java.util.LinkedList;

public class Program {
    
    private HashTable<Word> dictionary = new HashTable<>(1000);

    public void readFile(String path) {
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    Word w = new Word(word);
                    if (!dictionary.exists(w))
                        dictionary.insert(w);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processFile(String path) {
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    Word w = new Word(word);
                    if (!dictionary.exists(w)) {
                        System.out.println(word);
                        LinkedList<Word> list = dictionary.getList(w);
                        if (!list.isEmpty()) {
                            System.out.println("Suggestions:");
                            //list.goTo(0);
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println("\t" + list.get(i).getWord());
                            }
                            System.out.println();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashTable<Word> getDictionary() {
        return dictionary;
    }
}
