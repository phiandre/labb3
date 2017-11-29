import java.util.*;

public class Graph {
	private Map<String, ArrayList<Pair<String,Integer>>> mapRep;
	//private ArrayList< LinkedList< Pair<String,Integer> > > listRep;
	//private HashMap<String,APrioMap<String,Integer>> hashRep; //= new HashMap<String,APrioMap<String,Integer>>()
	
    public Graph() { 
		//listRep = new ArrayList< LinkedList< Pair<String,Integer> > >();
		//hashRep = new HashMap<String,APrioMap<String,Integer>>();
		//prioMapRep = new APrioMap<String, LinkedList< Pair<String,Integer> > >;
		mapRep = new HashMap<String, ArrayList<Pair<String,Integer>>>();
	}
    
    public void addVertice(String label){
		/*
		LinkedList<Pair> noNeighbors = new LinkedList<Pair>();
		noNeighbors.add(new Pair(label,0)); //ditsanse 0 from it slef
		listRep.add(noNeighbors);*/
		
		//hashRep.put(label,new APrioMap<String,Integer>());
		
		//add the new vertice and an arrayList for the neighbors.
		mapRep.put(label, new ArrayList<Pair<String,Integer>>());
	}
    
    public void addEdge(String node1, String node2, int dist){ 
		/*APrioMap A = hashRep.get(node1);
		APrioMap B = hashRep.get(node2);
		A.put(node2,dist);
		B.put(node1,dist);
		hashRep.put(node1,A);
		hashRep.put(node2,B);*/
		
		/*The graph is undirected, so should add a neighbor to both
		 * node1 and node2.
		 */
		ArrayList<Pair<String,Integer>> neighbors1 = mapRep.get(node1);
		ArrayList<Pair<String,Integer>> neighbors2 = mapRep.get(node2);
		neighbors1.add(new Pair(node2,dist));
		neighbors2.add(new Pair(node1,dist));
	}
    
    public static class Path {
        public int totalDist;
        public List<String> vertices;
        public Path(int totalDist, List<String> vertices) {
            this.totalDist = totalDist;
            this.vertices = vertices;
        }

        @Override
        public String toString() {
            return "totalDist: " + totalDist + ", vertices: " + vertices.toString();
        }
    }
    
    public Path shortestPath(String start, String dest){ 
		boolean[] known = new boolean[hashRep.size()];
		int[] dv = new int[hashRep.size()];
		
		APrioMap<String,Integer> q = new APrioMap<String,Integer>();
		q.put(start,0);
		
		for(int i=0; i<hashRep.size(); i++){
			known[i] = false;
			dv[i] = Integer.MAX_VALUE;
		}
		dv[0] = 0;
		
		while(known.Cast<bool>().Contains(false))
		
	}
}
