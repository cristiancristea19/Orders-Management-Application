package Presentation;

import Model.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterClass {
    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private static int index = 0;
    public void createFile()
    {
        file = new File("Order" + index + ".txt");
        index++;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileWriter = new FileWriter(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    public void writeToFile(Order order)
    {
        createFile();

        try{
            bufferedWriter.write(order.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
