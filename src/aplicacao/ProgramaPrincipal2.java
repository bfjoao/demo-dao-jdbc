package aplicacao;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entidades.Department;

public class ProgramaPrincipal2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department Insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserido! Novo id = " + newDepartment.getId());
	}

}
