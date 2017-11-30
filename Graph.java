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
		mapRep.put(node1, neighbors1);
		mapRep.put(node2, neighbors2);
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
		//boolean[] known = new boolean[mapRep.size()];
		Map<String,Boolean> known = new HashMap<String,Boolean>();
		
		//int[] dv = new int[mapRep.size()];
		Map<String,Integer> dv = new HashMap<String,Integer>();
		
		APrioMap<String,Integer> q = new APrioMap<String,Integer>();
		q.put(start,0);
	
		
        List<String> vertices = new ArrayList<String>();
        
		for(String key : mapRep.keySet()){
			known.put(key,false);
			dv.put(key,Integer.MAX_VALUE);
		}
		known.put(start,true);
		dv.put(start,0);
		vertices.add(start);
		int totDist = 0;
        //while(known.Cast<bool>().Contains(false)){
        while(q.peek()!=null){
			Pair<String,Integer> v = q.poll();
			if( known.get(v.a) ){
				known.put(v.a,true);
				ArrayList<Pair<String,Integer>> neighbors = mapRep.get(v.a);
				for(int i=0; i<neighbors.size(); i++){
					
					System.out.println("Hej");
					Pair<String,Integer> v_prim = neighbors.get(i);
					System.out.println(known.get(v_prim.a) == false);
					System.out.println(dv.get(v_prim.a) > dv.get(v.a)+ v_prim.b);
					if( (known.get(v_prim.a)==false) && (dv.get(v_prim.a) > dv.get(v.a)+ v_prim.b ) ){
						dv.put(v_prim.a, dv.get(v.a)+ v_prim.b  );
						vertices.add(v_prim.a);
						totDist = totDist + v_prim.b;
						q.put(v_prim.a, dv.get(v_prim.a)); 
					}
				}
			}
        }
        if(known.get(dest)==false){ return null;}
		//int totDist = dv.get(dest);
		return new Path(totDist, vertices);
		
	}
}
