package com.bridgelabz.opencsvgson;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
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

        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * @desc : Reads user details from a CSV file, parses to beans, and prints.
     * @param folderPath Path of the folder containing the CSV file.
     * @param filePath Name of the CSV file.
     *  @return : void
     * @throws IOException If an I/O error occurs.
     */
    public void readUserFromCsvAndParseToBean(String folderPath , String filePath) throws IOException {
        try(Reader reader = Files.newBufferedReader(Path.of(folderPath , filePath));){
            CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader)
                    .withType(User.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<User> csvUserIterator = csvToBean.iterator();
            while(csvUserIterator.hasNext()){
                User user = csvUserIterator.next();
                System.out.println("Name : "+ user.getName());
                System.out.println("Email : "+ user.getEmail());
                System.out.println("Phone : "+ user.getPhoneNo());
                System.out.println("Country : "+ user.getCountry());
                System.out.println("================================");
            }
        }
    }
    /*
     * @desc : Reads all user details from a CSV file at once, parses to beans, and prints.
     * @param folderPath Path of the folder containing the CSV file.
     * @param filePath Name of the CSV file.
     *  @return : void
     * @throws IOException If an I/O error occurs.
     */


    public void readUserFromCsvAtOnceAndParseToBean(String folderPath , String filePath) throws IOException {
        try(Reader reader = Files.newBufferedReader(Path.of(folderPath , filePath));){
            CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader)
                    .withType(User.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            for (User user : csvToBean) {
                System.out.println("Name : " + user.getName());
                System.out.println("Email : " + user.getEmail());
                System.out.println("Phone : " + user.getPhoneNo());
                System.out.println("Country : " + user.getCountry());
                System.out.println("================================");
            }
        }
    }

    /*
     * @desc : Writes user details into a CSV file.
     * @param folderPath Path of the folder to save the CSV file.
     * @param filePath Name of the CSV file.
     *  @return : void
     * @throws IOException If an I/O error occurs.
     */

    public void writeUserDetailsIntoACsvFile(String folderPath , String filePath) throws IOException {
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(new File(folderPath , filePath) , true));){
            StatefulBeanToCsv<MyUser> statefulBeanToCsvBuilder = new StatefulBeanToCsvBuilder<MyUser>(printWriter)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withOrderedResults(true).build();
            // Read the existing CSV file to check if it contains any data
            boolean fileContainsData = Files.lines(Paths.get(folderPath, filePath)).findAny().isPresent();

            List<MyUser> newUsers = new ArrayList<>();



            newUsers.add(new MyUser("Mahidhar" , "mahi@gmail.com" , "+91 7894563210", "India"));
            newUsers.add(new MyUser("Karthik" , "Karthik@gmail.com" , "+91 7894563210", "India"));
            newUsers.add(new MyUser("sumit" , "sumit@gmail.com" , "+91 7894563210", "India"));
            System.out.println(newUsers);
            for(MyUser newUser : newUsers){
                printWriter.println(newUser.getOrderedString());
            }
            statefulBeanToCsvBuilder.write(newUsers);

        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        }
    }

}
