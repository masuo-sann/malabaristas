package com.malabaristas.model;

import com.malabaristas.dto.AbstractDto;

public abstract class AbstractModel {
	@SuppressWarnings("rawtypes")
	public abstract AbstractDto toDto();
}
