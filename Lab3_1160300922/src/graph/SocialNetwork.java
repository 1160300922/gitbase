package graph;

import edge.Edge;

public class SocialNetwork extends ConcreteGraph{
	public double addWeight(Edge e)
	{
		if(edges().contains(e))
		{
			for(Edge e1 : edges())
			{
				if(e1.equals(e))
				{
					e1.setWeight(e.getWeight());
				}
				else 
				{
					e1.setWeight(e1.getWeight() * (1 - e.getWeight()));
				}
			}
			return 1;
		}
		return 0;
	}
	public double changeWeight(Edge e)
	{
		double w = 0.0;
		if(edges().contains(e))
		{
			for(Edge e1 : edges())
			{
				if(e1.equals(e))
				{
					w = e1.getWeight();
					e1.setWeight(e.getWeight());
				}
			}
			for(Edge e1 : edges())
			{
				if(e1.equals(e))
				{
					continue;
				}
				e1.setWeight(e1.getWeight() * (1 - e.getWeight()) / (1 - w));
			}
		}
		return 0;
	}
	public double removeWeight(Edge e)
	{
		if(edges().contains(e))
		{
			for(Edge e1 : edges())
			{
				if(e1.equals(e))
				{
					e = e1;
				}
				else
				{
					e1.setWeight(e1.getWeight() / (1 - e.getWeight()));
				}
			}
		}
		return 0;
	}
}
