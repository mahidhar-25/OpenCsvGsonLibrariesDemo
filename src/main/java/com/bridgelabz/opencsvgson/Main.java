package com.bridgelabz.opencsvgson;

import java.io.IOException;

public class Main {
    private static final String CURRENT_DIRECTORY= System.getProperty("user.dir");
    private static final String READ_USERS_CSV_FILE = "/databasefiles/users.csv";
    private static final String WRITE_USERS_CSV_FILE = "/databasefiles/users.json";
    public static void main(String[] args) throws IOException {
        System.out.println("!!! welcome to open csv gson demo !!!");
        UsersCsvOperations usersCsvOperations = new UsersCsvOperations();
        //USE CASE 1
        usersCsvOperations.readUserCsvFileAndPrint(CURRENT_DIRECTORY , READ_USERS_CSV_FILE);
        //USE CASE 2
        usersCsvOperations.readAllUserRecords(CURRENT_DIRECTORY , READ_USERS_CSV_FILE);
        //USE CASE 3
        usersCsvOperations.readUserFromCsvAndParseToBean(CURRENT_DIRECTORY , READ_USERS_CSV_FILE);

        usersCsvOperations.readUserFromCsvAtOnceAndParseToBean(CURRENT_DIRECTORY , READ_USERS_CSV_FILE);

    }
}
