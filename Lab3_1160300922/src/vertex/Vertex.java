package vertex;

public abstract class Vertex {
	private String label;
	public Vertex (String label)
	{
		this.label = label;
	}
	abstract void fillVertexInfo(String[] args);
	public String setLabel(String s)
	{
		label = s;
		return label;
	}
	public String getLabel()
	{
		return label;
	}
	@Override
	public String toString()
	{
		return label;	
	}
	@Override
	public boolean equals(Object v)
	{
		return this.label.equals(((Vertex)v).label);
	}
	@Override
	public int hashCode()
	{
		return label.hashCode();
	}
}
