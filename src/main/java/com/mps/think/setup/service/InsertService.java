package com.mps.think.setup.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.mps.think.setup.model.Inserts;
import com.mps.think.setup.vo.InsertsVO;

@Service
public interface InsertService {
	
	public List<Inserts> getAllInserts();
	
	public Inserts saveInserts(InsertsVO inserts);

	public Inserts updateInserts(InsertsVO inserts);

	public Inserts findbyInsertsId(Integer id);
	
	public Inserts deleteByInsertsId(Integer id);
	

}
