package com.aqh.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.login.dao.RoleDAO;
import com.aqh.login.domain.dto.RoleDTO;

@Service
public class RoleService {

	@Autowired
	private RoleDAO roleDAO;

	public RoleDTO findByUserID(String id) {
		return roleDAO.findByUserID(id);
	}
	
}