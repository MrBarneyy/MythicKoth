package main.hu.mrbarneyy.mythickoth.mcore.utils.interfaces;

import java.util.Collection;

@FunctionalInterface
public interface CollectionConsumer<T> {

	Collection<String> accept(T t);
	
}
