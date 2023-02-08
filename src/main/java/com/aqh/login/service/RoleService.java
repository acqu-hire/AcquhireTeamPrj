package com.aqh.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.login.dao.RoleDAO;

@Service
public class RoleService {

	@Autowired
	private RoleDAO roleDAO;

}