package com.mps.think.setup.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.mps.think.setup.model.LabelLayout;
import com.mps.think.setup.vo.LabelLayoutVO;

@Service
public interface LabelLayoutService {
	
	public List<LabelLayout> getAllLabelLayout();
	
	public LabelLayout saveLabelLayout(LabelLayoutVO labelLayout);

	public LabelLayout updateLabelLayout(LabelLayoutVO labelLayout);

	public LabelLayout findbyLabelLayoutId(Integer id);
	
	public LabelLayout deleteByLabelLayoutId(Integer id);
	
	List<LabelLayout> findAllLabelLayoutForPublisher(Integer pubId);

}
