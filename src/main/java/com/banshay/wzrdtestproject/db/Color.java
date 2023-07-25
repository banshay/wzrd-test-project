package com.banshay.wzrdtestproject.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("color")
public record Color(@Id Long id, String color) {

}
