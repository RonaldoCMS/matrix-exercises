package demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Prodotto {
	
	private int id;
	private String nome;
	private String img;
	private Double costo = null;
	private Integer sconto;
	
	public Prodotto() {}
	
	public Prodotto(ResultSet resultSet) throws SQLException {
		super();
		this.id = resultSet.getInt("id");
		this.nome = resultSet.getString("nome");
		this.img = resultSet.getString("img");;
		this.costo = resultSet.getDouble("costo");
		this.sconto = resultSet.getInt("sconto");;
	}
	
	
	public Prodotto(int id, String nome, String img, double costo, Integer sconto) {
		super();
		this.id = id;
		this.nome = nome;
		this.img = img;
		this.costo = costo;
		this.sconto = sconto;
	}
	
	public Prodotto(String nome, String img, Double costo, Integer sconto) {
		super();
		this.id = -1;
		this.nome = nome;
		this.img = img;
		this.costo = costo;
		this.sconto = sconto;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Integer getSconto() {
		if(sconto == null) setSconto(0);
		return sconto;
	}

	public void setSconto(Integer sconto) {
		System.out.println("SCONTO:" + sconto);
		this.sconto = sconto;
	}
	
	public void changeValues(Prodotto prodotto) {
		if(prodotto.getNome() != null) setNome(prodotto.getNome());
		if(prodotto.getImg() != null) setImg(prodotto.getImg());
		if(prodotto.getCosto() != null) setCosto(prodotto.getCosto());
		if(prodotto.getSconto() != null) setSconto(prodotto.getSconto());
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", img=" + img + ", costo=" + costo + ", sconto=" + sconto
				+ "]";
	}
	
	
	
}
