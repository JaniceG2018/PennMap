import java.util.List;

/**
 * 
 * @author calchen
 *
 */
public interface IMapMaker {

	/**
	 * 
	 * @param temp
	 * @return
	 */
	public QuadTree makeQuadTree(List<List<Object>> temp);
}