import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class DictionaryScanner
{
    private List words;
    private HashMap<String, List<int>> map;

    DictionaryScanner(String[] dict_file) {
        DictionaryScanner scanner = new DictionaryScanner(dict_file);
        
        BufferedReader reader = new BufferedReader(new FileReader(dict_file));
        
        String line = reader.readLine();
        while (line!= null) {
            add_word(line);
        }
        
        reader.close();
    }

    private static void add_word(String word) {
        words.add(word);
        int index = words.length;
        String sorted = sort_word(word);
        List<int> matches = map.get(sorted);
        
        if( NULL == matches ) {
            map.set(sorted, new List<index>);
        }
        else {
            matches.add(index);
        }
    }

    private static String sort_word(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
    
    public static List<String> find_matches(String letters) {
        String sorted = sort_word(letters);
        List<String> string_matches = new List<String>;
        
        List<int> match_indexes = map.get(sorted);
        if( NULL == match_indexes ) {
            return NULL;
        }
        
        boolean exact_match = false;
        for (int match_index : match_indexes) {
            String word = words.getAt(match_index);
            if(word == letters) {
                exact_match = true;
            }
            else {
                string_matches.add(word);
            }
        }
        if(exact_match == true) {
            List<String> exact_first = new List<String>;
            exact_first.add(letters);
            exact_first.addAll(string_matches);
            return exact_first;
        }
        return string_matches;
    }
}