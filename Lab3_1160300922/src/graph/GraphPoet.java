package graph;

import edge.Edge;

public class GraphPoet extends ConcreteGraph{
	public double changeWeight(Edge e)
	{
		if(edges().contains(e))
		{
			for(Edge e1 : edges())
			{
				if(e1.equals(e))
				{
					e1.setWeight(1);
					return 1;
				}
			}
		}
		return 0;
	}
}
