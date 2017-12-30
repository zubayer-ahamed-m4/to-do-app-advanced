package com.coderslab;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coderslab.exception.TodoException;
import com.coderslab.model.Item;
import com.coderslab.model.ItemType;
import com.coderslab.services.TodoServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoAppAdvancedApplicationTests {

	@Autowired private TodoServices todoServices;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void addItemIntoList() throws TodoException {
		Item item = new Item();
		item.setDescription("item 1");
		todoServices.addItem(item);
	}
	
	@Test
	public void getItemsByItemType() {
		System.out.println(todoServices.getItemsByType(ItemType.TODO).size());
	}
	
	@Test
	public void getAllItems() {
		long count = todoServices.getItems().size();
		System.out.println(count);
	}

}
