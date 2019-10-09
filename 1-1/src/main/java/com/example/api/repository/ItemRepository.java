package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.data.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}