package com.entities;

import java.util.Hashtable;
import java.util.Optional;
public class Things {
	public enum ThingNames{Sword, Knight1, Knight2, Queen, King, Witch, Bandit, Bread, Coin, GreenPotion, OpenScroll, Farm, SpookyPath, City, Ruins, ForestPath, Tavern, Courtyard, CastleBedroom, DiningRoom, Dungeon} 
	private static Hashtable<ThingNames, IThing<?>> list=new Hashtable<>();
	public static boolean add(ThingNames name, IThing<?> thing) {
		if(list.containsKey(name))
			return false;
		list.put(name, thing);
		return true;
	}
	
	public static Optional<IThing<?>> get(ThingNames name) {
		return Optional.ofNullable(list.get(name));
	}
}
