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
		Set<String> known = new HashSet<String>();
		
		//int[] dv = new int[mapRep.size()];
		Map<String,Integer> dv = new HashMap<String,Integer>();
		
		APrioMap<String,Integer> q = new APrioMap<String,Integer>();
		q.put(start,0);
	
		
        List<String> vertices = new ArrayList<String>();
        Map<String,String> previousNode=new HashMap<>();
        
		for(String key : mapRep.keySet()){
			dv.put(key,Integer.MAX_VALUE);
			previousNode.put(key,null);
		}
		//known.add(start);
		dv.put(start,0);
		//vertices.add(start);
        //while(known.Cast<bool>().Contains(false)){
        int count = 0;
        while(q.peek()!=null){
			count++;
			/*
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			System.out.println("Run no. " +count + "---------------------------------");
			System.out.println("Known indices");
			Iterator<String> it = known.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
			for(String key : dv.keySet()){
				System.out.println("Node: " + key +" ---- Distance: " + dv.get(key));
			}
			
			System.out.println("--------------------");
			System.out.println("PrioQueue");
			for(String key : q.map.keySet()){
				System.out.println("Node: " + key +" ---- Distance: " + q.map.get(key));
			}
			System.out.println("------------------------");*/
			
			Pair<String,Integer> v = q.poll();
			//System.out.println("v = " + v.a);
			//System.out.println("v.b = " + v.b);
			
			
			
			//System.out.println(v.a);
			//System.out.println(!known.contains(v.a));
			if( !known.contains(v.a) ){
				known.add(v.a);
				//System.out.println(v.a);
				ArrayList<Pair<String,Integer>> neighbors = mapRep.get(v.a);
				for(int i=0; i<neighbors.size(); i++){
					
					Pair<String,Integer> v_prim = neighbors.get(i);
					
					//System.out.println("v_prim =" +v_prim.a);
					
					if( (!known.contains(v_prim.a)) && (dv.get(v_prim.a) > dv.get(v.a)+ v_prim.b ) ){
						dv.put(v_prim.a, dv.get(v.a)+ v_prim.b );
						previousNode.put(v_prim.a, v.a);
						if(q.map.containsKey(v_prim.a))
							q.map.remove(v_prim.a);
						q.put(v_prim.a, dv.get(v_prim.a)); 
						//vertices.add(v.a);
					}
				}
			}
        }
        
		//System.out.println(known.contains("V4"));
        
        //System.out.println(count);
        for(String key : previousNode.keySet() ){
			//System.out.println("Node: " + key +" ---- Previous Node: "+ previousNode.get(key));
		}
        
        String yee=dest;
        while(previousNode.get(yee)!=null){
				//System.out.println(previousNode.get(yee));
				vertices.add(yee);
				yee=previousNode.get(yee);
		}
		vertices.add(start);
        Collections.reverse(vertices);
		
        if( dv.get(dest) == Integer.MAX_VALUE ){ 
			//System.out.println(Arrays.toString(vertices.toArray()));
			//System.out.println("cukc");
			return null;
		}
		int totDist = dv.get(dest);
		
		
		return new Path(totDist, vertices );
		
	}
}
