package homeworks.hw1;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/** Write a program that reads a String from the keyboard. The program should then
 *  construct a URL for http://www.X.com/, replacing X with the String read in, and
 *  print the first five lines of the Web page at that URL in REVERSE ORDER; i.e.,
 *  the fifth, fourth, third, second, and first lines.
 *
 *  We’ve already created a skeleton for you in the file OpenCommercial.java; you
 *  just need to fill it in. Use the println method to print each of the five
 *  lines, so that there’s a carriage return at the end of each line.
 *
 *  To receive credit for this problem, you must follow these directions exactly:
 *  1) Your solution must be in a file called OpenCommercial.java .
 *  2) Do not edit any of the lines before the line that says
 *  3) Your program must print only five lines from the given home page,
 *
 *  and must print them in reverse order. Do not add any extraneous
 *  println statements. Do not modify the lines before printing them.
 *  The program skeleton we’ve given you prints a prompt before reading
 *  the String; don’t change this prompt. Your program must produce
 *  EXACTLY the same output as our solution, because we will be using an
 *  automatic grading program dumber than a microwave oven.
 *  Before you submit your solution, be sure to try compiling your program ON THE
 *  LAB MACHINES with "javac -g OpenCommercial.java", and be sure to try running
 *  your program ON THE LAB MACHINES using "java OpenCommercial". If you are
 *  working from home, be aware that there might be slight differences between your
 *  Java installation and ours, so you should always test your code on the lab
 *  machines just before you submit it. No partial credit will be given for
 *  programs that don’t produce a portion of a Web page.
 */

class OpenCommercial {

    /** Prompts the user for the name X of a company (a single string), opens
     *  the Web site corresponding to www.X.com, and prints the first five lines
     *  of the Web page in reverse order.
     *  @param arg is not used.
     *  @exception Exception thrown if there are any problems parsing the
     *             user's input or opening the connection.
     */
    public static void main(String[] arg) throws Exception {

        BufferedReader keyboard;
        String inputLine;

        keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter the name of a company (without spaces): ");
        System.out.flush();        /* Make sure the line is printed immediately. */
        inputLine = keyboard.readLine();

        URL url =  new URL("https://" + inputLine + ".com/");

        BufferedReader webpage = new BufferedReader(new InputStreamReader(url.openStream()));

        List<String> lines = new ArrayList<>();
        int nLines = 5;

        while (nLines > 0) {
            lines.add(webpage.readLine());
            nLines--;
        }

        for (int i = lines.size() - 1; i >= 0; i--) {
            System.out.println(lines.get(i));
        }

    }
}
