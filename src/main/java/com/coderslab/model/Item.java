/**
 * 
 */
package com.coderslab.model;

/**
 * @author cyclingbd007
 *
 */
public class Item {
	private Long id;
	private String description;
	private ItemType itemType;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(Long id, String description, ItemType itemType) {
		super();
		this.id = id;
		this.description = description;
		this.itemType = itemType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", description=" + description + ", itemType=" + itemType + "]";
	}

}
