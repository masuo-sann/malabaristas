package com.malabaristas.interfaces;

import java.io.IOException;

import com.malabaristas.dto.AbstractDto;
import com.malabaristas.model.AbstractModel;

public interface ApiActionInterface<M extends AbstractModel> {
	public abstract void setUp();  // req　から Dtoを作成
	public abstract void execute() throws IOException;  // ApiBaseActionから呼ばれる。
	public abstract String readRequestBody();  // POSTされてきたrequestBodyを読み込む
	public abstract AbstractDto<M> createJsonObj();  // JSONを取得してJSONObjectにする。
}
