package com.niantic.services;

import com.niantic.models.Student;
import com.niantic.models.StudentStatistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService
{
    public Student studentDetails(File file)
    {
        List<Integer> scores = new ArrayList<>();
        String studentName = extractStudentName(file.getName());

        try (Scanner reader = new Scanner(file))
        {
            if(reader.hasNextLine())
            {
                reader.nextLine();
            }

            while(reader.hasNextLine())
            {
                String line = reader.nextLine();
                String[] columns = line.split(",");

                int score = Integer.parseInt(columns[4]);
                scores.add(score);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + file.getName(), e);
        }

        StudentStatistics statistics = new StudentStatistics(scores);
        return new Student(studentName, statistics);
    }

    public void createStudentSummaryReport(Student student)
    {
        File reportsDir = new File("reports");

        if(!reportsDir.exists())
        {
            reportsDir.mkdir();
        }

        String reportName = createReportName(student.getName());
        File reportFile = new File(reportsDir + reportName);

        try(PrintWriter out = new PrintWriter(reportFile))
        {
            StudentStatistics statistics = new StudentStatistics(student.getStatistics().getScores());

            out.println(student.getName());
            out.println("-".repeat(30));
            out.printf("Low Score:                    %.2f\n", statistics.getLowScore());
            out.printf("Average Score:                %.2f\n", statistics.getAverageScore());
            out.printf("High Score:                   %.2f\n", statistics.getHighScore());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Unable to create report file: " + reportFile.getAbsolutePath(), e);
        }
    }

    private String createReportName(String studentName)
    {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return today.format(formatter) + "_" + studentName.replace(" ", "_") + ".txt";
    }

    private String extractStudentName(String fileName)
    {
        String fileSection = fileName.replace(".csv", "");
        String[] parts = fileSection.split("_");

        // assuming format is always "student_ID_first_last"
        return parts[2] + " " + parts[3];
    }
}
