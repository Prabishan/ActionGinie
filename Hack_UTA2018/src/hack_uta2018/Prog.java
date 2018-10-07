/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack_uta2018;

import hack_uta2018.Grabber;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Prabishan
 */
public class Prog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
                Scanner input = new Scanner(System.in);
        

                
                Grabber grabber = new Grabber();
                String content = grabber.grab("http://diptindahal.000webhostapp.com/");

                String RegEx = "<div>\\s+<a>(.*?)</a>.*?Due:(.*?)</div>";
                Pattern pattern = Pattern.compile(RegEx);
                Matcher match = pattern.matcher(content);
                System.out.println(content.toString());

                FileWriter writer = new FileWriter("c:/users/prabishan/desktop/DueDates.txt");
                
                while (match.find()) {
                    writer.write("Assignment Name :" + match.group(1) + "\r\n");
                    writer.write("Due Dates :" + match.group(2) + "\r\n");
                    writer.write("==========================================\r\n");

                }

                writer.close();
        } catch (IOException ioe) {
            ioe.getMessage();

        }

    }
}
