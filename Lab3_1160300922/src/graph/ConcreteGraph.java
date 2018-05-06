package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edge.Edge;
import vertex.Vertex;

public class ConcreteGraph implements Graph<Vertex, Edge> {
	private final List<Vertex> vertices = new ArrayList<>();
	private final List<Edge> edges = new ArrayList<>();
	private String label;
	
	@Override
	public boolean add(Vertex v) {
    	for(Vertex v1 : vertices)
    	{
    		if(v1.equals(v))
    		{
    			return false;
    		}
    	}
        return vertices.add(v);
	}

	@Override
	public boolean remove(Vertex v) {
		Vertex ver = v;
    	for(Vertex v1 : vertices)
    	{
    		if(v1.equals(v))
    		{
    			ver = v1;
    		}
    	}
    	for(Edge e : edges)
    	{
    		if(e.containVertex(ver))
    		{
    			if(e.getVertices().size() == 2)
    			{
    				edges.remove(e);
    			}
    		}
    	}
        return vertices.remove(ver);
	}

	@Override
	public Set<Vertex> vertices() {
		Set<Vertex> ver = new HashSet<>();
		ver.addAll(vertices);
		return ver;
	}

	@Override
	public Map<Vertex, List<Double>> sources(Vertex target) {
		final List<Double> weights = new ArrayList<>();
		final Map<Vertex, List<Double>> map = new HashMap<>();
		for(Edge e : edges)
		{
			if(e.containVertex(target))
			{
				for(Vertex v : e.vertices())
				{
					if(v.equals(target))
						continue;
					for(Edge e1 : edges)
					{
						if(e1.containVertex(v))
							weights.add(e1.getWeight());
					}
					map.put(v, weights);
				}
			}
		}
		return map;
	}

	@Override
	public Map<Vertex, List<Double>> targets(Vertex source) {
		final List<Double> weights = new ArrayList<>();
		final Map<Vertex, List<Double>> map = new HashMap<>();
		for(Edge e : edges)
		{
			if(e.containVertex(source))
			{
				for(Vertex v : e.vertices())
				{
					if(v.equals(source))
						continue;
					for(Edge e1 : edges)
					{
						if(e1.containVertex(v))
							weights.add(e1.getWeight());
					}
					map.put(v, weights);
				}
			}
		}
		return map;
	}

	@Override
	public boolean addEdge(Edge edge) {
		vertices.addAll(edge.getVertices());
		return edges.add(edge);
	}

	@Override
	public boolean removeEdge(Edge edge) {
		return edges.remove(edge);
	}

	@Override
	public Set<Edge> edges() {
		Set<Edge> e = new HashSet<>();
		e.addAll(edges);
		return e;
	}
	
	@Override
	public String setLabel(String s)
	{
		return label = s;
	}
	
	@Override
	public String getLabel()
	{
		return label;
	}
}
