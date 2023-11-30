package com.entities;

import java.util.Hashtable;
import java.util.Optional;
public class Things {
	public enum ThingNames{Player, King, Peasant, Queen, Courtyard, Cottage, CastleBedroom, Dungeon, Elder, CastleCrossroads, Knight, Farm, Ruins, Witch, Husband, OpenScroll, AlchemyShop, City, ForestPath, Blacksmith, Executioner4, Executioner5} 
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
