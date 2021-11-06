/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

/**
 *
 * @author alsul
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author alsul
 */
public class FileReadAndCount {

    public static void main(String[] args) throws IOException {

        List<Pattern> patterns = new ArrayList<>();
        Pattern wordSplit = Pattern.compile("[ \n\t\r,.;:(){}\"]");
        Pattern letterSplit = Pattern.compile("");

        Map<String, Long> wordCounts
                = Files.lines(Paths.get("D:\\lab4.txt"))
                        .flatMap(wordSplit::splitAsStream)
                        .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));

        Map<String, Long> letterCount
                = Files.lines(Paths.get("D:\\lab4.txt"))
                        .flatMap(letterSplit::splitAsStream)
                        .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));

        System.out.println("Letter : Occurrence");
        letterCount.entrySet()
                .stream()
                .collect(
                        Collectors.groupingBy(Map.Entry::getKey,
                                TreeMap::new, Collectors.toList()))
                .forEach((letter, count) -> {
                    count.forEach(word -> System.out.printf(
                            "%s  :%d%n", word.getKey(), word.getValue()
                    ));
                });

        System.out.println();
        System.out.println("words : occurrences ");
        wordCounts.entrySet()
                .stream()
                .collect(
                        Collectors.groupingBy(Map.Entry::getKey,
                                TreeMap::new, Collectors.toList()))
                .forEach((letter, wordList) -> {
                    wordList.forEach(word -> System.out.printf(
                            "%3s: %d%n", word.getKey(), word.getValue()));
                });

    }

}
