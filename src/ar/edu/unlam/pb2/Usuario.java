package ar.edu.unlam.pb2;

import java.util.Objects;

public class Usuario implements Agasajado{
	
	String mail ="";
	String nombre="";
	Integer edad=0;

	public Usuario(String mail, String nombre, Integer edad) {
		this.mail = mail;
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Usuario usuario = (Usuario) obj;
        return mail.equals(usuario.mail) &&
                nombre.equals(usuario.nombre) &&
                edad == usuario.edad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, nombre, edad);
    }

}
