package com.afaqy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class RunnableCustomExceptionDemo implements Runnable{


    private String fileName;
    public RunnableCustomExceptionDemo(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {

        try{
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            File file = new File(this.getClass().getClassLoader().getResource(fileName).getFile());
            int ch = inputStream.read();
//            System.out.println("\nFile name\t" + fileName + "\tfile length\t" + file.length() + "\n");
//            System.out.println("Thread.activeCount():   " + Thread.activeCount() + "    Thread.currentThread().getName()    " + Thread.currentThread().getName() + "\n");
//            System.out.println(file.length() == 0 ?  ("\nFile " + Thread.currentThread().getName() + " is empty\n") : ("\nFile " + Thread.currentThread().getName() + " is not empty\n"));
            if (file.length() == 0) {
                Thread.currentThread().checkAccess();
//                System.err.println("Thread.currentThread().checkAccess()    " + Thread.currentThread().getName());
                throw new EmptyFileException(Thread.currentThread().getName(), ErrorCode.EMPTY_FILE);
            }
//            System.out.println("Thread.activeCount():   " + Thread.activeCount() + "    Thread.currentThread().getName()    " + Thread.currentThread().getName() + "\n");
//            System.out.println("\nch\t" + ch + "\n");
            while (ch != -1){
                System.out.println((char)ch);
                ch = inputStream.read();
                if(file.length() > 5000){
                    Thread.currentThread().setPriority(1);
                }
            }
            inputStream.close();
            if (ch == -1){
                System.err.println(" File " + Thread.currentThread().getName() + " Finish");
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EmptyFileException e){
            e.printStackTrace();
            System.err.println("ERROR_CODE  " + e.getErrorCode());
        }

    }
}
