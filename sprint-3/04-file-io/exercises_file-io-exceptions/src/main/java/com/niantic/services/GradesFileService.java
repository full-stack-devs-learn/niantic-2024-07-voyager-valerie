package com.niantic.services;

import com.niantic.models.Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradesFileService implements GradesService
{

    @Override
    public List<String> getFileNames()
    {
        List<String> fileNames = new ArrayList<>();
        File directory = new File("files");
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        } else {
            System.out.println("Directory does not exist or is not accessible.");
        }
        return fileNames;
    }

    @Override
    public List<Assignment> getAssignments(String fileName) throws FileNotFoundException
    {
        List<Assignment> assignments = new ArrayList<>();

        File file = new File("files/" + fileName);

        try (Scanner reader = new Scanner(file)) {
            if (reader.hasNextLine()) {
                reader.nextLine(); // Skip header if present
            }

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] columns = line.split(",");

                if (columns.length >= 5) {
                    int assignmentNumber = Integer.parseInt(columns[0]);
                    String firstName = columns[1];
                    String lastName = columns[2];
                    String assignmentName = columns[3];
                    int score = Integer.parseInt(columns[4]);

                    Assignment assignment = new Assignment(assignmentNumber, firstName, lastName, assignmentName, score);
                    assignments.add(assignment);
                } else {
                    System.out.println("Unexpected line format: " + line);
                }
            }
        }

        return assignments;
    }

    @Override
    public List<Assignment> getAllAssignments(String[] fileNames) throws FileNotFoundException
    {
        List<Assignment> allAssignments = new ArrayList<>();

        return allAssignments;
    }
}
