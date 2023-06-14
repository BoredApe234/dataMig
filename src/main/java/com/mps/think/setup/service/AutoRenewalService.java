package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.AutoRenewal;
import com.mps.think.setup.vo.AutoRenewalVO;


@Service
public interface AutoRenewalService {
	
	public List<AutoRenewal> getAllAutoRenewal();
	
	public AutoRenewal saveAutoRenewal(AutoRenewalVO autoRenewal);

	public AutoRenewal updateAutoRenewal(AutoRenewalVO autoRenewal);

	public AutoRenewal findbyAutoRenewalId(Integer id);
	
	public AutoRenewal deleteByAutoRenewalId(Integer id);

}
