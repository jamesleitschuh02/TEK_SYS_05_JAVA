package streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        // Absolute Path
        // Relative Path

        // Byte streams

        // FileInputStream in = null;
        // FileOutputStream out = null;

        // FileReader in = null;
        // FileWriter out = null;

        // try {
        //     // in = new FileInputStream("input.txt");
        //     // out = new FileOutputStream("output.txt");

        //     in = new FileReader("input.txt");
        //     out = new FileWriter("output.txt");
            
        //     int num;

        //     while((num = in.read()) != -1) {
        //         out.write(num);
        //     }
        // }
        // finally {
        //     if(in != null) {
        //         in.close();
        //         System.out.println("ran in");
        //     }
        //     if(out != null) {
        //         out.close();
        //         System.out.println("ran out");
        //     }
        // }




//////////////////////////////////////////////////////////////////////////////////////




        // InputStreamReader streamIn = null;

        // try {
        //     streamIn = new InputStreamReader(System.in);
        //     System.out.println("Enter Q to quit");

        //     char Q;
        //     do {
        //         Q = (char) streamIn.read();
        //         System.out.println(Q);
        //     }while(Q != 'Q');
        // }finally {
        //     if(streamIn != null) {
        //         streamIn.close();
        //     }
        // }









        ///////////////////////////////////////////////////////////////////////////////



    


        // character streams
        // standard streams
        // reading and writing files








        String path = "newfile.csv";
        try {
        File file = new File(path);
        Scanner input = new Scanner(file);
        // where data will be stored
        ArrayList<Course> data = new ArrayList<>();

        while (input.hasNextLine()) {
            String[] line = input.nextLine().split(",");
            data.add(new Course(line[0], line[1], line[2]));
        }

        for (Course c : data) {
            System.out.format("%-15s | %-35s | %-25s\n",
                c.getCode(), c.getName(), c.getInstructor());

        }

        // String inputLine = input.nextLine();
        }
        catch(FileNotFoundException e) {
            System.out.println("No file here");
            e.printStackTrace();
        }

        // System.out.println(file.isDirectory());

        // // return array with files
        // File [] FileWithPath = file.listFiles();
    }
}