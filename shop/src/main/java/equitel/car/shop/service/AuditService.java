package equitel.car.shop.service;

import java.sql.Timestamp;

public interface AuditService {
	public void audit(String service, int state, String response);
}
