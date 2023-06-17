package com.edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jdt.internal.compiler.ast.CompactConstructorDeclaration;

public class Count {

	public String execute(String book) {
		book = book.toLowerCase();
		String[] str = book.split(" ");
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length; i++) {
			map.put(str[i], map.getOrDefault(str[i], 0) + 1);
		}
		List<String> list= new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(map.get(o2)==map.get(o1))
					return o1.compareTo(o2);
				return map.get(o2)-map.get(o1);
			}
		});
		
		return list.get(0);
	}

	public static void main(String[] args) {
		String book1 = "Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. ";
		String book2 = "Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 = "I like cat. I like cat. I like cat. ";
		Count c = new Count();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));

	}

}
