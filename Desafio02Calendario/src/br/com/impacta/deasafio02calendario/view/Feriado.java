package br.com.impacta.deasafio02calendario.view;

public class Feriado {

	private String mes;
	private String dia;
	private String evento;

	public Feriado(String mes, String dia, String evento) {
		super();
		this.mes = mes;
		this.dia = dia;
		this.evento = evento;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}
	
	@Override
	public String toString() {		
		return getEvento();
	}
}