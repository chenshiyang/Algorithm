package test.ms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Description: 
 */
public class Main2 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while(reader.hasNext()) {
			int N = Integer.parseInt(reader.nextLine());
			String s = reader.nextLine();
			Node[] nodes = new Node[N];
			Map<Character, Node> map = new HashMap<Character, Node>();
			for(int i = 0; i < s.length(); i ++) {
				if(!map.containsKey(s.charAt(i))) {
					map.put(s.charAt(i), new Node(s.charAt(i)));
				}
				Node node = map.get(s.charAt(i));
				nodes[i] = node;
				if(i > 0) {
					nodes[i].leftneighbor.add(nodes[i - 1]);
					nodes[i - 1].rightneighbor.add(nodes[i]);
				}
//				if(i < s.length() - 1) {
//					nodes[i].neighbor.add(nodes[i + 1]);
//				}
			}
			int M = Integer.parseInt(reader.nextLine());
//			Map<Character, > rule = new HashMap<Character, >
			String[] rules = new String[M];
			for(int i = 0; i < rules.length; i ++) {
				rules[i] = reader.nextLine();
			}
			
			int min = s.length();
			int satisfy = 0;
			int currentDelete = 0;
			boolean[] deleted = new boolean[26];
			min = deal(map, nodes, rules, deleted, min, satisfy, currentDelete);
			System.out.println(min);
		}
		reader.close();
	}
	
	public static int deal(Map<Character, Node> map, Node[] nodes, String[] rules, boolean[] deleted, int min, int satisfy, int currentDelete) {
		if(satisfy == rules.length) {
			min = Math.min(min, currentDelete);
			return min;
		} else {
			String rule = rules[satisfy];
			//now we need to satisfy this rule
			//if no this kind of adjacent
			Node node = map.get(rule.charAt(0));
			if(!node.leftneighbor.contains(map.get(rule.charAt(1)))) {
				if(!node.rightneighbor.contains(map.get(rule.charAt(1)))) {
					return deal(map, nodes, rules, deleted, min, satisfy + 1, currentDelete);
				}
			}
//			if(!map.get(rule.charAt(0)).leftneighbor.contains(rule.charAt(1)) && ! map.get(rule.charAt(0)).rightneighbor.contains(rule.charAt(1))) {
//				satisfy ++;
//				return deal(map, nodes, rules, deleted, min, satisfy, currentDelete);
//			}
			//else if one of the char has been delete
			if(deleted[rule.charAt(0) - 'a'] || deleted[rule.charAt(1) - 'a']) {
//				satisfy ++;
				return deal(map, nodes, rules, deleted, min, satisfy + 1, currentDelete);
			}// need to delete one char 
			else {
//				satisfy ++;
				currentDelete ++;
				//delete first
				deleted[rule.charAt(0) - 'a'] = true;
				//update neighbors
				for(int i = 0; i < nodes.length; i ++) {
					if(deleted[nodes[i].val - 'a']) {
						continue;
					}
					if(nodes[i].leftneighbor.contains(map.get(rule.charAt(0)))) {
						nodes[i].leftneighbor.remove(map.get(rule.charAt(0)));
						nodes[i].time = rule.charAt(0);
						nodes[i].old = '(';
						for(int j = i - 1; j >= 0; j --) {
							if(!deleted[nodes[j].val - 'a']) {
								nodes[i].leftneighbor.add(nodes[j]);
								nodes[i].old = nodes[j].val;
								break;
							}
						}
					}
					if(nodes[i].rightneighbor.contains(map.get(rule.charAt(0)))) {
						nodes[i].rightneighbor.remove(map.get(rule.charAt(0)));
						nodes[i].old2 = '(';
						for(int j = i + 1; j < nodes.length; j ++) {
							if(!deleted[nodes[j].val - 'a']) {
								nodes[i].rightneighbor.add(nodes[j]);
								nodes[i].old2 = nodes[j].val;
								break;
							}
						}
					}
				}
				min = Math.min(min, deal(map, nodes, rules, deleted, min, satisfy + 1, currentDelete));
				
				//recover
				for(int i = 0; i < nodes.length; i ++) {
					if(nodes[i].time == rule.charAt(0)) {
						nodes[i].leftneighbor.add(map.get(rule.charAt(0)));
						if(nodes[i].old != '(') {
							nodes[i].leftneighbor.remove(map.get(nodes[i].old));
						}
					}
//					if(nodes[i].old != '*') {
//						if(nodes[i].old != (rule.charAt(0) - 32))
//						nodes[i].leftneighbor.remove(map.get(rule.charAt(0)));
//						nodes[i].leftneighbor.add(map.get(nodes[i].old));
//						nodes[i].old = '*';
//					}
//					else if(nodes[i].old == '(') {
//						nodes[i].leftneighbor.add(map.get(rule.charAt(0)));
//					}
					if(nodes[i].time == rule.charAt(0)) {
						nodes[i].rightneighbor.add(map.get(rule.charAt(0)));
						if(nodes[i].old2 != '(') {
							nodes[i].rightneighbor.remove(map.get(nodes[i].old2));
							nodes[i].old2 = '*';
						}
					}
//					if(nodes[i].old2 != '*') {
//						if(nodes[i].old != (rule.charAt(0) - 32))
//						nodes[i].rightneighbor.remove(map.get(rule.charAt(1)));
//						nodes[i].rightneighbor.add(map.get(nodes[i].old2));
//						nodes[i].old2 = '*';
//					}
//					else if(nodes[i].old2 == '(') {
//						nodes[i].rightneighbor.add(map.get(rule.charAt(1)));
//					}
				}
				//delete second
				deleted[rule.charAt(0) - 'a'] = false;
				deleted[rule.charAt(1) - 'a'] = true;
				for(int i = 0; i < nodes.length; i ++) {
					if(deleted[nodes[i].val - 'a']) {
						continue;
					}
					if(nodes[i].leftneighbor.contains(map.get(rule.charAt(1)))) {
						nodes[i].leftneighbor.remove(map.get(rule.charAt(1)));
						for(int j = i - 1; j >= 0; j --) {
							if(!deleted[nodes[j].val - 'a']) {
								nodes[i].leftneighbor.add(nodes[j]);
								break;
							}
						}
					}
					if(nodes[i].rightneighbor.contains(map.get(rule.charAt(1)))) {
						nodes[i].rightneighbor.remove(map.get(rule.charAt(1)));
						for(int j = i + 1; j < nodes.length; j ++) {
							if(!deleted[nodes[j].val - 'a']) {
								nodes[i].rightneighbor.add(nodes[j]);
								break;
							}
						}
					}
				}
				min = Math.min(min, deal(map, nodes, rules, deleted, min, satisfy + 1, currentDelete));
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		Main2.solve();
	}
}

class Node {
	char val;
	char old = '*';
	char old2 = '*';
	char time = ' ';//the char when delete
	Set<Node> leftneighbor = new HashSet<>();
	Set<Node> rightneighbor = new HashSet<>();
	
	public Node() {}
	
	public Node(char val) {
		this.val = val;
	}
	
//	public Node(Node n1, Node n2) {
//		neighbor.add(n1);
//		neighbor.add(n2);
//	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.val + "";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.val;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.val == ((Node)obj).val;
	}
	
}
