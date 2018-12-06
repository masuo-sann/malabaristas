package com.malabaristas.dto;

import com.malabaristas.model.AbstractModel;

public abstract class AbstractDto<M extends AbstractModel> {
	public abstract M toModel(M model);
}