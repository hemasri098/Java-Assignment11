package com.company;
import java.io.*;
import java.util.HashMap;

public class Assignment11 {
    public static HashMap<Character, Integer> characterCount(BufferedReader reader) throws IOException {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String input = "";
        while((input = reader.readLine()) != null) {
            for (int i = 0; i < input.length(); i++) {
                if (!map.containsKey(input.charAt(i))) {
                    map.put(input.charAt(i), 1);
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
           // System.out.println(characterCount(reader));
            HashMap<Character, Integer> myMap = characterCount(reader);
            try{
                FileWriter fw = new FileWriter("/home/dhemasri/Desktop/assignment11.txt");
                String result = "";
                for(Character key : myMap.keySet()) {
                    result += key + " - " + myMap.get(key) + "\n";
                }
                fw.write(result);
                fw.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }
            System.out.println("Result is saved into the text file assignment11.txt");
        }
    }
    }


