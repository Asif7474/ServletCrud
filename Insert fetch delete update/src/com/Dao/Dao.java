package com.Dao;

import java.util.List;

import com.Bean.Bean;

public interface Dao {

	public void insert(Bean b);
	public List<Bean>fetch();
	public void delete(Bean b);
	public void update(Bean b) ;
}
