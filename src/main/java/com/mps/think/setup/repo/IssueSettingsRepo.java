package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.IssueGeneration;
import com.mps.think.setup.model.IssueSettings;

@Repository
public interface IssueSettingsRepo extends JpaRepository<IssueSettings, Integer>{

	@Query(value="SELECT * FROM issue_setting where order_class_id=:ocId",nativeQuery = true)
	IssueSettings findByOcId(@Param("ocId") Integer ocId);
	
	List<IssueSettings> findByOrderClassIdPubIdId(Integer pubId);
}
