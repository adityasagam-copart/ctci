package favourites;

import java.awt.Point;
import java.util.*;

/*
 * You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs.
 * Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest
 * route to one of the treasure islands.
 * 
 * Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from one of the starting
 * point (marked as S) of the map and can move one block up, down, left or right at a time. The treasure island is marked as X.
 * Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area.
 * Other areas O are safe to sail in. Output the minimum number of steps to get to any of the treasure islands.
 * 
 */
public class TreasureIsland2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {
	            {'S', 'O', 'O', 'S', 'S'},
	            {'D', 'O', 'D', 'O', 'D'},
	            {'O', 'O', 'O', 'O', 'X'},
	            {'X', 'D', 'D', 'O', 'O'},
	            {'X', 'D', 'D', 'D', 'O'}};
    	System.out.println(getDistance(grid));
	}
	
	public static int getDistance(char[][] grid) {
		//int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
		List<Point> dirs = new ArrayList(Arrays.asList(new Point(0,1),new Point(1,0), new Point(0,-1), new Point(-1,0)));
		Queue Q = getStartQueue(grid);
		
		for(int dist = 0; !Q.isEmpty(); dist++) {
			for(int size=Q.size(); size>0; size--) {
				Point point = (Point) Q.poll();
				
				if(grid[point.x][point.y] == 'X') return dist;
				grid[point.x][point.y] = 'D';	// mark each node coming from queue as visited
				
				for(Point d : dirs) {
					int x = point.x + d.x;
					int y = point.y + d.y;
					
					if(x >= 0 && x < grid.length
							&& y >= 0 && y < grid[0].length
							&& grid[x][y] != 'D') {
						Q.add(new Point(x,y));
					}
				}
			}
		}
		return -1;
	}
	
	static Queue<Point> getStartQueue(char[][] grid){
		Queue<Point> Q = new LinkedList<>();
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 'S') {
					Q.add(new Point(i, j));
				}
			}
		}
		System.out.println(Q.toString());
		return Q;
	}
}
