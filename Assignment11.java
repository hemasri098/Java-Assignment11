package com.company;
import java.io.*;
import java.util.HashMap;

public class Assignment11 {
    public static HashMap<Character,Integer> characterCount(BufferedReader reader) throws IOException {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while(reader.readLine() != null) {
            String input = reader.readLine();
            for (int i = 0; i < input.length(); i++) {
                if (!map.containsKey(input.charAt(i))) {
                    map.put(input.charAt(i), 0);
                } else {
                    map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
                }
            }
        }
        return map;
    }
    public static void main(String[] args) throws IOException {
        if(args.length > 0) {
            File file = new File(args[0]);
            FileInputStream fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream);
            BufferedReader reader = new BufferedReader(input);
            System.out.println(characterCount(reader));
        }
    }

}
