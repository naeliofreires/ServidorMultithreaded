import java.net.ServerSocket;
import java.net.Socket;

//Esta classe faz a conexão com o cliente e deixa o tratamento 
//sobre responsabilidade de outra classe
public final class WebServer {
	
	//método que executa o inicio do programa
	public static void main (String arvg[]) throws Exception{
	
		int porta = 8181;// Escolhemos primeiro a porta (sem motivo especial) 
		
		// Criando um Socket Servidor que inicia a conexão e passamos a porta criado ...
		ServerSocket socketServ = new ServerSocket(porta);
		
		// Criando o Socket do Cliente
		Socket socketCli;
		
//		Como estaremos atendendo a mensagens de requisição indefinitivamente 
//		colocaremos em um loop infinito
		while (true) {
		
			//Apenas um mensagem para indicar que o servidor encontra-se ativo
			System.out.println( "Servidor Ativo" );
			
//			Ficar escutando o pedido de Conexão
			socketCli = socketServ.accept();
			
//			Passamos ao construtor um objeto 'socket' que representa nossa conexão
//			com o cliente
			HttpRequest requisicao = new HttpRequest(socketCli);
			
//			Criado um novo thread para manipular as requisicões
			Thread thread = new Thread (requisicao);
			
			//Inicia o thread.
			thread.start();
		}
	}
}