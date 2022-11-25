package assignment;

import textio.TextIO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RainfallAnalyser {
    /**
     * Author:
     * Version:
     * Date:
     * Git URL:
     */

    //define constants
    private static final String OUTPUT_HEADER = "year,month,max,min,total";

    public static void main(String[] args) {
        System.out.println("Enter a filename: ");
        String filename = TextIO.getln();
        try {
            TextIO.readFile(filename);
            System.out.println("reading successfully");
            //generate output file
            String outputFile = generateOutputFile(filename);
            //save monthly total, min, and max to outputFile
            generateMonthlyStatistics(outputFile, filename);
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void generateMonthlyStatistics(String ouputFile, String filename) {
        String[] record;

        int checkColumn;
        int year;
        byte currentMonth;
        byte lastMonth = 1;
        double rainAmong;
        double totalMonthlyRainfall = 0.0;
        double max = Double.NEGATIVE_INFINITY ;
        double min = Double.POSITIVE_INFINITY;

        try{
            Scanner scanner = new Scanner(new FileReader(filename));
            while (scanner.hasNextLine()){
                scanner.nextLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }


        //read the first line and ignore it
        String line = TextIO.getln();
        checkColumn = line.split(",").length;

        // for testing only - it is not satisfied the requirements
        TextIO.writeFile(filename);
        TextIO.putln(OUTPUT_HEADER);

        //System.out.println(line); //testing


        if(TextIO.eof()){
            System.out.println("Empty file. Aborted.");
            return;
        }

        //start extract the records


        while (!TextIO.eof()) {
            //and read again
            line = TextIO.getln().trim();

            //extract info ...
            record = line.split(",");

            String[] newRecord = Arrays.copyOf(record, checkColumn);
            for (int i = 0; i < checkColumn; i++) {
                if (newRecord[i] == null || newRecord[i].equals(" ")) {
                    newRecord[i] = "0";
                }
            }
            record = newRecord;
            // extract year, month, day, rainfall from record
            year = Integer.parseInt(record[2]);
            currentMonth = Byte.parseByte(record[3]);
            rainAmong = Double.parseDouble(record[5]);

            totalMonthlyRainfall += rainAmong;

            if (rainAmong < min) {
                min = rainAmong;
            }

            if (rainAmong > max) {
                max = rainAmong;
            }

            //writeMonthlyRecord(year,currentmonth, totalMonthlyRainfall, minMonthlyRainfall, maxMonthlyRainfall);
            if (currentMonth != lastMonth) {
                writeMonthlyRecord(year, lastMonth, max, min, totalMonthlyRainfall);

                lastMonth = currentMonth;
                totalMonthlyRainfall = rainAmong;
                max = Double.NEGATIVE_INFINITY;
                min = Double.POSITIVE_INFINITY;

                if (rainAmong < min) {
                    min = rainAmong;
                }

                if (rainAmong > max) {
                    max = rainAmong;
                }
            }
        }

    }

    private static void writeMonthlyRecord(int year, byte lastmonth,double totalMonthlyRainfall, double min,
                                           double max) {
        String yearString = Integer.toString(year);
        String monthString = Byte.toString(lastmonth);
        String maxString = String.format("%.02f", max);
        String minString = String.format("%.02f", min);
        String totalString = String.format("%.02f", totalMonthlyRainfall);

        String row = yearString + ", " + monthString + ", " + totalString + ", " + minString + ", " + maxString;

        TextIO.putln(row);
    }

    private static String generateOutputFile(String filename) {

        String[] fileParts = filename.split("\\.");

        String outputFile = fileParts[0] + "_analysed.csv";
        //testing only
        //System.out.println(Arrays.toString(fileParts));
        return outputFile;
    }
}