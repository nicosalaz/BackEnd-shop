package equitel.car.shop.service;

import java.util.List;

import equitel.car.shop.model.Report;
import equitel.car.shop.model.ShopException;

public interface ReportService {
	public List<Report> getDayliReport() throws ShopException;

}
