package test.didi;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Didi coding test 1. greedy + treemap
 * 
 * @author csy
 *
 */
public class Main1 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		
		while(reader.hasNext()) {
			String s = reader.nextLine();
			String[] sarry = s.split(" ");
			int n = Integer.parseInt(sarry[0]);
			int m = Integer.parseInt(sarry[1]);
			//read table
			TreeMap<Integer, Integer> tables = new TreeMap<>();
			s = reader.nextLine();
			sarry = s.split(" ");
			for(int i = 0; i < n; i ++) {
				int size = Integer.parseInt(sarry[i]);
				if(tables.containsKey(size)) {
					tables.put(size, 1 + tables.get(size));
				} else {
					tables.put(size, 1);
				}
			}
			
			//read clients
			Client[] clients = new Client[m];
			for(int i = 0; i < m; i ++) {
				s = reader.nextLine();
				sarry = s.split(" ");
				int count = Integer.parseInt(sarry[0]);
				int total = Integer.parseInt(sarry[1]);
				clients[i] = new Client(count, total);
			}
			Arrays.sort(clients);
			
			long sum = 0;
			for(int i = 0; i < clients.length; i ++) {
				Entry<Integer, Integer> table = tables.ceilingEntry(clients[i].count);
				if(null == table) {
					continue;
				}
				sum += clients[i].total;
				if(table.getValue() == 1) {
					tables.remove(table.getKey());
				} else {
					tables.put(table.getKey(), table.getValue() - 1);
				}
			}
			System.out.println(sum);
		}
		reader.close();
	}
	
	public static void main(String[] args) {
		Main1.solve();
	}
}

class Client implements Comparable<Client> {
	public int count;
	public int total;
	
	public Client() {}
	
	public Client(int count, int total) {
		this.count = count;
		this.total = total;
	}
	
	@Override
	public int compareTo(Client o) {
		if(this.total != o.total) {
			return o.total - this.total;//reverse
		} else {
			return this.count - o.count;//ascend
		}
	}
}

