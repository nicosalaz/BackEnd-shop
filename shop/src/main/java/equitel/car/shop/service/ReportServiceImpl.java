package equitel.car.shop.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equitel.car.shop.model.DetailSale;
import equitel.car.shop.model.Report;
import equitel.car.shop.model.Sale;
import equitel.car.shop.model.ShopException;
import equitel.car.shop.persistence.DetailSaleRepository;
import equitel.car.shop.persistence.SaleRepository;
@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private DetailSaleRepository detailSaleRepository;
	@Autowired
	private SaleRepository saleRepository;
	@Override
	public List<Report> getDayliReport() throws ShopException {
		List<Sale> saleList = null;
		List<DetailSale> detailSales = new ArrayList<>();
		List<Report> reports = new ArrayList<>();
		Report report = null;
		Date dateNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("dd");
		int dia = Integer.parseInt(ft.format(dateNow));
		ft = new SimpleDateFormat ("MM");
		int mes = Integer.parseInt(ft.format(dateNow));
		ft = new SimpleDateFormat ("yyyy");
		int anio = Integer.parseInt(ft.format(dateNow));
		saleList = saleRepository.getByDateNow(dia, mes, anio);
		if (saleList != null) {
			for (Sale sale : saleList) {
				report = new Report();
				detailSales = detailSaleRepository.getDetailsByIdSale(sale.getId());
				report.setSale(sale);
				report.setDetailList(detailSales);
				reports.add(report);
			}
		}
		return reports;
	}

}
