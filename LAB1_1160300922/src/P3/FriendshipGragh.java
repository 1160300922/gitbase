package P3;
import java.util.*;
import P3.Person;
public class FriendshipGragh {
	private HashMap<Person, HashSet<Person>> link = new HashMap<Person, HashSet<Person>>();
	private HashMap<Person, Integer> map = new HashMap<Person, Integer>();
	public FriendshipGragh()
	{	
	}
	void addVertex(Person person)
	{
		link.put(person, new HashSet<>());
	}
	void addEdge(Person p1, Person p2)
	{
		link.get(p1).add(p2);
	}
	public int getDistance(Person p1, Person p2)
	{
		if(p2.equals(p1))
			return 0;
		else
		{
			Queue<Person> queue = new LinkedList<Person>();
			queue.offer(p1);
			for(Person x : link.keySet())
				map.put(x, Integer.MAX_VALUE);
			map.put(p1, 0);
			while(!queue.isEmpty())
			{
				Person p;
				p = queue.poll();
				for(Person px : link.get(p))
				{
					if(map.get(p) + 1 < map.get(px))
					{
					map.put(px, map.get(p) + 1);
					queue.offer(px);
					}
				}
			}
			if(map.get(p2) == Integer.MAX_VALUE)
				return -1;
			return map.get(p2);
		}
	}
	public static void main(String[] args)
	{
		FriendshipGragh graph = new FriendshipGragh();
		Person rachel = new Person("Rachel"); 
		Person ross = new Person("Ross"); 
		Person ben = new Person("Ben"); 
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel); 
		graph.addVertex(ross); 
		graph.addVertex(ben); 
		graph.addVertex(kramer); 
		graph.addEdge(rachel, ross); 
		graph.addEdge(ross, rachel); 
		graph.addEdge(ross, ben); 
		graph.addEdge(ben, ross); 
		System.out.println(graph.getDistance(rachel, ross));  
		System.out.println(graph.getDistance(rachel, ben));  
		System.out.println(graph.getDistance(rachel, rachel)); 
		System.out.println(graph.getDistance(rachel, kramer)); 		  
	}
}
