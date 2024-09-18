package com.niantic.services;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AllStudentsService
{
    public void createAllStudentsReport()
    {
        File folder = new File("files/");
        File[] studentFiles = folder.listFiles((dir, name) -> name.endsWith(".csv"));
        int studentCount = (studentFiles != null) ? studentFiles.length : 0;

        Set<String> uniqueAssignments = new HashSet<>();
        List<Integer> allScores = new ArrayList<>();
        Map<Integer, String> scoretoStudentMap = new HashMap<>();

        for(File file : studentFiles)
        {
            try(BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
                String line;
                reader.readLine();

                String studentName = null;

                while((line = reader.readLine()) != null)
                {
                    String[] data = line.split(",");

                    if(studentName == null)
                    {
                        studentName = data[1] + " " + data[2];
                    }

                    String assignmentName = data[3];
                    uniqueAssignments.add(assignmentName);

                    int score = Integer.parseInt(data[4]);
                    allScores.add(score);
                    scoretoStudentMap.put(score, studentName);
                }
            }
            catch (IOException e)
            {
                System.out.println("Error reading file: " + file.getName());
            }
        }

        int totalAssignments = uniqueAssignments.size();
        int lowestScore = allScores.stream().mapToInt(Integer::intValue).min().orElse(0);
        double averageScore = allScores.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        int highestScore = allScores.stream().mapToInt(Integer::intValue).max().orElse(0);

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        File reportFile = new File("reports/" + date.format(formatter) + "_all_students.txt");

        try (PrintWriter out = new PrintWriter(reportFile)) {
            out.println("All Assignments");
            out.println("-".repeat(60));
            out.printf("Total Students:                                    %d%n", studentCount);
            out.printf("Total Assignments:                                 %d%n", totalAssignments);
            out.println("-".repeat(60));
            out.printf("Low Score:                                         %d%n", lowestScore);
            out.printf("Average Score:                                     %.2f%n", averageScore);
            out.printf("High Score:                                        %d%n", highestScore);
            out.println("-".repeat(60));
        } catch (IOException e) {
            System.out.println("Error writing report file: " + e.getMessage());
        }
    }

}
