package com.malabaristas.interfaces;

import com.malabaristas.dto.AbstractDto;

public interface ApiActionInterface {
	public abstract void setUp();  // req と respをいい感じにする。
	public abstract void execute();  // ApiBaseActionから呼ばれる。
	public abstract String readRequestBody();  // POSTされてきたrequestBodyを読み込む
	public abstract AbstractDto createJsonObj();  // JSONを取得してJSONObjectにする。
}
