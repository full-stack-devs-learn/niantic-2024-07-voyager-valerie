package com.niantic.services;

import com.niantic.models.Student;
import com.niantic.models.StudentStatistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class StudentService
{
    public void createStudentSummaryReport(Student student)
    {
        File reportsDir = new File("reports");

        if(!reportsDir.exists())
        {
            reportsDir.mkdir();
        }

        String reportName = createReportName(student.getName());
        File reportFile = new File(reportsDir, reportName);

        try(PrintWriter out = new PrintWriter(reportFile))
        {
            StudentStatistics statistics = student.getStatistics();

            out.println(student.getName());
            out.println("-".repeat(40));
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
}
