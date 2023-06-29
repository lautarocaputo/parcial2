package ar.edu.unlam.pb2;

public class Cumple extends Evento implements Agasajado {
    private Agasajado agasajado;

    public Cumple(String nombre, Usuario organizador,Agasajado agasajado) {
    	super(nombre,organizador);
        this.agasajado = agasajado;
    }

	public Agasajado getAgasajado() {
		return agasajado;
	}

	public void setAgasajado(Agasajado agasajado) {
		this.agasajado = agasajado;
	}

}