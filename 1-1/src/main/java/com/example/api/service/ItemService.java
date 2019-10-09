package com.example.api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.data.Item;
import com.example.api.repository.ItemRepository;

@Service
@Transactional
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	/**
	 * データ全件取得
	 * 
	 * @return List<Item>
	 */
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	/**
	 * データ（ID指定）取得
	 * 
	 * @param id
	 * @return Optional<Item>
	 */
	public Optional<Item> findItem(Integer id) {
		return itemRepository.findById(id);
	}

	/**
	 * データ作成
	 * 
	 * @param items
	 * @return List<Item>
	 */
	public List<Item> create(List<Item> items) {
		return itemRepository.saveAll(items);
	}

	/**
	 * データ更新（ID指定）
	 * 
	 * @param item
	 * @return Item
	 */
	public Item update(Item item) {
		return itemRepository.save(item);
	}

	/**
	 * データ削除（ID指定）
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		itemRepository.deleteById(id);
	}

}
