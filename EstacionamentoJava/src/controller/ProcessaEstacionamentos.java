package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import domain.Estacionamento;
import domain.dao.EstacionamentoDAO;

public class ProcessaEstacionamentos {
	
	public static ArrayList <Estacionamento> estacionamentos = new ArrayList <>();
	
	private static EstacionamentoDAO  ed = new EstacionamentoDAO();	// Para utilizar os metodo do pacote DAO	
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public double getValorTotal() {		// total clients
		double precoHoraTotal = 0;
		for (Estacionamento e : estacionamentos) {	// percorrer lista e acrescentar em uma variavel
			precoHoraTotal += e.getValorHora();
		}
		return precoHoraTotal;
	}
	
	public static String listarPorData(Date data) {
		Estacionamento a = new Estacionamento();		//String dataFormatada = sdf.format(data);
    	String acum = "";
		for (Estacionamento e:estacionamentos) {
			if (sdf.format(a.getData()).equals(sdf.format(data))) {
				acum += e;
			}
        }
        return acum;
    }
	
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
	
	public static void preencherTestes(){
        estacionamentos.add(new Estacionamento("VC1", "AAA1A11", new Date(), "08:00", "10:00",5.00));
        estacionamentos.add(new Estacionamento("VC2", "AAA2A12", new Date(), "09:00", "10:00",5.00));
        estacionamentos.add(new Estacionamento("VC3", "AAA3A13", new Date(), "10:00", "11:00",5.00));
        estacionamentos.add(new Estacionamento("VC4", "AAA4A14", new Date(), "08:00", "09:00",5.00));
        estacionamentos.add(new Estacionamento("VC5", "AAA5A15", new Date(), "07:00", "10:00",5.00));
        estacionamentos.add(new Estacionamento("VC1", "AAA6A16", new Date(), "12:00", "14:00",5.00));
        estacionamentos.add(new Estacionamento("VC3", "AAA7A17", new Date(), "12:00", "14:00",5.00));
        estacionamentos.add(new Estacionamento("VC2", "AAA8A18", new Date(), "11:00", "13:00",5.00));
        estacionamentos.add(new Estacionamento("VC4", "AAA9A19", new Date(), "12:00", "15:00",5.00));
        estacionamentos.add(new Estacionamento("VC5", "AAA0A10", new Date(), "11:00", "13:00",5.00));
    }
	
}
