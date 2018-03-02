package exercicio_02_para_entregar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Pais {
	private int id;
	private String nome;
	private long populacao;
	private double area;
	static {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		throw new RuntimeException(e);
		}
	}

	public Pais(int id, String nome, long populacao, double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	public Pais() {
		
	}
	public Connection obtemConexao() throws SQLException {
		return DriverManager
		.getConnection("jdbc:mysql://127.0.0.1/bdEx02?user=root&password=Santosfc10");
		}
	
	public void criar() {
		String sqlInsert = "INSERT INTO Pais(nome, populacao, area) VALUES (?, ?, ?)";
		try (Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		stm.setString(1, getNome());
		stm.setLong(2, getPopulacao());
		stm.setDouble(3, getArea());
		stm.execute();
		String sqlQuery = "SELECT LAST_INSERT_ID()";
		try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
		ResultSet rs = stm2.executeQuery();) {
		if(rs.next()){
		setId(rs.getInt(1));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	public void excluir() {
		String sqlDelete = "DELETE FROM Pais WHERE id = ?";
		try (Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
		stm.setInt(1, getId());
		stm.execute();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	public void atualizar() {
		String sqlUpdate = "UPDATE Pais SET nome=?, populacao=?, area=? WHERE id=?";
		try (Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
		stm.setString(1, getNome());
		stm.setLong(2, getPopulacao());
		stm.setDouble(3, getArea());
		stm.setInt(4, getId());
		stm.execute();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	public void carregar() {
		String sqlSelect = "SELECT nome, populacao, area FROM Pais WHERE Pais.id = ?";
		try (Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		stm.setInt(1, getId());
		try (ResultSet rs = stm.executeQuery();) {
		if (rs.next()) {
		setNome(rs.getString("nome"));
		setPopulacao(rs.getLong("populacao"));
		setArea(rs.getDouble("area"));
		} else {
		setId(-1);
		setNome(null);
		setPopulacao(0);
		setArea(0);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		} catch (SQLException e1) {
		System.out.print(e1.getStackTrace());
		}
	}
	public void maiorPopulacao() {
		String sqlMaxPop = "SELECT * FROM Pais WHERE populacao = (SELECT max(populacao) FROM Pais)";
		try (Connection conn = obtemConexao()){
			PreparedStatement stm = conn.prepareStatement(sqlMaxPop);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				setId(rs.getInt("id"));
				setNome(rs.getString("nome"));
				setPopulacao(rs.getLong("populacao"));
				setArea(rs.getDouble("area"));
			}else {
				System.out.println("erro");
			}
			}catch (SQLException e) {
			System.out.println(e);
			}
	}
	public void menorArea() {
		String sqlMinArea = "SELECT * FROM Pais WHERE area = (SELECT min(area) FROM Pais)";
		try (Connection conn = obtemConexao()){
			PreparedStatement stm = conn.prepareStatement(sqlMinArea);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				setId(rs.getInt("id"));
				setNome(rs.getString("nome"));
				setPopulacao(rs.getLong("populacao"));
				setArea(rs.getDouble("area"));
			}else {
				System.out.println("erro");
			}
			}catch (SQLException e) {
			System.out.println(e);
			}
	}
	public String[] vetorTresPaises() {
		String sqlVetTresPais = "SELECT nome FROM Pais ORDER BY id";
		String[] vetorTresPais = new String[3];
		int contador = 0 ;
		try (Connection conn = obtemConexao()){
			PreparedStatement stm = conn.prepareStatement(sqlVetTresPais);
			ResultSet rs = stm.executeQuery();
			while(rs.next() && contador < 3 ) {
				vetorTresPais[contador] = rs.getString("nome");
				contador = contador + 1;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return vetorTresPais;
	}
	public String toString() {
		
		return "id: " + getId() + " \n nome: "+getNome()+" \n populacao: "+getPopulacao()+" \n area: "+getArea();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
}
