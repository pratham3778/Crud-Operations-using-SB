package com.CrudOperations.service;

import java.util.List;

import com.CrudOperations.entity.IplTeam;

public interface IplService {
	public IplTeam insertdata(IplTeam iplTeam);
	
	public List<IplTeam> getAllTeams();
	
	public IplTeam updateTeam(int id, IplTeam iplTeam);
	
	public void delete(int id);
}
