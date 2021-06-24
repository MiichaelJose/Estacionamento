package domain.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

import domain.Estacionamento;

public class EstacionamentoDAO {
	
	Estacionamento estacionamento;	// acesso a classe Estacionamento
	
	ArrayList <Estacionamento> estacionamentos = new ArrayList <>(); // lista
	
	BufferedReader br;
	BufferedWriter bw;
	
	String arquivo;

	/*
	public ArrayList <Estacionamento> abrir() {
		
		return ;
	}
	*/
	public boolean salvar(ArrayList <Estacionamento> es) {	// retorna true ou false se salvou
		return true;
	}
	
	
}
