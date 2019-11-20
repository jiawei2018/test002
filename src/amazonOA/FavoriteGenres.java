package amazonOA;

import java.util.*;

public class FavoriteGenres {
    /*\
    Given a map Map<String, List<String>> userSongs with user names
    as keys and a list of all the songs that the user has listened to as values.

Also given a map Map<String, List<String>> songGenres,
with song genre as keys and a list of all the songs within that genre as values.
The song can only belong to only one genre.

The task is to return a map Map<String, List<String>>,
 where the key is a user name and the value is a list of the user's favorite genre(s).
 Favorite genre is the most listened to genre.
 A user can have more than one favorite genre if he/she
 has listened to the same number of songs per each of the genres.

Example 1:

Input:
userSongs = {
   "David": ["song1", "song2", "song3", "song4", "song8"],
   "Emma":  ["song5", "song6", "song7"]
},
songGenres = {
   "Rock", Arrays.asList("song1", "song3")
   "Dubstep",Arrays.asList("song7")
   "Techno",Arrays.asList( "song2", "song4")
   "Pop",Arrays.asList( "song5", "song6")
   "Jazz",Arrays.asList("song8", "song9")
}

Output: {
   "David": ["Rock", "Techno"],
   "Emma":  ["Pop"]
}

Explanation:
David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
Example 2:

Input:
userSongs = {
   "David": ["song1", "song2"],
   "Emma":  ["song3", "song4"]
},
songGenres = {}

Output: {
   "David": [],
   "Emma":  []
}

    * */
    //union-find ?
    //bucket sort ?
    public static void main(String[] args) {
        FavoriteGenres t = new FavoriteGenres();
        Map<String, List<String>> us = new HashMap<>();
        Map<String, List<String>> gs = new HashMap<>();
        us.put("David",Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        us.put("Emma",Arrays.asList("song5", "song6", "song7"));

//        gs.put("Rock", Arrays.asList("song1", "song3"));
//        gs.put("Dubstep",Arrays.asList("song7"));
//        gs.put("Techno",Arrays.asList( "song2", "song4"));
//        gs.put("Pop",Arrays.asList( "song5", "song6"));
//        gs.put("Jazz",Arrays.asList("song8", "song9"));

        System.out.println(t.favoriteGenres(us, gs));

    }

    public Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs,
                                                    Map<String, List<String>> songGenres){
        Map<String, List<String>> res = new HashMap<>();// or treeMap
        //us[
        // er songs => user name, users's favorite songs;
        if(userSongs == null || songGenres == null){
            return res;
        }
        if(userSongs.size() == 0){

        }
        //genre -> <genre, songs>
        Map<String, String> gmap = getMap(songGenres);
        for(String u : userSongs.keySet()){
            List<String> cur = getUserFavoriteGenre(userSongs.get(u), gmap);
            res.put(u, cur);
        }
        return res;
    }
    private Map<String, String> getMap(Map<String, List<String>> songGenres){
        Map<String, String> map = new HashMap<>();
        for(String g : songGenres.keySet()){
            for(String s : songGenres.get(g)){
                map.put(s, g);
            }
        }
        return map;
    }

    private List<String> getUserFavoriteGenre(List<String> songs, Map<String, String> map){
         List<String>[] tmp = new List[songs.size()];
         List<String> res = new ArrayList<>();
         Map<String ,Integer> fmap = new HashMap<>();
         for(String s : songs){
             String g = map.get(s);
             if(g == null || g.length() == 0){
                 continue;
             }
             fmap.put(g, fmap.getOrDefault(g, 0) + 1);
         }

         for(String g : fmap.keySet()){
             int f = fmap.get(g);
             if(tmp[f] == null){
                 tmp[f] = new ArrayList<>();
             }
             tmp[f].add(g);
         }

         for(int i = tmp.length - 1; i >= 0; i--){
             if(tmp[i] != null){
                 res.addAll(tmp[i]);
                 break;
             }
         }
         return res;
    }



}
