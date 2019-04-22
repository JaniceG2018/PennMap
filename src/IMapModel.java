import java.util.List;

/**
 * 
 * @author calchen
 *
 */
public interface IMapModel {

	/**
	 * 
	 * @param loc1
	 * @param loc2
	 * @return
	 */
	public String shortestPath(String loc1, String loc2);
	
	/**
	 * 
	 * @param type
	 * @param dist
	 * @return
	 */
	public List<String> findAll(String type, double dist);
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	public String findNearest(String type);
}