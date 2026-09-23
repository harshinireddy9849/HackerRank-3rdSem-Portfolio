import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY stringList
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(
            List<String> stringList, List<String> queries) {

        Map<String, Integer> frequency = new HashMap<>();

        // Count how many times each string occurs
        for (String str : stringList) {
            frequency.put(str, frequency.getOrDefault(str, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Find the frequency of each query
        for (String query : queries) {
            result.add(frequency.getOrDefault(query, 0));
        }

        return result;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
                new BufferedWriter(
                        new FileWriter(System.getenv("OUTPUT_PATH"))
                );

        int stringListCount =
                Integer.parseInt(bufferedReader.readLine().trim());

        List<String> stringList = IntStream.range(0, stringListCount)
                .mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int queriesCount =
                Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount)
                .mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> res =
                Result.matchingStrings(stringList, queries);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n"))
        );

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
