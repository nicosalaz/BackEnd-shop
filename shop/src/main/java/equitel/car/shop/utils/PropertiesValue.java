package equitel.car.shop.utils;

import com.google.gson.Gson;

public class PropertiesValue {
	// ############################## GENERAL ##############################
	public static final String CODE_SUCCESS = "200";
	public static final String CODE_CREATE_USER = "201";
	public static final Gson gson = new Gson();
	// ############################## PROVIDER ##############################
	public static final String providerPath = "provider";
	public static final int valueActive = 1;
	// ############################## EMPLOYEE ##############################
	public static final String employeePath = "employee";
	public static final String employeeAuthPath = "auth";
	public static final String employeeGetPath = "update";
	public static final String MSG_CREATE_USER = "Usuario creado exitosamente";
	public static final String MSG_DELETE_USER = "Usuario eliminado correctamente";
	public static final String MSG_UPDATE_USER = "Usuario actualizado correctamente";
	public static final String SERVICE_NAME_EMP_ADD = "EMPLOYEE - CREATE";
	public static final String SERVICE_NAME_EMP_UPT = "EMPLOYEE - UPDATE";
	public static final String SERVICE_NAME_EMP_DEL = "EMPLOYEE - DELETE";
	public static final String SERVICE_NAME_EMP_GET = "EMPLOYEE - GET";
	// ############################## PRODUCT ##############################
	public static final String productPath = "product";
	public static final String MSG_CREATE_PROD = "Producto creado exitosamente";
	public static final String MSG_UPDATE_PROD = "Producto actualizado exitosamente";
	public static final String MSG_DELETE_PROD = "Producto eliminado exitosamente";
	public static final String SERVICE_NAME_PROD_ADD = "PRODUCT - CREATE";
	public static final String SERVICE_NAME_PROD_UPT = "PRODUCT - UPDATE";
	public static final String SERVICE_NAME_PROD_DEL = "PRODUCT - DELETE";
	public static final String SERVICE_NAME_PROD_GET = "PRODUCT - GET";
	// ############################## SHOPPINGCAR ##############################
	public static final String shoppingCarPath = "shoppingCar";
	public static final String MSG_ADD_PROD = "Producto agregado al carrito exitosamente";
	public static final String MSG_UPDATE_CART = "Cantidad de item en el carrito fue actualizado exitosamente";
	public static final String MSG_DELETE_CART = "item eliminado del carrito exitosamente";
	public static final String SERVICE_NAME_CART_ADD = "CART - CREATE";
	public static final String SERVICE_NAME_CART_UPT = "CART - UPDATE";
	public static final String SERVICE_NAME_CART_DEL = "CART - DELETE";
	public static final String SERVICE_NAME_CART_GET = "CART - GET";
	// ############################## SALE ##############################
	public static final String salePath = "sale";
	public static final String PATTERN_DATE = "yyyy-MM-dd HH:mm:ss.S";
	public static final String MSG_ADD_SALE = "Venta registrada exitosamente";
	public static final String SERVICE_NAME_SALE_ADD = "SALE - CREATE";
	// ############################## DETAIL_SALE ##############################
	public static final String detailSalePath = "detailSaleV";
	public static final String reportPath = "report";
	public static final String SERVICE_NAME_DTS_GET = "DETAIL_SALE - GET";
	// ############################## ROLE ##############################
	public static final String rolePath = "role";
	public static final String SERVICE_NAME_ROLE_GET = "ROLE - GET";

}
