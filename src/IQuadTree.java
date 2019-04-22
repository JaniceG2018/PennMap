/**
 * 
 * @author calchen
 *
 */
public interface IQuadTree {

	/**
	 * 
	 * @param newNode
	 * @return
	 */
	public boolean insert(BaseNode newNode);
	
	/**
	 * 
	 * @param coor
	 */
	public void search(Coordinate coor);
	
	/**
	 * 
	 * @return
	 */
	public InternalNode split();
}