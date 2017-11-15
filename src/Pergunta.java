
public class Pergunta {
	String topico;
	String descricao;
	String resposta1;
	String resposta2;
	String resposta3;
	String resposta4;
	String resposta5;
	int respostaCerta;
	
	public Pergunta() {}
		
	public Pergunta(String topico, String descricao, int respostaCerta,String resposta1, String resposta2, String resposta3,
			String resposta4, String resposta5) {
		this.topico = topico;
		this.descricao = descricao;
		this.respostaCerta = respostaCerta;
		this.resposta1 = resposta1;
		this.resposta2 = resposta2;
		this.resposta3 = resposta3;
		this.resposta4 = resposta4;
		this.resposta5 = resposta5;
	}
	
	public boolean responde(int resp) {
		if (resp == respostaCerta) return true;
		else return false;
	}
}
