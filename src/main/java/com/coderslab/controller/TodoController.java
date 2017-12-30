package com.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderslab.exception.TodoException;
import com.coderslab.model.Item;
import com.coderslab.model.ItemType;
import com.coderslab.services.TodoServices;

/**
 * @author cyclingbd007
 *
 */
@Controller
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	TodoServices todoServices;

	@RequestMapping
	public String loadTodoPage(Model model) throws TodoException {
		return editItem(null, model);
	}

	@RequestMapping(value = "/{id}")
	public String editItem(@PathVariable("id") Long id, Model model) throws TodoException {
		if (id == null) {
			model.addAttribute("item", new Item());
		} else {
			model.addAttribute("item", todoServices.getItemById(id));
		}
		model.addAttribute("todoItems", todoServices.getItemsByType(ItemType.TODO));
		model.addAttribute("inProgressItems", todoServices.getItemsByType(ItemType.INPROGRESS));
		model.addAttribute("doneItems", todoServices.getItemsByType(ItemType.DONE));
		return "views/todo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveTodoItem(@ModelAttribute("item") @Valid Item item, BindingResult result, Model model)
			throws TodoException {
		if (result.hasErrors()) {
			model.addAttribute("todoItems", todoServices.getItemsByType(ItemType.TODO));
			model.addAttribute("inProgressItems", todoServices.getItemsByType(ItemType.INPROGRESS));
			model.addAttribute("doneItems", todoServices.getItemsByType(ItemType.DONE));
			return "views/todo";
		}
		if (item.getId() == null) {
			item.setItemType(ItemType.TODO);
			todoServices.addItem(item);
		} else {
			todoServices.updateItem(item);
		}
		return "redirect:/todo";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteItem(@PathVariable("id") long id) throws TodoException {
		todoServices.deleteItem(todoServices.getItemById(id));
		return "redirect:/todo";
	}

	@RequestMapping(value = "/changeItemType", headers = "Accept=application/json")
	public @ResponseBody Item changeItemType(@RequestBody Item item) throws TodoException {
		Item i = todoServices.getItemById(item.getId());
		i.setItemType(item.getItemType());
		todoServices.updateItem(i);
		return item;
	}

}
