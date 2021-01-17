import java.util.HashMap;
import java.util.Set;

public class Java {
    public static void main(String[] args) {
        HashMap<String, String> track = new HashMap<String, String>();
        track.put("nninja@codingdojo.com", "Nancy Ninja");
        track.put("ssamurai@codingdojo.com", "Sam Samurai");
        track.put("wwizard@codingdojo.com", "Walter Wizard");
        Set<String> keys = track.keySet();
        for (String key : keys) {
            // System.out.println(key);
            System.out.println(track.get(key));
        }

    }
}