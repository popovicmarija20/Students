package com.example.students.bootstrap;

import com.example.students.domain.Grade;
import com.example.students.domain.Student;
import com.example.students.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public DataLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\Marija\\REDIS\\student-mat.csv"));
        scanner.nextLine();

        List<Student> studentList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            Student student = new Student();
            student.setSex(line[0]);
            student.setAge(Long.valueOf(line[1]));
            student.setAddress(line[2]);
            student.setMotherJob(line[3]);
            student.setFatherJob(line[4]);
            student.setStudyTime(Long.valueOf(line[5]));
            student.setFailures(Long.valueOf(line[6]));
            student.setInternet(line[7]);
            student.setRomantic(line[8]);
            student.setFreeTime(Long.valueOf(line[9]));
            student.setGoOut(Long.valueOf(line[10]));
            student.setDailyConsumptionOfAlcohol(Long.valueOf(line[11]));
            student.setWeekendConsumptionOfAlcohol(Long.valueOf(line[12]));
            student.setHealth(Long.valueOf(line[13]));
            student.setAbsences(Long.valueOf(line[14]));

            Grade g1 = new Grade();
            g1.setMark(Long.valueOf(line[15]));
            student.addGrade(g1);

            Grade g2 = new Grade();
            g2.setMark(Long.valueOf(line[16]));
            student.addGrade(g2);

            Grade g3 = new Grade();
            g3.setMark(Long.valueOf(line[17]));
            student.addGrade(g3);

            studentList.add(student);
        }
        studentRepository.saveAll(studentList);
    }
}
