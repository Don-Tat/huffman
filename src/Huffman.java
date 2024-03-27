import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Huffman {

    public static void main(String[] args) {
        char[] charArray = readFile("/home/don/repos/huffman/src/data/input.txt" );
        // Count the frequency of each character
        int[] freq = countFrequency(charArray);
        // Create a map to store the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                frequencyMap.put((char) i, freq[i]);
            }
        }
        //print the frequency map
        System.out.println("Frequency Map: ");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static char[] readFile(String fileName) {
        try {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            StringBuilder sb = new StringBuilder();
            while ((st = br.readLine()) != null) {
                sb.append(st);
            }
            return sb.toString().toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int[] countFrequency(char[] charArray) {
        int[] freq = new int[256];
        for (char c : charArray) {
            freq[c]++;
        }
        return freq;
    }

}
