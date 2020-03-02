package com.Bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CSVWithoutHeader {
          private static final String SAMPLE_CSV_FILE_PATH = "/home/admin1/Fellowship/CSV/src/main/java/user.csv";
//        private static final String SAMPLE_CSV_FILE_PATH = "/home/admin1/Fellowship/CSV/src/main/java/users-with-header.csv";

        public static void main(String[] args) throws IOException {
            try (
                    Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                 //   CSVReader csvReader = new CSVReader(reader);
            ) {

                CsvToBean<POJOClass> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(POJOClass.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                  Iterator<POJOClass> cvsReader = csvToBean.iterator();
                // Reading Records One by One in a String array
                while (cvsReader.hasNext()) {

                    POJOClass csvUser = cvsReader.next();
                    System.out.println("Name : " + csvUser.getName());
                    System.out.println("Email : " + csvUser.getEmail());
                    System.out.println("PhoneNo : " + csvUser.getPhoneNo());
                    System.out.println("Country : " + csvUser.getCountry());
                    System.out.println("==========================");
                }
            }
        }
}
