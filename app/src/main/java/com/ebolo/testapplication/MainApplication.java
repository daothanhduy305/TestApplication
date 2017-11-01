package com.ebolo.testapplication;

import android.app.Application;

import com.ebolo.testapplication.data.entities.Student;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class MainApplication extends Application {
    public static List<Student> studentList;

    @Override
    public void onCreate() {
        super.onCreate();
        Paper.init(this);

        // Spawn student list
        studentList = new ArrayList<>(100);
        for (int i = 0; i <  100 ; i++) {
            studentList.add(new Student(
                    "name_" + i,
                    "school_" + i,
                    i
            ));
        }
    }
}
