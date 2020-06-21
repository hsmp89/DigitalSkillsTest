package utils;

import com.opencsv.bean.CsvToBeanBuilder;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Util {

    public static String getSystemPropertyValue(String name, String defaultValue) {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        String value = System.getProperty(name);
        if (value == null) {
            value = System.getenv(name);
            if (value == null) {
                value = environmentVariables.getProperty(name);
            }
        }
        return value == null ? defaultValue : value;
    }

    public static List<String> getDataOnRegx(String str) throws IOException {
        Pattern regex = Pattern.compile("[A-Z][A-Z]\\s?[0-9][0-9]\\s?[A-Z]{3}");
        Matcher regexMatcher = regex.matcher(str);
        List<String> dataList = new ArrayList<String>();
        while (regexMatcher.find()) {
            if (regexMatcher.group(0) != null) {
                //removing any space
                dataList.add(regexMatcher.group(0).replace(" ",""));
//                dataList.add(regexMatcher.group(0));
            }
        }
        System.out.println(dataList);
        return dataList;

    }

    public static String parseInputFileAsString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }


    public static Map<String, CsvParser> getCarOutputFileDataFromCSV(String outputFile) throws FileNotFoundException {

        Map<String, CsvParser> registrationMap = new HashMap<>();

        List<CsvParser> treeParser = new CsvToBeanBuilder(new FileReader(outputFile))
                .withType(CsvParser.class).build().parse();

        for (CsvParser record : treeParser) {

            CsvParser csvOutputFileData = new CsvParser();
            csvOutputFileData.setREGISTRATION(record.getREGISTRATION());
            csvOutputFileData.setMAKE(record.getMAKE());
            csvOutputFileData.setMODEL(record.getMODEL());
            csvOutputFileData.setCOLOR(record.getCOLOR());
            csvOutputFileData.setYEAR(record.getYEAR());
            registrationMap.put(csvOutputFileData.getREGISTRATION(), csvOutputFileData);
        }
        return registrationMap;
    }

}
