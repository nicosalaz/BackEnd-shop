package equitel.car.shop.model;

import java.util.List;

public class Report {
	private Sale sale;
	private List<DetailSale> detailList;
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public List<DetailSale> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<DetailSale> detailList) {
		this.detailList = detailList;
	}
}
