package FileIO.src.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class App {
    public static void main(String[] args) throws IOException {
        // Absolute Path
        // Relative Path
        // Byte streams


        ///////////////////////////

        // System.out.println("hi");

        // FileInputStream in = null;
        // FileOutputStream out = null;

        // try {
        //     in = new FileInputStream("input.txt");
        //     out = new FileOutputStream("output.txt");
            
        //     int num;

        //     while((num = in.read()) != -1) {
        //         out.write(num);
        //     }
        // }
        // finally {
        //     if(in != null) {
        //         in.close();
        //     }
        //     if(out != null) {
        //         out.close();
        //     }
        // }

            ///////////////////////////////////

            // Buffered Reader


            try {
                BufferedReader reader = 
                    new BufferedReader(new InputStreamReader(System.in));

                System.out.println("What is your name? ");
                String name = reader.readLine();

                System.out.println("What's your job? ");
                String job = reader.readLine();

                System.out.format("%s, %s", name, job);
                reader.close();
            } catch(IOException ioe) {
                System.out.println("IO in bufferedReader in main");
                ioe.printStackTrace();
            }

    

    }
}