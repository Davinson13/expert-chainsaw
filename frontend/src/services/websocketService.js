export const iniciarWebSocket = (callback) => {
    const socket = new WebSocket("ws://localhost:9090/ws");
  
    socket.onmessage = (event) => {
      const mensaje = JSON.parse(event.data);
      callback(mensaje);
    };
  };
  