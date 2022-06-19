package com.restapi.restapi.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.restapi.dao.ApiDao;
import com.restapi.restapi.entities.Api;

@Service
public class ApiServiceImpl implements ApiService{
	List<Api> list;
	public ApiServiceImpl() {
		list= new ArrayList<>();
		list.add(new Api(222848, "MASTERCARD", "HDFC BANK" , "DEBIT", "PREPAID", "INDIA", "IN", "IND" ,"devd", "3232", "sdsd"));
	}
	
	@Autowired
	public ApiDao apiDao;
	@Override
	public List<Api> getApis() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Api getApi(long apiId) {
		// TODO Auto-generated method stub
		Api a=null;
		for(Api api: list) {
			if(api.getBinRange()==apiId){
				a=api;
				break;
			}
		}
		return a;
	}

	@Override
	public Api addApi(Api api) {
		// TODO Auto-generated method stub
		list.add(api);
		return api;
	}

	@Override
	public Api updateApi(Api api) {
		// TODO Auto-generated method stub
		int i=0;
		for(Api c: list) {
			if(c.getBinRange()==api.getBinRange()) {
				list.remove(i);
				list.add(i, api);
				break;
			}
			i++;
		}
		return api;
	}

	@Override
	public void deleteApi(long apiId) {
		// TODO Auto-generated method stub
		list= this.list.stream().filter(e->e.getBinRange()!=apiId).collect(Collectors.toList());
	}

}
