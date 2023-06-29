package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

class PlanificadorDeEventos {
	    private List<Usuario> usuarios;
	    private List<Evento> eventos;

	    public PlanificadorDeEventos() {
	        this.usuarios = new ArrayList<>();
	        this.eventos = new ArrayList<>();
	    }

	    public void add(Usuario usuario) {
	        usuarios.add(usuario);
	    }

	    public void crear(Usuario organizador, Evento evento) {
	        eventos.add(evento);
	    }

	    public void invitar(Evento evento, Usuario invitado) {
	        evento.add(invitado);
	    }
	    
	    public void confirmar(Evento evento, Usuario confirmado) {
	        evento.addConfirmado(confirmado);
	    }

	    public Integer getCantidadDeUsuarios() {
	        return usuarios.size();
	    }

	    public Integer getCantidadDeEventos() {
	        return eventos.size();
	    }
	    
	    public Integer getCantidadDeCasamientos() {
	    	int count = 0;
	        for (Evento evento : eventos) {
	            if (evento instanceof Casamiento) {
	                count++;
	            }
	        }
	        return count;
	    }
	    

	    public Integer getCantidadDeCumpleanios() {
	        int count = 0;
	        for (Evento evento : eventos) {
	            if (evento instanceof Cumple) {
	                count++;
	            }
	        }
	        return count;
	    }
	    
	   

	    public Evento getEvento(String nombre) {
	        for (Evento evento : eventos) {
	            if (evento.getNombre().equals(nombre)) {
	                return evento;
	            }
	        }
	        return null;
	    }

		public Usuario getUsuario(String nombre) {
		        for (Usuario usuario : usuarios) {
		            if (usuario.getNombre().equals(nombre)) {
		            	 return usuario;
		            }
		        }
				return null;
		       
		}
	}