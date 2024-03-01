/**  Program counts the amount of times a certain word appears in a text file and outputs the name of the word and its cardinality in 
text file
**/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Assignment13_CountWords {
    public static void main(String[] args) throws Exception {
        Scanner fileName = new Scanner(System.in);
        Scanner countFile = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName1 = fileName.nextLine();
        System.out.print("Enter the file name for the counted words: ");
        String countFile1 = countFile.nextLine();
        String[] subjects = {"Math" , "Science" , "Biology" , "English" , "History"};
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName1))){
            for (int i = 0; i<100; i++){
                writer.write(subjects[rand.nextInt(subjects.length)] + "\n");
            }
        }
        fileName.close();
        countFile.close();

        Map<String, Integer> subjectsCount = new HashMap<>();
        try (BufferedReader read = new BufferedReader(new java.io.FileReader(fileName1))){
            String line;
            while ((line = read.readLine()) != null){
              subjectsCount.put(line, subjectsCount.getOrDefault(line, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : subjectsCount.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(countFile1))){
            for (Map.Entry<String, Integer> entry : subjectsCount.entrySet()){
                writer.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
        }
    }
}
