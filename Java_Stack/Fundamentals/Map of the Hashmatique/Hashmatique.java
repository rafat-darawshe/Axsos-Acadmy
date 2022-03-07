import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("I don't know why he told ", "boy was realer than");
        trackList.put("Jam get out that jam ", "I gave him fifty");
        trackList.put("I am what I am ", "what I'm not");
        trackList.put("Niggas woofin' up until we meet ", "Catch him lackin");
        System.out.println(trackList.get("I don't know why he told "));
        Set<String> Lyrics = trackList.keySet();
        for(String track : Lyrics){
            System.out.println(track +":"+ trackList.get(track));
        }
        

    }
    
    }