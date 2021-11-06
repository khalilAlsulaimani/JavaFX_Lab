/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author alsul
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class ExerciseB {


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("enter path of file you want to count");
        File srcFile = new File(scan.nextLine());

        int counter = 0;
        FileInputStream fileStream = new FileInputStream(srcFile);
        byte[] byteArray = new byte[(int) srcFile.length()];
        fileStream.read(byteArray);
        String str = new String(byteArray);
        String[] data = str.split(" ");

        for (int i = 0; i < data.length; i++) {
            counter++;
        }


        FileWriter fileWriter = new FileWriter("C:\\Users\\alsul\\OneDrive\\Desktop\\WordStatistic.txt");
        fileWriter.write("the number of words in the src file is " + counter);
        fileWriter.close();


    }
}
