import java.util.*; // can not only use scanner 
public class Graph {
	private class Vertex
	{
		
		protected String name; // Must be unique*
		LinkedList<Edge>neighbors;
		public Vertex(String aname) {
			name = aname;
			neighbors = new LinkedList<Edge>();
		}
		
	}
	private class Edge
	{
		Vertex toVert;
		double weight;
		public Edge(Vertex av, double aw) {
			toVert = av;
			weight = aw;
		}
	}
	private Vertex origin; // this is where we start form, and its arb
	private LinkedList<Vertex> vertices;
	public Graph()
	{
		origin = null;
		vertices = new LinkedList<Vertex>();	
	}
	
	public void addVertex(String aname)
	{
	if(isVertContained(aname))
		return; // Found a Duplicate
	Vertex v = new Vertex(aname);
	vertices.add(v);
	if(origin == null)
		origin = v;
	
	}
	private boolean isVertContained(String aname) {
		for(Vertex v : vertices)
			if(v.name.equals(aname))
				return true;
		return false;
	
		//return getVert(aname) !=null;
	}
	public void addEdge(String fromVert, String toVert, double weight) 
	{
		Vertex v1 = getVert(fromVert);
		Vertex v2 = getVert(toVert);
		if(v1 == null || v2 == null)
			return; // one or both vertices were not found
		v1.neighbors.add(new Edge(v2, weight));
		
	}
	private Vertex getVert(String aname)
	{
		for(Vertex v :vertices)
			if(v.name.equals(aname))
				return v;
		return null;
	}
	private LinkedList<Vertex> markedVerts = new LinkedList<Vertex>();
	public void printDFS() {
		markedVerts.clear();
		printDFS(origin);
	}
	private void printDFS(Vertex v)
	{
		if(markedVerts.contains(v))
			return; // can not travel to a marked vertex
		System.out.println(v.name);
		markedVerts.add(v);
		for(Edge e : v.neighbors)
			printDFS(e.toVert);
	}
	private Queue<Vertex> vQ = new LinkedList<Vertex>();
	public void printBFS() {
		markedVerts.clear();
		System.out.println(origin.name);
		vQ.add(origin);
		while(!vQ.isEmpty())
		{
			Vertex v =vQ.remove();
			markedVerts.add(v);
			for(Edge e : v.neighbors)
			{
				if(!vQ.contains(e.toVert) && !markedVerts.contains(v))
				{
					System.out.println(e.toVert.name);
					vQ.add(e.toVert);
					
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
