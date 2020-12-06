package com.team4.employeemood.Reports;

import com.team4.employeemood.MoodData;
import com.team4.employeemood.Project;
import com.team4.employeemood.ProjectData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HappiestProjectsReport {

    //create a map store the projectname and the previously calculated average project mood rating
    Map<String, Double> averageMoodRating = new HashMap<>();

    public void generateReport() {

        //calculate average mood ratings by project and store them in a temporary map
        Map<String, Double> tempMap = new HashMap<>();

        ReportUtil reportUtil = new ReportUtil();
        for (Project project : ProjectData.projectList) {
            Double averageRating = 0d;
            averageRating = reportUtil.getAverageMoodRatingForProject(project.getProjectName());
            tempMap.put(project.getProjectName(), averageRating);
        }

        //sort temporary map by average rating descending order and push data to final map
        averageMoodRating = tempMap.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public void displayMap() {
        System.out.println("\nDisplay Map key & values:");
        for (Map.Entry entry : averageMoodRating.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }


}