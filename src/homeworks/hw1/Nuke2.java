package homeworks.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sergey on 2017-05-14.
 */
public class Nuke2 {
    public static void main(String[] args) throws IOException {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please input the string: ");
        String inputLine = keyboard.readLine();

        System.out.println(inputLine.substring(0, 1) + inputLine.substring(2, inputLine.length()));

    }
}
