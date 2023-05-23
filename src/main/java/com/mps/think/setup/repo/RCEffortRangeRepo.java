package com.mps.think.setup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.RCEffortRange;
@Repository
public interface RCEffortRangeRepo extends JpaRepository<RCEffortRange, Integer> {

}
