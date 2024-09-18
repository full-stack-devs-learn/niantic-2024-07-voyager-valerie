package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.models.Student;
import com.niantic.models.StudentStatistics;
import com.niantic.services.AllStudentsService;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.services.StudentService;
import com.niantic.ui.UserInput;

import java.io.*;
import java.util.*;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();
    private List<String> fileNames = new ArrayList<>();
    private List<Integer> studentScores = new ArrayList<>();
    private List<Assignment> assignments;
    private StudentService  studentService = new StudentService();
    private AllStudentsService allStudentsService = new AllStudentsService();

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
                case 7:         // didn't do the challenge problems, so no #5 or #6
                    createStudentSummaryReport();
                    break;
                case 8:
                    createAllStudentsReport();
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

            System.out.printf("%-15s %-30s %-15s%n",
                    "Assignment", "Assignment Name", "Score");
            System.out.println("-".repeat(57));

            for (Assignment assignment : assignments) {
                System.out.printf("%-15s %-30s %-15s%n",
                        assignment.getNumber(),
                        assignment.getAssignmentName(),
                        assignment.getScore());
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
                System.out.println("Invalid input. Please enter a valid student number.");
            }
        }

        String selectedFileName = fileNames.get(studentNumber);
        File file = new File("files/" + selectedFileName);

        studentScores.clear();

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

    private void createStudentSummaryReport()
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
                System.out.println("Invalid input. Please enter a valid student number.");
            }
        }

        String selectedFileName = fileNames.get(studentNumber);
        File file = new File("files/" + selectedFileName);

        Student selectedStudent = readStudentDataFromFile(file);

        if (selectedStudent != null)
        {
            studentService.createStudentSummaryReport(selectedStudent);
        }
        else
        {
            System.out.println("Error: Could not find the student data.");
        }

    }

    private Student readStudentDataFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            List<Integer> scores = new ArrayList<>();
            String firstName = null;
            String lastName = null;

            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    if (firstName == null && lastName == null) {
                        firstName = data[1];
                        lastName = data[2];
                    }

                    try {
                        int score = Integer.parseInt(data[4]);
                        scores.add(score);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid score format: " + data[4]);
                    }
                }
            }

            String fullName = firstName + " " + lastName;

            StudentStatistics statistics = new StudentStatistics(scores);
            Student student = new Student(fullName, statistics);

            return student;

        } catch (IOException e) {
            System.out.println("Error reading student file: " + e.getMessage());
            return null;
        }
    }

    private void createAllStudentsReport()
    {
        allStudentsService.createAllStudentsReport();

        System.out.println("All students report has been generated successfully!");
    }
}
