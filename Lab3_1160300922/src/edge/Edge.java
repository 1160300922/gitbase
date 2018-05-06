package edge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vertex.Vertex;

public abstract class Edge {
	private final List<Vertex> vertices = new ArrayList<>();
	private final String label;
	private final Double weight;
	public Edge(String label, Double weight)
	{
		this.label = label;
		this.weight = weight;
	}
	abstract public boolean addVertices(List<Vertex> vertices);
	public boolean containVertex(Vertex v)
	{
		if(Edge.this.label.equals(v))
			return true;
		return false;
	}
	public String getLabel()
	{
		return label;
	}
	public double getWeight()
	{
		return weight;
	}
	public double setWeight(double w)
	{
		return weight + w;
	}
	public Set<Vertex> vertices()
	{
		Set<Vertex> ver = new HashSet<>();
		ver.addAll(vertices);
		return ver;
	}
	public List<Vertex> getVertices()
	{
		return vertices;
	}
	public abstract Set<Vertex> sourceVertex();
	public abstract Set<Vertex> targetVertex();
	@Override
	public String toString()
	{
		return "vertex : " + label + " weight : " + weight.toString() + "\n";
	}
	@Override
	public boolean equals(Object e)
	{
		return this.label.equals(((Edge)e).label);
	}
	@Override
	public int hashCode()
	{
		return label.hashCode();
	}
}
