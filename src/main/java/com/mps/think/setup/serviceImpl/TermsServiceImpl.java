package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Terms;
import com.mps.think.setup.repo.TermsRepo;
import com.mps.think.setup.service.TermsService;
import com.mps.think.setup.vo.TermsVO;

@Service
public class TermsServiceImpl implements TermsService{
	
	@Autowired
	TermsRepo termsRepo;
	

	@Override
	public List<Terms> findAllTerms() {
		List<Terms> tList = termsRepo.findAll();
		if (tList.isEmpty()) {
			throw new NotFoundException("No Terms present, please add Terms!");
		}
		return tList;
	}


	@Override
	public TermsVO saveTerms(TermsVO terms) {
		ObjectMapper mapper = new ObjectMapper();
		Terms newTerms = mapper.convertValue(terms, Terms.class);
		Terms data=termsRepo.saveAndFlush(newTerms);
		terms.setTermsId(data.getTermsId());
		return terms;
		}


	@Override
	public TermsVO updateTerms(TermsVO terms) {
		ObjectMapper mapper = new ObjectMapper();
		Terms updateTerms = mapper.convertValue(terms, Terms.class);
		Terms data=termsRepo.saveAndFlush(updateTerms);
		terms.setTermsId(data.getTermsId());
		return terms;

		}
	

	@Override
	public Terms findbytermsId(Integer termsId) {
		 Optional<Terms> cr = termsRepo.findById(termsId);
			if(!cr.isPresent()) {
				throw new NotFoundException("Terms  Id : "+ termsId +" does not exist!");
			}
			return cr.get();
	}
	
	@Override
	public Terms deleteBytermsId(Integer termsId) {
		Terms delete = termsRepo.findBytermsId(termsId);
		termsRepo.delete(delete);
		return delete;
	}


	@Override
	public List<Terms> findAllTermsForPublisher(Integer pubId) {
		return termsRepo.findByPubIdId(pubId);
	}

}
