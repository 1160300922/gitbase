package edge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vertex.Vertex;

public class HyperEdge extends Edge{

	HyperEdge(String label, Double weight) {
		super(label, weight);
	}

	@Override
	public boolean addVertices(List<Vertex> vertices) {
		if(vertices.size() >= 2)
		{
			return super.vertices().addAll(vertices);
		}
		return false;
	}

	@Override
	public Set<Vertex> sourceVertex() {
		Set<Vertex> ver = new HashSet<>();
		ver.addAll(getVertices());
		return ver;
	}

	@Override
	public Set<Vertex> targetVertex() {
		Set<Vertex> ver = new HashSet<>();
		ver.addAll(getVertices());
		return ver;
	}

}
