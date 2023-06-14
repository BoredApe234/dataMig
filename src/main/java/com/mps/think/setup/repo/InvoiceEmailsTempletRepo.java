package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.InvoiceEmailsTemplet;
@Repository
public interface InvoiceEmailsTempletRepo extends JpaRepository<InvoiceEmailsTemplet, Integer> {
	
	List<InvoiceEmailsTemplet> findByPublisherId(Integer pubId);

}
