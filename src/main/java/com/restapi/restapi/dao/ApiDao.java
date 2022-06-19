package com.restapi.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.restapi.entities.Api;

public interface ApiDao extends JpaRepository<Api, Long>{

}
