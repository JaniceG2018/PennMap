import java.util.List;

/**
 * IMapMaker constructs a QuadTree object from a graph in the form of an adjacency matrix
 * @author calchen
 *
 */
public interface IMapMaker {

	/**
	 * makeQuadTree() constructs a QuadTree object from a graph in the form of an adjacency matrix
	 * @param temp a map in the form of an adjacency matrix
	 * @return the QuadTree constructed
	 */
	public QuadTree makeQuadTree(List<List<Object>> temp);
}