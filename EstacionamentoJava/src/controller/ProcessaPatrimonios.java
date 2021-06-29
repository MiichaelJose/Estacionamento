package controller;

import java.util.ArrayList;

import domain.Estacionamento;
import domain.dao.EstacionamentoDAO;

public class ProcessaPatrimonios {
	
	public static ArrayList <Estacionamento> estacionamentos = new ArrayList <>();
	
	private static EstacionamentoDAO  ed;	// Para utilizar os metodo do pacote DAO	
	
	public double getValorTotal() {		// total clients
		double precoHoraTotal = 0;
		for (Estacionamento e : estacionamentos) {	// percorrer lista e acrescentar em uma variavel
			precoHoraTotal += e.getValorHora();
		}
		return precoHoraTotal;
	}
	
	
	// EstacionamentoDAO
	public static boolean salvar() {
		
		return true;
	}
	
	public static void abrir() {
		
	}
	
	
}
