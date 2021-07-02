package domain.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import domain.Estacionamento;

public class EstacionamentoDAO {

	Estacionamento estacionamento; // acesso a classe Estacionamento

	ArrayList<Estacionamento> estacionamentos; // lista

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	BufferedReader br;
	BufferedWriter bw;
	String arquivo = "./bd/Estacionamento.csv";

	public ArrayList<Estacionamento> abrir() {

		estacionamentos = new ArrayList<Estacionamento>();
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String line = " ";
			while ((line = br.readLine()) != null) {
				String[] cam = line.split(";");
				estacionamento = new Estacionamento(cam[0], cam[1], sdf.parse(cam[2]), cam[3], cam[4],
						Double.parseDouble(cam[5]));
				estacionamentos.add(estacionamento);
			}
			br.close();
		} catch (IOException t) {
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return estacionamentos;
	}

	public boolean salvar(ArrayList<Estacionamento> es) { // retorna true ou false se salvou
		try {
			bw = new BufferedWriter(new FileWriter(arquivo));
			for (Estacionamento e : es) {
				bw.write(e.toCSV());
			}
			bw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
