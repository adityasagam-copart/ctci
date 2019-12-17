package favourites;
import java.util.*;
import java.util.Map.Entry;

/*
 * Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs
 * that the user has listened to as values. Also given a map Map<String, List<String>> songGenres, with
 * song genre as keys and a list of all the songs within that genre as values. The song can only belong
 * to only one genre.
 * 
 * The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a
 * list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more
 * than one favorite genre if he/she has listened to the same number of songs per each of the genres.
 * 
 */

public class FavouriteGenres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, List<String>> userSongs = new HashMap<String, List<String>>();
		Map<String, List<String>> songGenres = new HashMap<String, List<String>>();
		
		userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
		userSongs.put("Beck", Arrays.asList("song5", "song6", "song7"));
		
		songGenres.put("Rock", Arrays.asList("song1", "song3"));
		songGenres.put("Dubstep", Arrays.asList("song7"));
		songGenres.put("Techno", Arrays.asList("song2", "song4"));
		songGenres.put("Pop", Arrays.asList("song5", "song6"));
		songGenres.put("Jazz", Arrays.asList("song8", "song9"));
		
		Map<String, List<String>> res = getFavGenres(userSongs, songGenres);
		System.out.println(res.toString());
		
	}
	
	public static Map<String, List<String>> getFavGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres){
		Map<String, List<String>> result = new HashMap<String, List<String>>();

		Map<String, String> mapSongToGenres = new HashMap<String, String>();
		for(Entry<String, List<String>> entry : songGenres.entrySet()) {
			for(String song: entry.getValue()) {
				mapSongToGenres.put(song, entry.getKey());
			}
		}
		//System.out.println(mapSongToGenres.toString());
		
		for(Entry<String, List<String>> entry : userSongs.entrySet()) {
			String user = entry.getKey();
			Map<String, Integer> mapGenreCount = new HashMap<String, Integer>();
			List<String> favGenres = new ArrayList<String>();
			
			for(String song: entry.getValue()) {
				if(mapSongToGenres.containsKey(song)) {
					String genre = mapSongToGenres.get(song);
					
					if(mapGenreCount.containsKey(genre)){
						int count = mapGenreCount.get(genre);
						mapGenreCount.put(genre, count+1);
					}
					else {
						mapGenreCount.put(genre, 1);
					}
				}
			}
			//System.out.println("User:" + user+ "; map: "+ mapGenreCount.toString());
			
			List<String> favSongList = new ArrayList<String>();
			int max = 0;
			for(Entry<String, Integer> genreCountEntry: mapGenreCount.entrySet()) {
				
				int genreCount = genreCountEntry.getValue();
				//System.out.println("\tMax:" +max + "; current "+ genreCountEntry.getKey() +" - " + genreCount);
				if(genreCount == max) {
					favSongList.add(genreCountEntry.getKey());
				}
				else if(genreCount > max) {
					max = genreCountEntry.getValue();
					favSongList = new ArrayList<String>(Arrays.asList(genreCountEntry.getKey()));
				}
			}
			//System.out.println("favSongList: " + favSongList.isEmpty());
			result.put(user, favSongList);
		}
		return result;
	}
	
}
