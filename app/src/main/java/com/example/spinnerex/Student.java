package com.example.spinnerex;

public class Student {
    private String first;
    private String last;
    private String phone;
    private String birth;

    public Student(String first, String last, String phone, String birth) {
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.birth = birth;
    }


    @Override
    public String toString() {
        return ("" + first + " " + last);
    }

    public String details(){
        return ("First name: " + first + "\nFamily name: " + last + "\nPhone number: " + phone + "\nBirth date: " + birth);
    }
}
