package domain;

import java.util.Date;
import java.util.Objects;

public class Estacionamento {
	
	private String vaga;
	private String placa;
	private Date data;
	private String horaEntrada;
	private String horaSaida;
	private double valorHora;
	
	
	
	
	
	public Estacionamento(String vaga, String placa, Date data, String horaEntrada, String horaSaida,
			double valorHora) {
		this.vaga = vaga;
		this.placa = placa;
		this.data = data;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.valorHora = valorHora;
	}




	private double getTotal() {						
		//calcular o total de hrs em dinheiro
		// (horasaida - horaentrada)* valorHora
		double var = Double.parseDouble(horaEntrada);
		double var2 = Double.parseDouble(horaSaida);						
		return (var - var2) * valorHora;
	}

	
	


	



	@Override
	public int hashCode() {
		return Objects.hash(data, placa);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		return Objects.equals(data, other.data) && Objects.equals(placa, other.placa);
	}





	@Override
	public String toString() {
		return "\t" + vaga + "\t" + placa + "\t" + data + "\t" + horaEntrada
				+ "\t" + horaSaida + "\t" + valorHora + "\t"+ getTotal() +"\t\n";
	}

	public String getVaga() {
		return vaga;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	
}
