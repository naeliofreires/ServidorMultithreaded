import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpRequest implements Runnable {

	//Carriage Return + Line Feed
	final static String CRLF = "\r\n";
	
	//referência do socket da conexão
	Socket socket;
	
	public HttpRequest (Socket socket) throws Exception{
		this.socket = socket;
	}
	
	// roda processrequest e trata as exceções
	public void run(){
	
		try{
			processRequest();
		}
		catch (Exception e) {
			System.out.println (e);
		}
	}
	
	private void processRequest() throws IOException {
		
		//Primeiro obtemos referências para os trechos de entrada e saída do socket.

		//Objeto isr referência para os trechos de entrada
		InputStreamReader isr = new InputStreamReader(socket.getInputStream());
		
		//Objeto dos referência para os trechos de saida
		DataOutputStream dos = new 	DataOutputStream(socket.getOutputStream());
		
		//Ajustar os filtros do trecho de entrada
		BufferedReader br = new BufferedReader(isr);
		
		//Obter a linha de requisição da mensagem de requisição HTTP
		String requestLine = br.readLine();
		
		//Exibir a linha de requisição no Console
		System.out.println(); // pula uma linha
		System.out.println(requestLine);
		
		String headerLine = null;
		
		while ((headerLine = br.readLine()).length() != 0){
			System.out.println(headerLine);
		}
		
		isr.close();
		dos.close();
		socket.close();
	}
}
