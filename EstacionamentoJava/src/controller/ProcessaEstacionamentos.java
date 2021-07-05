package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;

import domain.Estacionamento;
import domain.dao.EstacionamentoDAO;

public class ProcessaEstacionamentos {
	
	public static ArrayList <Estacionamento> estacionamentos = new ArrayList <>();
	
	private static EstacionamentoDAO  ed = new EstacionamentoDAO();	// Para utilizar os metodo do pacote DAO	
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// EstacionamentoDAO
	public static boolean salvar() {
		if (ed.salvar(estacionamentos)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void abrir() {
		estacionamentos = ed.abrir();
	}
}
