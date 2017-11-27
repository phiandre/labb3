<<<<<<< HEAD

import java.util.Comparator;
import java.util.HashMap;



=======
import java.util.*;
>>>>>>> ecb081ceb6eb871ed3d9c0b0ae7a107d6dca3709
public class APrioMap<K,V extends Comparable<? super V>> implements PrioMap<K,V>{
	private PrioQueue<Pair> heapRep;
	
	
	private HashMap<K,V> map; 	
	
	public APrioMap(){
		heapRep = new BinHeap(new PairComparator());
		map = new HashMap<K,V>();
	}
	
	public void put(K k, V v){
		/* CHECK IF KEY ALREADY EXISTS*/
		if(map.containsKey(k)){
			V value = map.remove(k);
			heapRep.remove(new Pair(k,value));
		}
			
		/* Add the element to both map and heap */
		Pair<K,V> newPair = new Pair(k,v);
		heapRep.add(newPair);
		map.put(k,v);
	}
	
	public V get(K k){
		return map.get(k);
	}
	
	public Pair<K, V> peek(){
		return heapRep.peek();
	}
	
	public Pair<K, V> poll(){
		/* Element must be removed from both map and heap */
		Pair<K,V> tmp = heapRep.poll();
		if(tmp!=null)
			map.remove(tmp.a);
		return tmp;
	}

<<<<<<< HEAD
	
	
	
	private class PairComparator implements Comparator<Pair<K,V>> {
=======
       
	private class PairComparator<Pair<K,V>> {
	 
>>>>>>> ecb081ceb6eb871ed3d9c0b0ae7a107d6dca3709
		@Override
		public int compare(Pair<K,V> p1, Pair<K,V> p2){
			return (p1.b).compareTo(p2.b);
		}
	}
}
