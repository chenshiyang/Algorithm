package test.indeed2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * Description: 
 */
public class Main2 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			String s= reader.nextLine();
			Map<String, Integer> map = new HashMap<String, Integer>();
			List<Node> list = new ArrayList<Node>();
			for(int i = 0; i < s.length() - 1; i ++) {
				String cs = "" + s.charAt(i) + s.charAt(i + 1);
				if(!map.containsKey(cs)) {
					map.put(cs, 1);
				} else {
					int count = map.get(cs);
					map.put(cs, count + 1);
				}
			}
			for(String ss : map.keySet()) {
				Node node = new Node(ss);
				node.count = map.get(ss);
				list.add(node);
			}
			Collections.sort(list);
			for(Node node : list) {
				System.out.println(node.s);
			}
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		Main2.solve();
	}
}

class Node implements Comparable<Node>{
	String s;
	int count;
	
	Node(String s) {
		this.s = s;
		count  = 1;
	}
	
	@Override
	public int hashCode() {
		return s.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return s.equals(((Node)obj).s);
	}
	
	@Override
	public int compareTo(Node o) {
		if(this.count != o.count) {
			return o.count - this.count;
		} else {
			if(this.s.charAt(0) != o.s.charAt(0)) {
				return this.s.charAt(0) - o.s.charAt(0);
			} else {
				return this.s.charAt(1) - o.s.charAt(1);
			}
		}
	}
}