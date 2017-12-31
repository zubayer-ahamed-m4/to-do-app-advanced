/**
 * 
 */
package com.coderslab.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.coderslab.exception.TodoException;
import com.coderslab.model.Item;
import com.coderslab.model.ItemType;

/**
 * @author cyclingbd007
 *
 */
@Service
public class TodoServices {

	private List<Item> items = new ArrayList<>();

	public void addItem(Item item) throws TodoException {
		if (items.stream().filter(r -> r.getId().equals(item.getId())).count() > 0) {
			throw new TodoException("Item already exist");
		}
		if (item.getId() == null) {
			item.setId(new Random().nextLong());
		}
		item.setItemType(ItemType.TODO);
		items.add(item);
	}

	public void updateItem(Item item) throws TodoException {
		List<Item> list = items.stream().filter(r -> r.getId().equals(item.getId())).collect(Collectors.toList());
		if (list.isEmpty()) {
			throw new TodoException("No items found for update");
		}
		items.remove(list.get(0));
		items.add(item);
	}

	public void deleteItem(Item item) throws TodoException {
		List<Item> list = items.stream().filter(r -> r.getId().equals(item.getId())).collect(Collectors.toList());
		if (list.isEmpty()) {
			throw new TodoException("No items found for delete");
		}
		items.remove(list.get(0));
	}

	public Item getItemById(long id) {
		return items.stream().filter(r -> r.getId().equals(id)).collect(Collectors.toList()).get(0);
	}

	public List<Item> getItemsByType(ItemType type) {
		return items.stream().filter(r -> r.getItemType().equals(type)).collect(Collectors.toList());
	}

	public List<Item> getItems() {
		return items;
	}

}
