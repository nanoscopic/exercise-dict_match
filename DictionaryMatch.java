import java.util.List;

public class DictionaryMatch
{
    public static void main(String[] args) {
        String dict_file = "dict.txt";
        DictionaryScanner scanner = new DictionaryScanner(dict_file);
        
        String example_check = "tset";
        List<String[]> list = scanner.find_matches(example_check);
        
        for (String match : list) {
            System.out.print("Found match:");
            System.out.println(match);
        }
    }
}