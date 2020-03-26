package com.company.JavaAssignment11;
import java.io.*;
import java.util.HashMap;
import java.util.logging.Logger;

public class Assignment11 {
    public static Logger LOGGER = Logger.getAnonymousLogger();
    //storing character counts in a file
    public static HashMap<Character, Integer> characterCount(BufferedReader reader) throws IOException {
        HashMap<Character, Integer> charactercount = new HashMap<Character, Integer>();
        String input = "";
        while((input = reader.readLine()) != null) {
            //making count of each character
            for (int i = 0; i < input.length(); i++) {
                if (!charactercount.containsKey(input.charAt(i))) {
                    charactercount.put(input.charAt(i), 1);
                } else {
                    charactercount.put(input.charAt(i), charactercount.get(input.charAt(i)) + 1);
                }
            }
        }
        return charactercount;
    }
    public static void main(String[] args) throws IOException {
        //reading command line argument
        try {
            if (args.length > 0) {
                File file = new File(args[0]);
                FileInputStream fileStream = new FileInputStream(file);
                InputStreamReader input = new InputStreamReader(fileStream);
                BufferedReader reader = new BufferedReader(input);
                HashMap<Character, Integer> charactercount = characterCount(reader);
                try {
                    //text file to store output
                    FileWriter fw = new FileWriter("/home/dhemasri/Desktop/assignment11.txt");
                    String result = "";
                    for (Character key : charactercount.keySet()) {
                        result += key + " - " + charactercount.get(key) + "\n";
                    }
                    //writing output into text file
                    fw.write(result);
                    fw.close();
                } catch (Exception e) {
                    LOGGER.info("Exception: " + e);
                }
                LOGGER.info("Result is saved into the text file assignment11.txt");
            }
        }
        catch (Exception e) {
            LOGGER.info("Exception: " + e);
        }
    }
    }


