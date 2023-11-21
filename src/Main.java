package NIO_Path_File_Complete.src;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    lineCount++;
                    String[] words = currentLine.split(" ");
                    wordCount = wordCount + words.length;
                    for (String word : words){
                        charCount = charCount + word.length();
                    }
                    System.out.println(currentLine);
                    currentLine = reader.readLine();

                }
                reader.close();
                System.out.println("\n\nData file read!");
                System.out.println("Counted " + lineCount + " lines");
                System.out.println("Counted " + wordCount + " words");
                System.out.println("Counted " + charCount + " characters");
            } else
            {
                System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        }
    }
