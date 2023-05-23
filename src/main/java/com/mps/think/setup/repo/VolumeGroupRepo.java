package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.VolumeGroup;
@Repository
public interface VolumeGroupRepo extends JpaRepository<VolumeGroup, Integer> {
	
	List<VolumeGroup> findByPubIdId(Integer pubId);
}
