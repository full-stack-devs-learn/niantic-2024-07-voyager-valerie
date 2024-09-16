package com.niantic.services;

import com.niantic.models.Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface GradesService
{
    List<String> getFileNames();

    List<Assignment> getAssignments(String fileName) throws FileNotFoundException;

    List<Assignment> getAllAssignments(String[] fileNames) throws FileNotFoundException;
}
