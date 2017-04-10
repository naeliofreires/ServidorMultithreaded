import java.net.Socket;

public class HttpRequest implements Runnable {

	//Carriage Return + Line Feed
	final static String CRLF = "\r\n";
	//referência do socket da conexão
	Socket socket;
	//senha para autenticacao de pasta protegida
	private String senhaParaAutenticacao = "redes:computadores";
	//Construtor
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
	private void processRequest() {
		// TODO Auto-generated method stub
		
	}
}
