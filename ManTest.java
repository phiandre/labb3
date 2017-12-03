
public class ManTest{
	public static void main(String[] args){
		Graph g = new Graph();
	g.addVertice("V0");
	g.addVertice("V1");
	g.addVertice("V2");
	g.addVertice("V3");
	g.addVertice("V4");
	g.addVertice("V5");
	g.addVertice("V6");
	g.addEdge("V3", "V1", 5);
	g.addEdge("V1", "V4", 3);
	g.addEdge("V2", "V3", 4);
	g.addEdge("V5", "V2", 2);
	g.addEdge("V5", "V0", 0);
	g.addEdge("V2", "V0", 3);
	g.addEdge("V3", "V0", 3);
	g.addEdge("V2", "V4", 4);
	System.out.println(g.shortestPath("V0", "V1"));  // result: totalDist: 9, vertices: [V0, V5, V2, V4, V1]
	}
}
