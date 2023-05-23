package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.Taxonomy;
import com.mps.think.setup.repo.TaxonomyRepo;
import com.mps.think.setup.service.TaxonomyService;
import com.mps.think.setup.vo.TaxonomyVO;

@Service
public class TaxonomyServiceImpl implements TaxonomyService {
	
	@Autowired
	TaxonomyRepo taxonomyRepo;

	@Override
	public List<Taxonomy> findAllTaxonomy() {
		List<Taxonomy> ccList = taxonomyRepo.findAll();
		if (ccList.isEmpty()) {
			throw new NotFoundException("No taxonomy present, please add taxonomy!");
		}
		return ccList;
	}

	@Override
	public TaxonomyVO saveTaxonomy(TaxonomyVO taxonomy) {
		Taxonomy data = new Taxonomy();
		data.setTaxonomy(taxonomy.getTaxonomy());
		data.setDescription(taxonomy.getDescription());
		taxonomy.setId(data.getId());
		Publisher publisher=new Publisher();
		publisher.setId(taxonomy.getPubId().getId());
		data.setPubId(publisher);
		taxonomyRepo.saveAndFlush(data);
		return taxonomy;
	}

	@Override
	public TaxonomyVO updateTaxonomy(TaxonomyVO taxonomy) {
		Taxonomy data = findbyId(taxonomy.getId());
		data.setTaxonomy(taxonomy.getTaxonomy());
		data.setDescription(taxonomy.getDescription());
		taxonomy.setId(data.getId());
		Publisher publisher=new Publisher();
		publisher.setId(taxonomy.getPubId().getId());
		data.setPubId(publisher);
		taxonomyRepo.saveAndFlush(data);
		return taxonomy;
	}

	@Override
	public Taxonomy findbyId(Integer id) {
		Optional<Taxonomy> cc = taxonomyRepo.findById(id);
		if(!cc.isPresent()) {
			throw new NotFoundException("Taxonomy  Id : "+ id +" does not exist!");
		}
		return cc.get();
	}

	@Override
	public Taxonomy deleteById(Integer id) {
		Taxonomy todelete = findbyId(id);
		taxonomyRepo.delete(todelete);
		return todelete;
	}

	@Override
	public List<Taxonomy> findAllTaxonomyByPubId(Integer publisherId) {
		// TODO Auto-generated method stub
		return taxonomyRepo.findByPubIdId(publisherId);
	}
	

}
