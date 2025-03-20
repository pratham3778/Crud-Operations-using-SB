package com.CrudOperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CrudOperations.entity.IplTeam;

public interface IplRepository extends JpaRepository<IplTeam, Integer> {

}
