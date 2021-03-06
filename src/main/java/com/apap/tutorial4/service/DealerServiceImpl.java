package com.apap.tutorial4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.repository.DealerDb;

@Service
@Transactional
public class DealerServiceImpl implements DealerService {
	@Autowired
	private DealerDb dealerDb;
	
	@Override
	public Optional<DealerModel> getDealerDetailById(Long id) {
		return dealerDb.findById(id);
	}
	
	@Override
	public void addDealer(DealerModel dealer) {
		dealerDb.save(dealer);
		
	}
	
	
	@Override
	public DealerDb allDealer() {
		return dealerDb;
		
	}
	@Override
	public void deleteDealer(DealerModel dealer) {
		dealerDb.delete(dealer);
	}
	
	@Override
	public void updateDealer(DealerModel updateDealer, Long dealerId) {
		DealerModel oldDealer = dealerDb.findById(dealerId).get();
		System.out.println("AAAA");
		System.out.println(updateDealer.getAlamat());
		System.out.println(updateDealer.getNoTelp());
		oldDealer.setAlamat(updateDealer.getAlamat());
		oldDealer.setNoTelp(updateDealer.getNoTelp());
		dealerDb.save(oldDealer);
	}
	

}
