package com.malabaristas.dao;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.malabaristas.dto.AbstractDto;
import com.malabaristas.model.AbstractModel;

public abstract class AbstractDao<M extends AbstractModel> {

	/*
	 * CREATE
	 */
	public void add(M model) {
		Datastore.put(model);
	}

	/*
	 * READ
	 */
	/**
	 * @sample return Datastore.query(Abstract_META).asList();
	 * @return
	 */
	public abstract List<M> list();

	/**
	 * @sample
	 * List<M> modelList = list();
		List<AbstractDto<M>> dtoList = new ArrayList<>();
		for(M model: modelList) {
			dtoList.add(model.toDto());
		}
		return dtoList;
	 * @return
	 */
	public abstract List<? extends AbstractDto<M>> dtoList();

	/*
	 * DELETE
	 */
	public void delete(Key... keys) {
		Datastore.delete(keys);
	}

	public void deleteByStrKey(String strKey) {
		delete(Datastore.stringToKey(strKey));
	}

	/*
	 * OTHERS
	 */
	/**
	 * @sample return Datastore.get(AbstractModel.class, key);
	 * @param key
	 * @return
	 */
	public abstract M selectByKey(Key key);

	public M selectByStrKey(String strKey) {
		return selectByKey(Datastore.stringToKey(strKey));
	}
}
