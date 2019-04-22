/**
 * IQuadTree interface contains methods that help us modify the QuadTree
 * @author calchen
 *
 */
public interface IQuadTree {

	/**
	 * insert() inserts a new BaseNode into the QuadTree
	 * @param newNode the new BaseNode that we want to insert into our tree
	 * @return if the new BaseNode has been successfully inserted
	 */
	public boolean insert(BaseNode newNode);
	
	/**
	 * search() returns a list of locations around the coord
	 * @param coor the coordinate that we want to search
	 * @return a list of locations
	 */
	public List<Location> search(Coordinate coord);
}