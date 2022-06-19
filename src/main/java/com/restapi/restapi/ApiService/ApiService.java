package com.restapi.restapi.ApiService;

import java.util.*;

import com.restapi.restapi.entities.Api;


public interface ApiService {
	public List<Api> getApis();
	public Api getApi(long apiId);
	public Api addApi(Api api);
	public Api updateApi(Api api);
	public void deleteApi(long apiId);
}
