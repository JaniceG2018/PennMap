import java.util.List;

/**
 * The IQuadTree interface contains methods that support basic functionalities of a QuadTree
 * @author calchen
 *
 */
public interface IQuadTree {

	/**
	 * insert() inserts a new BaseNode into the QuadTree
	 * @param newNode the new BaseNode that we want to insert into our QuadTree
	 * @return true if the new BaseNode has been successfully inserted and false otherwise
	 */
	public boolean insert(BaseNode newNode);
	
	/**
	 * search() returns a list of Locations of a specified type within a given Range from home
	 * @param type the type of locations, e.g. restaurants
	 * @param range the Range of search from home
	 * @return a list of Locations of the specified type within the given Range from home
	 *         
	 */
	public List<Location> search(String type, Range range);
	
	/**
	 * 
	 * @param locs a list of Locations
	 * @return
	 */
	public Coordinate enclosingQuad(List<Location> locs);
	//someone finish this
}