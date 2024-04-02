package equitel.car.shop.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import equitel.car.shop.model.Audit;
import equitel.car.shop.persistence.AuditRepository;
@Service
public class AuditServiceImpl implements AuditService {
	@Autowired
	private AuditRepository auditRepository;
	@Async
	@Override
	public void audit(String service, int state, String response) {
		Audit audit = new Audit();
		try {
			audit.setNowDate(new Timestamp(System.currentTimeMillis()));
			audit.setService(service);
			audit.setState(state);
			audit.setResponse(response);
			auditRepository.save(audit);
		} catch (Exception e) {
			System.err.println(e.fillInStackTrace());
		}

	}

}
