import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DictionaryMatch
{
    public static void main(String[] args) {
        String dict_file = "dict.txt";
        DictionaryScanner scanner;
        try {
            scanner = new DictionaryScanner(dict_file);
        }
        catch (FileNotFoundException e) {
            System.err.println("Could not load dictionary");
            return;
        }
        catch (IOException e) {
            System.err.println("Error while reading dictionary");
            return;
        }
        
        String example_check = "tset";
        List<String> list = scanner.find_matches(example_check);
        
        for (String match : list) {
            System.out.print("Found match:");
            System.out.println(match);
        }
    }
}