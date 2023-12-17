package com.bridgelabz.opencsvgson;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
 * @desc : Class to perform operations on CSV files using OpenCSV and Gson libraries.
 */


public class UsersCsvOperations {
    /*
     * @desc : Reads a CSV file and prints user details.
     * @param filePath Path of the CSV file.
     * @return : void
     * @throws IOException If an I/O error occurs.
     * @throws CsvValidationException If CSV validation fails.
     */


    public void readUserCsvFileAndPrint(String filePath){

        try(
                Reader reader = Files.newBufferedReader(Path.of(filePath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;

            while((nextRecord = csvReader.readNext())!=null){
                System.out.println("Name : "+ nextRecord[0]);
                System.out.println("Email : "+ nextRecord[1]);
                System.out.println("Phone : "+ nextRecord[2]);
                System.out.println("Country : "+ nextRecord[3]);
                System.out.println("================================");
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }
    /*
     * @desc : Reads a CSV file from a specific folder and prints user details.
     * @param folderPath Path of the folder containing the CSV file.
     * @param filePath Name of the CSV file.
     * @return : void
     * @throws IOException If an I/O error occurs.
     * @throws CsvValidationException If CSV validation fails.
     */

    public void readUserCsvFileAndPrint(String folderPath , String filePath){

        try(
                Reader reader = Files.newBufferedReader(Path.of(folderPath , filePath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;

            while((nextRecord = csvReader.readNext())!=null){
                System.out.println("Name : "+ nextRecord[0]);
                System.out.println("Email : "+ nextRecord[1]);
                System.out.println("Phone : "+ nextRecord[2]);
                System.out.println("Country : "+ nextRecord[3]);
                System.out.println("================================");
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }
    /*
     * @desc : Reads all records from a CSV file and prints user details.
     * @param folderPath Path of the folder containing the CSV file.
     * @param filePath Name of the CSV file.
     * @return : void
     * @throws IOException If an I/O error occurs.
     * @throws CsvValidationException If CSV validation fails.
     * @throws CsvException If a general CSV exception occurs.
     */

    public void readAllUserRecords(String folderPath , String filePath){
        try(
                Reader reader = Files.newBufferedReader(Path.of(folderPath , filePath));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            List<String[]> records = csvReader.readAll();

           for(String[] record : records){
               System.out.println("Name : "+ record[0]);
               System.out.println("Email : "+ record[1]);
               System.out.println("Phone : "+ record[2]);
               System.out.println("Country : "+ record[3]);
               System.out.println("================================");
           }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }


}
