package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.TShirt;

public interface ProductSearchDao {

	List<TShirt> search(String color, String size, String gender, String outputPreference);
}
