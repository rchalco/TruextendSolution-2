/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruben.solution2;

import com.ruben.solution2.model.ClassRoom;
import com.ruben.solution2.model.Student;
import com.ruben.solution2.util.Calculator;
import com.ruben.solution2.util.Paser;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author home
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("beign test1...");
        ClassRoom engineering_classroom = Paser.parserObject(ClassRoom.class, "{ 'name': 'Principles of computational geo-location analysis', 'latitude': 34.069140, 'longitude': -118.442689 }");
        ClassRoom geology_classroom = Paser.parserObject(ClassRoom.class, "{ 'name': 'Sedimentary Petrology', 'latitude': 34.069585, 'longitude': -118.441878 }");
        ClassRoom psychology_classroom = Paser.parserObject(ClassRoom.class, "{ 'name': 'Introductory Psychobiology', 'latitude': 34.069742, 'longitude': -118.441312 }");
        ClassRoom music_classroom = Paser.parserObject(ClassRoom.class, "{ 'name': 'Art of Listening', 'latitude': 34.070223, 'longitude': -118.440193 }");
        ClassRoom humanities_classroom = Paser.parserObject(ClassRoom.class, "{ 'name': 'Art Hitory', 'latitude': 34.071528, 'longitude': -118.441211 }");
        List<ClassRoom> classroom_list = new ArrayList<ClassRoom>();
        classroom_list.add(humanities_classroom);
        classroom_list.add(music_classroom);
        classroom_list.add(psychology_classroom);
        classroom_list.add(geology_classroom);
        classroom_list.add(engineering_classroom);

        Student john_student = Paser.parserObject(Student.class, "{ 'name': 'John Wilson', 'latitude': 34.069149, 'longitude': -118.442639 }");
        Student jane_student = Paser.parserObject(Student.class, "{ 'name': 'Jane Graham', 'latitude': 34.069601, 'longitude': -118.441862 }");
        Student pam_student = Paser.parserObject(Student.class, "{ 'name': 'Pam Bam', 'latitude': 34.071513, 'longitude': -118.441181 }");
        List<Student> student_list = new ArrayList<>();
        student_list.add(pam_student);
        student_list.add(jane_student);
        student_list.add(john_student);

        List<Student> StudentFound = Calculator.studentsInClasses(student_list, classroom_list);
        StudentFound.forEach(x -> {
            try {
                System.out.println(Paser.parserJsonString(Student.class, x));
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        System.out.println("beign test2...");
        john_student.setLatitude(34.069849);john_student.setLongitude(-118.443539);
        jane_student .setLatitude(34.069901);john_student.setLongitude(-118.441562);
        pam_student.setLatitude(34.071523);pam_student.setLongitude(-118.441171);

        List<Student> student_list2 = new ArrayList<>();
        student_list2.add(pam_student);
        student_list2.add(jane_student);
        student_list2.add(john_student);
        StudentFound = Calculator.studentsInClasses(student_list, classroom_list);
        StudentFound.forEach(x -> {
            try {
                System.out.println(Paser.parserJsonString(Student.class, x));
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
}
