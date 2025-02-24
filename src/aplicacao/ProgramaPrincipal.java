package aplicacao;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entidades.Department;
import model.entidades.Seller;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller sell : list) {
			System.out.println(sell);
		}

		System.out.println("=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller sell : list) {
			System.out.println(sell);
		}
		
		System.out.println("=== TEST 4: seller Insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! Novo id = " + newSeller.getId());
		
		System.out.println("=== TEST 5: seller Update ===");
		seller = sellerDao.findById(1);
		seller.setNome("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Atualização completa!");

	}
}
