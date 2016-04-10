package javaio;

import org.junit.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mark on 2016/3/16.
 */
public class ReaderAndWriter {
    @Test
    public void readerAndWriter(){
        try (BufferedReader in = new BufferedReader(new FileReader("g:/update.zip"))) {
            String line;
            while((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle FileNotFoundException, etc. here
        }
    }
    @Test
    public void inputStreamReader(){
        Pattern SHELL_META_START = Pattern.compile("^#(\\w+)\\s*(\\w+)?");
        try (BufferedReader console =
                     new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            READ: while((line = console.readLine()) != null) {
                // Check for special commands ("metas")
                Matcher m = SHELL_META_START.matcher(line);
                if (m.find()) {
                    String metaName = m.group(1);
                    String arg = m.group(2);
                    //doMeta(metaName, arg);
                    continue READ;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle FileNotFoundException, etc. here
        }
    }

    @Test
    public void writeTextToFile(){
        File f = new File(System.getProperty("user.home") + File.separator + ".bashrc");
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)))) {
            out.println("## Automatically generated config file. DO NOT EDIT");
        } catch (IOException iox) {
            // Handle exceptions
        }
    }
}

