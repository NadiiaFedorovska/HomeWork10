import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountWords {
    private static final String FILE_PATH = "D:\\My_folder\\GoIT\\modul10\\resource\\words.txt";

    public static void main(String[] args) {
        Map<String, Integer> wordCount = new TreeMap<>();
        List<String> list = new ArrayList<String>();
        int count = 0;
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            throw new RuntimeException("File with name " + file.getName() + " is not exist!");
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                //  System.out.println(line);

                String[] words = line.split("\\s+");

                for (int i = 0; i < words.length; i++) {
                    list.add(words[i]);
                }
            }
            for (String element : list) {
                if (!wordCount.containsKey(element)) {
                    wordCount.put(element, 1);
                } else {
                    count = wordCount.get(element);
                    wordCount.replace(element, count + 1);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(list);
        //System.out.println(wordCount);

        Map<String, Integer> sortedMap = new TreeMap<>(new MyComparator(wordCount));
        sortedMap.putAll(wordCount);

        System.out.println(sortedMap);
    }
}