package com.bridgelabz.opencsvgson;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
/*
 * @desc : Class to perform operations on JSON files using Gson library in Java.
 */

public class UserJsonOperations {
    /*
     * @desc : Reads user data from a CSV file, converts it to JSON, and writes to a new file.
     * @param folderPath Path of the folder containing the CSV file.
     * @param filePath Name of the CSV file.
     * @param writeFilePath Name of the JSON file to write.
     * @return : void
     * @throws IOException If an I/O error occurs.
     */

    public void writeUserObjectsToJsonFile(String folderPath , String filePath , String writeFilePath){
        try{
            Reader reader = Files.newBufferedReader(Path.of(folderPath , filePath));
            CsvToBeanBuilder<User> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(User.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<User> csvToBean = csvToBeanBuilder.build();

            List<User> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File(folderPath , writeFilePath) , true));
            printWriter.println(json);
            printWriter.close();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(folderPath , writeFilePath)));
            User[] userObj = gson.fromJson(bufferedReader , User[].class);
            List<User> csvUsersList = Arrays.asList(userObj);
            System.out.println(csvUsersList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
