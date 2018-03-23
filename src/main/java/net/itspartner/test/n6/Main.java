package net.itspartner.test.n6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Task: Process file resources/n6/source in a special way and write result to the new file.
 * Source file contains data in following format:
 * username,password,email
 * <p>
 * You need to:
 * 1) remove duplicates by username
 * 2) make email lowercase
 * 3) remove records where password doesn't meet following conditions:
 * 3.1) password length must be at least 8 symbols
 * 3.2) password must contain at least one special character (#, @, -)
 * 3.3) password must contain exactly one uppercase character
 * <p>
 * All the rest records should be saved in new file in the same format.
 */
public class Main {

    public static void main(String[] args) {
        String folder = "C:\\Users\\gotov\\java-test-for-interview\\src\\main\\resources\\n6\\";
        try {
            List<DataFromFile> list = Files.lines(Paths.get(folder + "source"))
                    .map(s -> s.split(","))
                    .map(a -> new DataFromFile(a[0], a[1], a[2].toLowerCase())) //Task 2
                    .filter(dataFromFile ->
                            dataFromFile.getPassword().length() >= 8 // Task 3.1
                            && dataFromFile.getPassword()
                                    .matches("[A-Z]+[A-Za-z0-9#@-]*") //Tasks 3.2-3.3
                    )
                    .sorted(Comparator.comparing(DataFromFile::getUsername))
                    .collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
                                    new TreeSet<>(Comparator
                                            .comparing(DataFromFile::getUsername))), //Task 1
                            ArrayList::new))
                    ;
            PrintWriter pw = new PrintWriter(new FileWriter(folder + "result.txt"));
            for (DataFromFile data : list) {
                pw.println(data.toString());
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
