import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DictionaryScanner
{
    private List<String> words;
    private HashMap<String, List<Integer>> map;

    DictionaryScanner(String dict_file) throws FileNotFoundException, IOException {
        words = new ArrayList<String>();
        
        DictionaryScanner scanner = new DictionaryScanner(dict_file);
        
        BufferedReader reader = new BufferedReader(new FileReader(dict_file));
        
        String line = reader.readLine();
        while (line!= null) {
            add_word(line);
        }
        
        reader.close();
    }

    private void add_word(String word) {
        words.add(word);
        int index = words.size()-1;
        String sorted = sort_word(word);
        List<Integer> matches = map.get(sorted);
        
        if (matches == null) {
            List<Integer> ints = new ArrayList<Integer>();
            ints.add(index);
            map.put(sorted, ints);
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
    
    public List<String> find_matches(String letters) {
        String sorted = sort_word(letters);
        List<String> string_matches = new ArrayList<String>();
        
        List<Integer> match_indexes = map.get(sorted);
        if (match_indexes == null) {
            return null;
        }
        
        boolean exact_match = false;
        for (int match_index : match_indexes) {
            String word = words.get(match_index);
            if(word == letters) {
                exact_match = true;
            }
            else {
                string_matches.add(word);
            }
        }
        if(exact_match == true) {
            List<String> exact_first = new ArrayList<String>();
            exact_first.add(letters);
            exact_first.addAll(string_matches);
            return exact_first;
        }
        return string_matches;
    }
}