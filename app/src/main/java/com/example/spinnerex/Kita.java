package com.example.spinnerex;

import java.util.Arrays;

public class Kita {
    private String[] talmidim;
    private Student[] talmidimobj;
    private int count;
    public Kita ()
    {
        this.talmidim = new String[10];
        this.talmidimobj = new Student[10];

        this.count = 0;

    }

    public void addStudent(Student stu)
    {
        if (count!=10)
        {
            talmidim[count] = stu.toString();
            talmidimobj[count] = stu;

            count = count+1;
        }

    }

    public String[] getTalmidim() {
        return talmidim;
    }

    public String getTalmidobj(int pos) {
        return talmidimobj[pos].details();
    }
}
