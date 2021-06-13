package com.afaqy;

public class Main {

    public static void main(String[] args) {

        RunnableCustomExceptionDemo runnableDemo1 = new RunnableCustomExceptionDemo("sample1.txt");
        RunnableCustomExceptionDemo runnableDemo2 = new RunnableCustomExceptionDemo("sample2.txt");
        RunnableCustomExceptionDemo runnableDemo3 = new RunnableCustomExceptionDemo("sample3.txt");
        RunnableCustomExceptionDemo runnableDemo4 = new RunnableCustomExceptionDemo("sample4.txt");

        Thread t1 = new Thread(runnableDemo1, "Sample1");
        Thread t2 = new Thread(runnableDemo2, "Sample2");
        Thread t3 = new Thread(runnableDemo3, "Sample3");
        Thread t4 = new Thread(runnableDemo4, "Sample4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
