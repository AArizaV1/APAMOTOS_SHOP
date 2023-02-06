var websocket;

class SocketBuscarNombre {

	// Constructor del web socket
	constructor(url) {
		this.websocket = new WebSocket(url);
		this.websocket.onOpen = (evt) => this.onOpen(evt);
		this.websocket.onClose = (evt) => this.onClose(evt);
		this.websocket.addEventListener('message', (evt) => this.onMessage(evt));
		this.websocket.onError = (evt) => this.onError(evt);
	}

	// Función al abrir el websocket
	onOpen(evt) {
		console.log("Abierto");
	}

	// Función al recibir mensaje del websocket
	onMessage(evt) {

		let partes = [];
		partes = evt.data.split(',');

		//Obtención de las tarjetas de productos

		let productos=document.getElementsByName("card");

		//Si el tamaño del valor recibido del websocket es 0, muestra todos

        if(partes[1].length==0){
            for(let i=0; i<productos.length; i++){
                $(productos[i]).show();
    
            }

		//Si no, muestra la tarjeta de productos cuyo nombre tenga el valor recibido del websocket

        }else{

            for(let i=0; i<productos.length; i++){
                let nombre=document.getElementsByName("nombre")[i].innerHTML.toUpperCase();
    
                if(nombre.indexOf(partes[1].toUpperCase()) > -1){
                    $(productos[i]).show();
                }else{
                    $(productos[i]).hide();
                }
   
            }
        }
	}

	// Función al recibir error en el websocket
	onError(evt) {
		console.log("Error");
	}

	// Función al introducir un valor al input
	filtrar() {
		let texto = document.getElementById("nombre");
		this.websocket.send(texto.value.trim());
	}

}