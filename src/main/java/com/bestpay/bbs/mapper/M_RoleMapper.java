package com.bestpay.bbs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.type.Alias;

import com.bestpay.bbs.domain.M_Role;

public interface M_RoleMapper {
	void addRole(M_Role role);

	void correlationPermissions(List<Map<String, Integer>> rolePermissions);

	void unCorrelationPermissions(List<Map<String, Integer>> rolePermissions);
}
