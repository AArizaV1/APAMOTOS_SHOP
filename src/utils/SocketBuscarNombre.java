package utils;

import java.io.IOException;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import Servlets.ServletVerCatalogo;

@ServerEndpoint("/SBNombre")
public class SocketBuscarNombre {

	// Método que añade la sesión al websocket

	@OnOpen
	public void onOpen(Session sesion, EndpointConfig epc) {

		synchronized (ServletVerCatalogo.socket) {

			ServletVerCatalogo.socket.add(sesion);

		}

	}

	// Método que envía un mensaje a la sesión

	@OnMessage
	public void onMessage(Session sesion, String mensaje) {

		try {

			synchronized (ServletVerCatalogo.socket) {

				for (Session s : ServletVerCatalogo.socket) {

					s.getBasicRemote().sendText("mensaje," + mensaje);

				}
			}

		} catch (IOException e) {

			System.out.println("Ups! Algo ha fallado.");

		}

	}

	// Método que elimina la sesión del websocket

	@OnClose
	public void onClose(Session sesion) {

		for (Session s : ServletVerCatalogo.socket) {

			if (s == sesion) {

				ServletVerCatalogo.socket.remove(s);

			}

		}

	}

}