package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Evento {
    private String nombre;
    private Usuario organizador;
    private HashSet<Usuario> invitados;
    private List<Usuario> confirmados;
    
    public Integer getCantidadDeInvitados() {
        int count = 0;
        for (Usuario usuario : invitados) {
                count++;
        }
        return count;
    }
    
    public Integer getCantidadDeConfirmados() {
        int count = 0;
        for (Usuario usuario : confirmados) {
                count++;
        }
        return count;
    }


	public Evento(String nombre, Usuario organizador) {
        this.nombre = nombre;
        this.organizador = organizador;
        this.invitados = new HashSet<>();
    }

    public void add(Usuario invitado) {
        invitados.add(invitado);
    }
    
    public void addConfirmado(Usuario confirmado) {
        this.confirmados.add(confirmado);
    }

    public Usuario getOrganizador() {
        return organizador;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
