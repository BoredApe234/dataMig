package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.OrderCategory;
import com.mps.think.setup.model.Taxonomy;
import com.mps.think.setup.vo.TaxonomyVO;



public interface TaxonomyService {
	
	public List<Taxonomy> findAllTaxonomy();

	public TaxonomyVO saveTaxonomy(TaxonomyVO taxonomy);

	public TaxonomyVO updateTaxonomy(TaxonomyVO taxonomy);

	public Taxonomy findbyId(Integer id);
	
	public Taxonomy deleteById(Integer id);
	public List<Taxonomy> findAllTaxonomyByPubId(Integer publisherId);

}
