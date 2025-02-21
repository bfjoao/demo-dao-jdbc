package aplicacao;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entidades.Department;
import model.entidades.Seller;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Department obj = new Department(1, "Books");

		Seller seller = new Seller(1, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println(seller);
	}

}
