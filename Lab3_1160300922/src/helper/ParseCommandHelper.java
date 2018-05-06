package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

import edge.CommentConnection;
import edge.Edge;
import edge.ForwardConnection;
import edge.FriendConnection;
import edge.MovieActorRelation;
import edge.MovieDirectorRelation;
import edge.NetworkConnection;
import edge.SameMovieHyperEdge;
import edge.WordEdge;
import graph.ConcreteGraph;
import graph.Graph;
import graph.GraphPoet;
import graph.MovieGraph;
import graph.NetworkTopology;
import graph.SocialNetwork;
import vertex.Actor;
import vertex.Computer;
import vertex.Director;
import vertex.Movie;
import vertex.Person;
import vertex.Router;
import vertex.Server;
import vertex.Vertex;
import vertex.Word;

public class ParseCommandHelper {
	private Graph<Vertex, Edge> graph = new ConcreteGraph();
	public boolean OpenFile() throws FileNotFoundException
	{
		File file = new File("E:/java/LAB3_1160300922/src/1.txt");
		Scanner input = new Scanner(file);
		String line1 = input.nextLine();
		String patterna = "\"(\\w+)\"";
		Pattern pattern1 = Pattern.compile(patterna);
		Matcher m1 = pattern1.matcher(line1);
		if(m1.find())
		{
			if(m1.group(1) == "GraphPoet")
			{
				graph = new GraphPoet();
			}
			else if(m1.group(1) == "SocialNetwork")
			{
				graph = new SocialNetwork();
			}
			else if(m1.group(1) == "NetworkTopology")
			{
				graph = new NetworkTopology();
			}
			else if(m1.group(1) == "MovieGraph")
			{
				graph = new MovieGraph();
			}
		}
		String line2 = input.nextLine();
		String patternb = "\"(\\w+)\"";
		Pattern pattern2 = Pattern.compile(patternb);
		Matcher m2 = pattern2.matcher(line2);
		if(m2.find())
		{
			graph.setLabel(m2.group(1));
		}
		String line3 = input.nextLine();
		String patternc = "\"\\w+\"";
		Pattern pattern3 = Pattern.compile(patternc);
		Matcher m3 = pattern3.matcher(line3);
		if(m3.find())
		{
			
		}
		while(input.hasNextLine())
		{
			String line = input.nextLine();
			String px = "([\\s\\S]*)";
			String pattern = "(\\w+)(\\=)" + px;
			Pattern pn = Pattern.compile(pattern);
			Matcher m = pn.matcher(line);
			if(m.find())
			{
				if(m.group(1) != "Vertex")
				{
					break;
				}
				else
				{
					List<String> sl = new ArrayList<>();
					String p = "\"(\\w+)\"";
					Pattern pa = Pattern.compile(p);
					Matcher m0 = pa.matcher(px);
					while(m0.find())
					{
						sl.add(m0.group(1));
					}
					Vertex v;
					if(sl.get(1) == "Word")
					{				
						v = new Word(sl.get(0));
						
					}
					else if(sl.get(1) == "Person")
					{
						String s[] = sl.get(2).split(",");
						v = new Person(sl.get(0), s[0], Integer.parseInt(s[1]));
					}
					else if(sl.get(1) == "Computer")
					{
						v = new Computer(sl.get(0), sl.get(2));
					}
					else if(sl.get(1) == "Router")
					{
						v = new Router(sl.get(0), sl.get(2));
					}
					else if(sl.get(1) == "Server")
					{
						v = new Server(sl.get(0), sl.get(2));
					}
					else if(sl.get(1) == "Movie")
					{
						String s[] = sl.get(2).split(",");
						v = new Movie(sl.get(0), Integer.parseInt(s[0]), s[1], s[2]);
					}
					else if(sl.get(1) == "Actor")
					{
						String s[] = sl.get(2).split(",");
						v = new Actor(sl.get(0), Integer.parseInt(s[0]), s[1]);
					}
					else if(sl.get(1) == "Director")
					{
						String s[] = sl.get(2).split(",");
						v = new Director(sl.get(0), Integer.parseInt(s[0]), s[1]);
					}
				}
			}
		}
		while(input.hasNextLine())
		{
			String line = input.nextLine();
			String patternd = "\"\\w+\"";
			Pattern pattern4 = Pattern.compile(patternd);
			Matcher m4 = pattern4.matcher(line);
			if(m4.find())
			{
			
			}
		}
		while(input.hasNextLine())
		{
			String line = input.nextLine();
			String px = "([\\s\\S]*)";
			String pattern = "(\\w+)(\\=)" + px;
			Pattern pn = Pattern.compile(pattern);
			Matcher m = pn.matcher(line);
			if(m.find())
			{
				if(m.group(1) != "Edge")
				{
					break;
				}
				else
				{
					List<String> sl = new ArrayList<>();
					String p = "\"(\\w+)\"";
					Pattern pa = Pattern.compile(p);
					Matcher m0 = pa.matcher(px);
					while(m0.find())
					{
						sl.add(m0.group(1));
					}
					Edge e;
					if(sl.get(1) == "WordEdge")
					{				
						List<Vertex> ver = new ArrayList<>();
						e = new WordEdge(sl.get(0), Double.parseDouble(sl.get(2)));
						for(Vertex v : e.vertices())  
						{
							if(v.getLabel() == sl.get(3) || v.getLabel() == sl.get(4))
							{
								ver.add(v);
							}
						}
						e.addVertices(ver);
						for(Vertex v : e.vertices())
						{
							if(v.getLabel() == sl.get(3))
							{
								e.sourceVertex();
							}
							else if(v.getLabel() == sl.get(4))
							{
								e.targetVertex();
							}
						}
					}
					else if(sl.get(1) == "CommentConnection")
					{				
						List<Vertex> ver = new ArrayList<>();
						e = new CommentConnection(sl.get(0), Double.parseDouble(sl.get(2)));
						for(Vertex v : e.vertices())  
						{
							if(v.getLabel() == sl.get(3) || v.getLabel() == sl.get(4))
							{
								ver.add(v);
							}
						}
						e.addVertices(ver);
						for(Vertex v : e.vertices())
						{
							if(v.getLabel() == sl.get(3))
							{
								e.sourceVertex();
							}
							else if(v.getLabel() == sl.get(4))
							{
								e.targetVertex();
							}
						}
					}
					else if(sl.get(1) == "ForwardConnection")
					{				
						List<Vertex> ver = new ArrayList<>();
						e = new ForwardConnection(sl.get(0), Double.parseDouble(sl.get(2)));
						for(Vertex v : e.vertices())  
						{
							if(v.getLabel() == sl.get(3) || v.getLabel() == sl.get(4))
							{
								ver.add(v);
							}
						}
						e.addVertices(ver);
						for(Vertex v : e.vertices())
						{
							if(v.getLabel() == sl.get(3))
							{
								e.sourceVertex();
							}
							else if(v.getLabel() == sl.get(4))
							{
								e.targetVertex();
							}
						}
					}
					else if(sl.get(1) == "FriendConnection")
					{				
						List<Vertex> ver = new ArrayList<>();
						e = new FriendConnection(sl.get(0), Double.parseDouble(sl.get(2)));
						for(Vertex v : e.vertices())  
						{
							if(v.getLabel() == sl.get(3) || v.getLabel() == sl.get(4))
							{
								ver.add(v);
							}
						}
						e.addVertices(ver);
						for(Vertex v : e.vertices())
						{
							if(v.getLabel() == sl.get(3))
							{
								e.sourceVertex();
							}
							else if(v.getLabel() == sl.get(4))
							{
								e.targetVertex();
							}
						}
					}
					else if(sl.get(1) == "NetworkConnection")
					{				
						List<Vertex> ver = new ArrayList<>();
						e = new NetworkConnection(sl.get(0), Double.parseDouble(sl.get(2)));
						for(Vertex v : e.vertices())  
						{
							if(v.getLabel() == sl.get(3) || v.getLabel() == sl.get(4))
							{
								ver.add(v);
							}
						}
						e.addVertices(ver);
						for(Vertex v : e.vertices())
						{
							if(v.getLabel() == sl.get(3) || v.getLabel() == sl.get(4))
							{
								e.sourceVertex();
							}
							else if(v.getLabel() == sl.get(4) || v.getLabel() == sl.get(3))
							{
								e.targetVertex();
							}
						}
					}
					else if(sl.get(1) == "MovieActorRelation")
					{				
						List<Vertex> ver = new ArrayList<>();
						e = new MovieActorRelation(sl.get(0), Double.parseDouble(sl.get(2)));
						for(Vertex v : e.vertices())  
						{
							if(v.getLabel() == sl.get(3) || v.getLabel() == sl.get(4))
							{
								ver.add(v);
							}
						}
						e.addVertices(ver);
						for(Vertex v : e.vertices())
						{
							if(v.getLabel() == sl.get(3))
							{
								e.sourceVertex();
							}
							else if(v.getLabel() == sl.get(4))
							{
								e.targetVertex();
							}
						}
					}
					else if(sl.get(1) == "MovieDirectorRelation")
					{				
						List<Vertex> ver = new ArrayList<>();
						e = new MovieDirectorRelation(sl.get(0), Double.parseDouble(sl.get(2)));
						for(Vertex v : e.vertices())  
						{
							if(v.getLabel() == sl.get(3) || v.getLabel() == sl.get(4))
							{
								ver.add(v);
							}
						}
						e.addVertices(ver);
						for(Vertex v : e.vertices())
						{
							if(v.getLabel() == sl.get(3) || v.getLabel() == sl.get(4))
							{
								e.sourceVertex();
							}
							else if(v.getLabel() == sl.get(4) || v.getLabel() == sl.get(3))
							{
								e.targetVertex();
							}
						}
					}
				}
			}
		}
		while(input.hasNextLine())
		{
			List<Vertex> ver = new ArrayList<>();
			String line = input.nextLine();
			String px = "([\\s\\S]*)";
			String pattern = "(\\w+)(\\=)" + px;
			Pattern pn = Pattern.compile(pattern);
			Matcher m = pn.matcher(line);
			if(m.find())
			{
				if(m.group(1) != "HyperEdge")
				{
					break;
				}
				else
				{
					List<String> sl = new ArrayList<>();
					String p = "\"(\\w+)\"";
					Pattern pa = Pattern.compile(p);
					Matcher m0 = pa.matcher(px);
					while(m0.find())
					{
						sl.add(m0.group(1));
					}
					Edge e;
					e = new SameMovieHyperEdge(sl.get(0), Double.parseDouble(sl.get(2)));
					String s[] = sl.get(2).split(",");
					for(Vertex v : e.vertices())  
					{
						if(v.getLabel() == s[0] || v.getLabel() == s[1])
						{
							ver.add(v);
						}
					}
					e.addVertices(ver);
					for(Vertex v : e.vertices())
					{
						if(v.getLabel() == s[0] || v.getLabel() == s[1])
						{
							e.sourceVertex();
						}
						else if(v.getLabel() == s[0] || v.getLabel() == s[1])
						{
							e.targetVertex();
						}
					}
				}
			}
		}
		input.close();
		return true;
	}
}
