package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entidades.Department;
import model.entidades.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT seller.*, department.Name as DepName "
										+ "FROM seller INNER JOIN department " 
										+ "ON seller.DepartmentId = departmentId "
										+ "WHERE seller.Id = ?");
			
			st.setInt(1, id); // Define o valor do parâmetro "?" com o ID do vendedor buscado
			rs = st.executeQuery();
			
			if (rs.next()) { // Testa se veio algum resultado na consulta
				Department dep = instantiateDepartment(rs);
				Seller sell = instantiateSeller(rs, dep); 
				return sell;
			}
			return null; // Retorna null caso nenhum vendedor seja encontrado com o ID informado
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException { // Método auxiliar para instanciar um objeto Seller a partir do ResultSet
		Seller sell = new Seller();
		sell.setId(rs.getInt("Id"));
		sell.setNome(rs.getString("Name"));
		sell.setEmail(rs.getString("Email"));
		sell.setBaseSalary(rs.getDouble("BaseSalary"));
		sell.setBirthDate(rs.getDate("BirthDate"));
		sell.setDepartment(dep); // Associa o vendedor ao departamento
		return sell;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException { // Método auxiliar para instanciar um objeto Department a partir do ResultSet
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setNome(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}