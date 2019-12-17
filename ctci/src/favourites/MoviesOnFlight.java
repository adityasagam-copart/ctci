package favourites;

import java.util.*;

/*
 * You are on a flight and wanna watch two movies during this flight. 
 * You are given List<Integer> movieDurations which includes all the movie durations. 
 * You are also given the duration of the flight which is d in minutes.
 * Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
 * Find the pair of movies with the longest total duration and return they indexes. If multiple found, return the pair with the longest movie.
 */
public class MoviesOnFlight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(Arrays.asList(90, 125, 85, 75, 60, 120, 150), 250);
		test(Arrays.asList(-10, 900, 200, 200, 10, 22, 35, 44), 250);
	}
	
	static void test(List<Integer> movieDurationsList, int target) {
		System.out.println(getMovies(movieDurationsList, target));
	}
	
	// cannot sort it caz then the order wouldnt remain
	static List<Integer> getMovies(List<Integer> movieDurationsList, int target) {
		target -= 30;
		List<Integer> result = Arrays.asList(-1,-1);


		return result;
	}
	
}
