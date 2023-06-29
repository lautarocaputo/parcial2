package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Prueba {

	@Test
	public void queSePuedaCrearUnCumpleanios() {
		// Preparaci�n
		final String mailOrganizador = "chiquitapia@afa.com", nombreOrganizador = "Chiqui Tapia", mailAgasajado = "lio@Messi.com", nombreAgasajado = "Lionel Messi";
		final Integer edadOrganizador = 55, edadAgasajado = 36;
		final Integer cantidadDeUsuariosEsperados = 2, cantidadDeEventosEsperados = 1, cantidadDeCumpleaniosEsperados = 1, cantidadDeCasamientosEsperados = 0;
		
		// Ejecuci�n
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		Usuario organizador = new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador);
		Agasajado agasajado = (Agasajado)new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		principal.add(organizador);
		principal.add((Usuario)agasajado);
		
		principal.crear(organizador, new Cumple("El cumple de Lionel Messi",organizador,agasajado));


		// Validaci�n
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeEventosEsperados, principal.getCantidadDeEventos());
		assertEquals(cantidadDeCumpleaniosEsperados, principal.getCantidadDeCumpleanios());
		assertEquals(new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador), principal.getEvento("El cumple de Lionel Messi").getOrganizador());
		assertEquals(cantidadDeCasamientosEsperados, principal.getCantidadDeCasamientos());
	}
	
	@Test
	public void queSePuedaCrearUnCasamiento() {
		// Preparaci�n
		final String mailOrganizador = "roberto@galan.com", nombreOrganizador = "Roberto Galan", mailAgasajado1 = "luli@salazar.com", nombreAgasajado1 = "Luciana Zalazar", mailAgasajado2 = "rodrigo@redrado.com", nombreAgasajado2 = "Rodrigo Redrado", nombreDelEvento = "El casamiento de Luli y Rodri";
		final Integer edadOrganizador = 101, edadAgasajado1 = 36, edadAgasajado2 = 43;
		final Integer cantidadDeUsuariosEsperados = 3, cantidadDeEventosEsperados = 1, cantidadDeCumpleaniosEsperados = 0, cantidadDeCasamientosEsperados = 1;
		
		Agasajado usuarioAgasajado1 = new Usuario(mailAgasajado1, nombreAgasajado1, edadAgasajado1);
		Agasajado usuarioAgasajado2 = new Usuario(mailAgasajado2, nombreAgasajado2, edadAgasajado2);
		Usuario organizador = new Organizador(mailOrganizador, nombreOrganizador, edadOrganizador);
		
		// Ejecuci�n
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		principal.add((Usuario)usuarioAgasajado1);
		principal.add((Usuario)usuarioAgasajado2);
		principal.add(organizador);
		principal.crear(organizador, new Casamiento(nombreDelEvento,organizador));
		principal.getEvento(nombreDelEvento).add((Usuario)usuarioAgasajado1);
		principal.getEvento(nombreDelEvento).add((Usuario)usuarioAgasajado2);		
		// Validaci�n
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeEventosEsperados, principal.getCantidadDeEventos());
		assertEquals(cantidadDeCumpleaniosEsperados, principal.getCantidadDeCumpleanios());
		assertEquals(organizador,principal.getEvento(nombreDelEvento).getOrganizador());
		assertEquals(cantidadDeCasamientosEsperados, principal.getCantidadDeCasamientos());
	}
	
	@Test
	public void queSePuedaInvitarGenteAUnCumpleanios() {
		// Preparaci�n
		final String mailOrganizador = "chiquitapia@afa.com", nombreOrganizador = "Chiqui Tapia", mailAgasajado = "lio@Messi.com", nombreAgasajado = "Lionel Messi";
		final Integer edadOrganizador = 55, edadAgasajado = 36;
		final Integer cantidadDeUsuariosEsperados = 4, cantidadDeInvitadosEsperados = 2;
		
		// Ejecuci�n
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		Usuario organizador = new Organizador(mailOrganizador, nombreOrganizador, edadOrganizador);
		principal.add(organizador);
		Usuario kun = new Usuario("kunaguero@kunisports.com", "Sergio Aguero", 36);
		principal.add(kun);
		Usuario mbappe = new Usuario("kmbappe@second.com", "Kylian Mbapee", 24);
		principal.add(mbappe);
		Agasajado messi = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		principal.add((Usuario)messi);
		
		Usuario organizadorDelEvento = principal.getUsuario(mailOrganizador);
		Cumple elCumpleDeLeo = new Cumple("Cumple de messsi",organizador,(Agasajado)new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado));
		principal.crear(organizadorDelEvento, elCumpleDeLeo);
		principal.invitar(elCumpleDeLeo, mbappe);
		principal.invitar(elCumpleDeLeo, kun);
		
		// Validaci�n
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeInvitadosEsperados, principal.getEvento("Cumple de messsi").getCantidadDeInvitados());
	}
	
	@Test
	public void queUnInvitadoPuedaConfirarSuAsistencia () {
		// Preparaci�n
		final String mailOrganizador = "chiquitapia@afa.com", nombreOrganizador = "Chiqui Tapia", mailAgasajado = "lio@Messi.com", nombreAgasajado = "Lionel Messi";
		final Integer edadOrganizador = 55, edadAgasajado = 36;
		final Integer cantidadDeUsuariosEsperados = 4, cantidadDeInvitadosEsperados = 2, cantidadDeInvitadosConfirmados = 1;
		Usuario elKun = new Usuario("kunaguero@kunisports.com", "Sergio Aguero", 36);
		Usuario elSegundo = new Usuario("kmbappe@second.com", "Kylian Mbapee", 24);
		
		// Ejecuci�n
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		Usuario organizador = new Organizador(mailOrganizador, nombreOrganizador, edadOrganizador);
		principal.add(organizador);
		
		principal.add(elKun);
		principal.add(elSegundo);
		Usuario organizadorDelEvento = principal.getUsuario(mailOrganizador);
		
		Agasajado agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		principal.add((Usuario)agasajado);
		
		Evento elCumpleDeLeo = new Cumple("Cumple de messi",organizador,agasajado);
		
	
		principal.crear(organizador,elCumpleDeLeo) ;
		
		principal.invitar(elCumpleDeLeo, elKun);
		principal.invitar(elCumpleDeLeo, elSegundo);
		principal.confirmar(elCumpleDeLeo, elKun);
		
		elCumpleDeLeo.addConfirmado(elKun);
		
		// Validaci�n
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		
		assertEquals(cantidadDeInvitadosEsperados, elCumpleDeLeo.getCantidadDeInvitados());
		assertEquals(cantidadDeInvitadosConfirmados, elCumpleDeLeo.getCantidadDeConfirmados());
	}

}
