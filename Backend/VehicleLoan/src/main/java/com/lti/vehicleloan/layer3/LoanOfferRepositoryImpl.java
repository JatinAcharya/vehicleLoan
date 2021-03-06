package com.lti.vehicleloan.layer3;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.vehicleloan.layer2.OfferTable;
@Repository
public class LoanOfferRepositoryImpl extends BaseRepository implements LoanOfferRepository {
	
	public LoanOfferRepositoryImpl() {
		System.out.println("LoanOfferRepositoryImpl() constructed");
	}

	@Transactional
	public List<OfferTable> getOfferTable(BigDecimal amount) {
		
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("Select o from OfferTable o where o.offerAmount<=:amount");	
		query.setParameter("amount", amount);
		
		
		List<OfferTable> offerTable=query.getResultList();
		return offerTable;
	}

}


