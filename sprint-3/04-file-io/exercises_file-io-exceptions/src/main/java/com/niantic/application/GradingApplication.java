package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.ui.UserInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();
    private List<String> fileNames = new ArrayList<>();
    private List<Integer> studentScores = new ArrayList<>();
    private List<Assignment> assignments;

    public void run()
    {
        while(true)
        {
            int choice = UserInput.homeScreenSelection();
            switch(choice)
            {
                case 1:
                    displayAllFiles();
                    break;
                case 2:
                    displayFileScores();
                    break;
                case 3:
                    displayStudentAverages();
                    break;
                case 4:
                    displayAllStudentStatistics();
                    break;
                case 5:
                    displayAssignmentStatistics();
                    break;
                case 0:
                    UserInput.displayMessage("Goodbye");
                    System.exit(0);
                default:
                    UserInput.displayMessage("Please make a valid selection");
            }
        }
    }

    private void displayAllFiles() {
        fileNames = gradesService.getFileNames();
        int index = 0;
        for (String fileName : fileNames) {
            System.out.println(index + ": " + fileName);
            index++;
        }
    }

    private void displayFileScores()
    {
        displayAllFiles();
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Above are the available student files. Which student file would you like to access? (Enter the index)");

        int studentNumber;
        while (true)
        {
            try
            {
                studentNumber = Integer.parseInt(scanner.nextLine());
                if(studentNumber >= 0 && studentNumber < fileNames.size())
                    {break;}        // valid, so move on
                else
                {
                    System.out.println("Invalid index. Please enter a number associated with the list below.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }

        }

        String selectedFileName = fileNames.get(studentNumber);
        try {
            assignments = gradesService.getAssignments(selectedFileName);
            for (Assignment assignment : assignments) {
                System.out.printf("Assignment Number: %d, Student Name: %s %s, Assignment Name: %s, Score: %d%n",
                        assignment.getNumber(), assignment.getFirstName(), assignment.getLastName(),
                        assignment.getAssignmentName(), assignment.getScore());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + selectedFileName);
        }
    }

    private void displayStudentAverages()
    {
        displayAllFiles();
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Above are the available student files. Which student file would you like to access? (Enter the index)");

        int studentNumber;
        while (true)
        {
            try
            {
                studentNumber = Integer.parseInt(scanner.nextLine());
                if(studentNumber >= 0 && studentNumber < fileNames.size())
                    {break;}        // valid, so move on
                else
                {
                    System.out.println("Invalid index. Please enter a number associated with the list below.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }

        }

        String selectedFileName = fileNames.get(studentNumber);
        File file = new File("files/" + selectedFileName);

        studentScores.clear();
        String studentName = null;

        try (Scanner reader = new Scanner(file))
        {
            if(reader.hasNextLine())
            {
                reader.nextLine();      // skips header if it exists
            }

            while(reader.hasNextLine())
            {
                String line = reader.nextLine();
                var columns = line.split(",");

                int assignmentNumber = Integer.parseInt(columns[0]);
                String firstName = columns[1];
                String lastName = columns[2];
                String assignmentName = columns[3];
                int score = Integer.parseInt(columns[4]);

                studentScores.add(score);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + selectedFileName);
        }

        if(studentScores.isEmpty())
        {
            System.out.println("No scores available. Please load or select a file first.");
            return;
        }

        OptionalInt lowestScore = studentScores.stream()
                .mapToInt(Integer::intValue)
                .min();

        double averageScore = studentScores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        OptionalInt highestScore = studentScores.stream()
                .mapToInt(Integer::intValue)
                .max();

        System.out.printf("Lowest Score: %d%n", lowestScore.orElse(0));
        System.out.printf("Average Score: %.2f%n", averageScore);
        System.out.printf("Highest Score: %d%n", highestScore.orElse(0));

    }

    private void displayAllStudentStatistics()
    {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for all scores (low score, high score, average score, number of students, number of assignments)
    }

    private void displayAssignmentStatistics()
    {
        // todo: 5 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for each assignment (assignment name, low score, high score, average score)
        // this one could take some time
    }

    private String parseStudentName(String fileName)
    {
        return fileName.replace(".csv", "")
                        .replace("_", " ")
                        .substring(10);
    }
}
