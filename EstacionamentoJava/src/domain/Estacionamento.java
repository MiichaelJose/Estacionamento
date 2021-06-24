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
	
	Estacionamento () {
		
	}
	
	
	private double getTotal() {
		double b = 10;
		return b;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(data, horaEntrada, horaSaida, placa, vaga, valorHora);
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
		return Objects.equals(data, other.data) && Objects.equals(horaEntrada, other.horaEntrada)
				&& Objects.equals(horaSaida, other.horaSaida) && Objects.equals(placa, other.placa)
				&& Objects.equals(vaga, other.vaga)
				&& Double.doubleToLongBits(valorHora) == Double.doubleToLongBits(other.valorHora);
	}

	@Override
	public String toString() {
		return "Estacionamento [vaga=" + vaga + ", placa=" + placa + ", data=" + data + ", horaEntrada=" + horaEntrada
				+ ", horaSaida=" + horaSaida + ", valorHora=" + valorHora + "]";
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
