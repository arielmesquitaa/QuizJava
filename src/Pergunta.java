
public class Pergunta {
	String descricao;
	int respostaCerta;
	String resposta1;
	String resposta2;
	String resposta3;
	String resposta4;
	String resposta5;
	public Pergunta() {
		
	}
	
	public Pergunta(String desc, int resp, String r1, String r2, String r3, String r4, String r5) {
		descricao = desc;
		respostaCerta = resp;
		resposta1 = r1;
		resposta2 = r2;
		resposta3 = r3;
		resposta4 = r4;
		resposta5 = r5;
	}
	
	public void setPergunta(String desc, int resp, String r1, String r2, String r3, String r4, String r5) {
		descricao = desc;
		respostaCerta = resp;
		resposta1 = r1;
		resposta2 = r2;
		resposta3 = r3;
		resposta4 = r4;
		resposta5 = r5;
	}
	
	public boolean responde(int resp) {
		if (resp == respostaCerta) return true;
		else return false;
	}
}
