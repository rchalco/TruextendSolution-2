/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruben.solution2.util;

import com.ruben.solution2.model.ClassRoom;
import com.ruben.solution2.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author home
 */
public class Calculator {

    public static List<Student> studentsInClasses(List<Student> StudentList, List<ClassRoom> ClassroomList) {
        List<Student> StudentFoundList = new ArrayList<Student>();
        Double distanceMax = 20.00;//28.28;//meters

        ClassroomList.forEach(x -> {
            StudentList.forEach(y -> {
                if (distance(x.getLatitude(), y.getLatitude(), x.getLongitude(), y.getLongitude()) <= distanceMax) {
                    StudentFoundList.add(y);
                }
            });
        });
        return StudentFoundList;
    }

    private static double distance(double lat1, double lat2, double lon1,
            double lon2) {

        final int R = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }

}
