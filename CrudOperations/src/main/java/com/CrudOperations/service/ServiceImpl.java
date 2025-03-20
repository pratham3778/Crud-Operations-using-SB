package com.CrudOperations.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CrudOperations.entity.IplTeam;
import com.CrudOperations.repository.IplRepository;

@Service
public class ServiceImpl implements IplService {
	
	IplRepository iplRepository;
	
	public ServiceImpl(IplRepository iplRepository) {
		super();
		this.iplRepository = iplRepository;
	}

	@Override
	public IplTeam insertdata(IplTeam iplTeam) {
		
		return iplRepository.save(iplTeam);
	}

	@Override
	public List<IplTeam> getAllTeams() {
		// TODO Auto-generated method stub
		return iplRepository.findAll();
	}

	@Override
	public IplTeam updateTeam(int id, IplTeam iplTeam) {
		IplTeam existingTeam = iplRepository.findById(id).get();
		existingTeam.setName(iplTeam.getName());
		existingTeam.setTrophies(iplTeam.getTrophies());
		existingTeam.setCaptainName(iplTeam.getCaptainName());
		
		IplTeam updatedTeam=iplRepository.save(existingTeam);
		return updatedTeam;
	}

	@Override
	public void delete(int id) {
		IplTeam existingTeam = iplRepository.findById(id).get();
		
		iplRepository.delete(existingTeam);
	}

}
