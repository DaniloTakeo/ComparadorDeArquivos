package teste;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Teste {

	static String linhaArquivo;
	
	public static void main(String[] args) throws IOException {
		Scanner entradaReferencia = new Scanner(new File("dados1.txt"));
		Scanner entradaComparacao = new Scanner(new File("dados2.txt"));
		
		ArrayList<String> arrayReferencia = new ArrayList<String>();
		ArrayList<String> arrayComparacao = new ArrayList<String>();
		
		HashMap<String, String> mapaReferencia = new HashMap<String, String>();
		HashMap<String, String> mapaComparacao = new HashMap<String, String>();
		
		OutputStream os = new FileOutputStream("divergentes.txt");
		Writer osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		boolean contem;
		
		//Mapear primeiro Array
		while(entradaReferencia.hasNextLine()) {
			linhaArquivo = entradaReferencia.nextLine();
			
			mapaReferencia = mapearLayout(linhaArquivo);
			arrayReferencia.add(mapaReferencia.values().toString());
			System.out.println(mapaReferencia);
		}
		
		System.out.println();
		
		//Mapear segundo Array
		while(entradaComparacao.hasNextLine()) {
			linhaArquivo = entradaComparacao.nextLine();
			
			mapaComparacao = mapearLayout(linhaArquivo);
			arrayComparacao.add(mapaComparacao.values().toString());
			System.out.println(mapaComparacao);
		}	
	
		
		//Buscar valor de um array no outro
		for(int i = 0; i < arrayReferencia.size(); i++) {
			contem = arrayComparacao.contains(arrayReferencia.get(i));
			if(!contem) {
				bw.write(arrayReferencia.get(i));
			}
		}
		
		entradaReferencia.close();
		entradaComparacao.close();
		bw.close();
		
	}
	
	public static HashMap<String, String> mapearLayout(String linha) {
		HashMap<String, String> linhaMapeada = new HashMap<String, String>();
		
		if(linha.startsWith("A0")) {
			linhaMapeada.put("Código_do_registro", quebrarLinha(2));
			linhaMapeada.put("Versão_do_layout", quebrarLinha(6));
			linhaMapeada.put("Data_Requisitada", quebrarLinha(8));
			linhaMapeada.put("Horário_Atual", quebrarLinha(6));
			linhaMapeada.put("Número_da_geração", quebrarLinha(6));
			linhaMapeada.put("Nome_do_Adquirente", quebrarLinha(30));
			linhaMapeada.put("VAN", quebrarLinha(4));
			linhaMapeada.put("Comércio", quebrarLinha(9));
			linhaMapeada.put("Tipo_de_processamento", quebrarLinha(1));
			
		} else if(linha.startsWith("CC")) {
			linhaMapeada.put("Código_do_registro", quebrarLinha(2));
			linhaMapeada.put("Documento_do_cliente", quebrarLinha(15));
			linhaMapeada.put("NSU_Transação", quebrarLinha(12));
			linhaMapeada.put("Data_da_Fechamento_da_Taxa", quebrarLinha(8));
			linhaMapeada.put("Número_Total_de_Parcelas", quebrarLinha(2));
			linhaMapeada.put("NSU_Cancelamento", quebrarLinha(12));
			linhaMapeada.put("Data_Compra", quebrarLinha(8));
			linhaMapeada.put("Hora_Compra", quebrarLinha(6));
			linhaMapeada.put("Meio_de_Captura", quebrarLinha(1));
			linhaMapeada.put("RRN_/_Código_do_Pedido", quebrarLinha(30));
			
		} else if(linha.startsWith("CV")) {
			linhaMapeada.put("Código_do_registro", quebrarLinha(2));
			linhaMapeada.put("Documento_do_cliente", quebrarLinha(15));
			linhaMapeada.put("NSU_Transação", quebrarLinha(12));
			linhaMapeada.put("Data_do_Fechamento_do_Cupom", quebrarLinha(8));
			linhaMapeada.put("Hora_do_Fechamento_do_Cupom", quebrarLinha(6));
			linhaMapeada.put("Tipo_de_Lançamento", quebrarLinha(1));
			linhaMapeada.put("Data_Fechamento_Movimento", quebrarLinha(8));
			linhaMapeada.put("Tipo_de_Produto", quebrarLinha(1));
			linhaMapeada.put("Meio_de_Captura", quebrarLinha(1));
			linhaMapeada.put("Valor_bruto", quebrarLinha(11));
			linhaMapeada.put("Valor_desconto", quebrarLinha(11));
			linhaMapeada.put("Valor_Líquido", quebrarLinha(11));
			linhaMapeada.put("Número_do_cartão", quebrarLinha(19));
			linhaMapeada.put("Número_da_Parcela_Atual", quebrarLinha(2));
			linhaMapeada.put("Número_Total_de_Parcelas", quebrarLinha(2));
			linhaMapeada.put("NSU_Histórico_Parcela_(12 últimos)", quebrarLinha(12));
			linhaMapeada.put("Valor_Bruto_da_Parcela", quebrarLinha(11));
			linhaMapeada.put("Valor_Desconto_da_Parcela", quebrarLinha(11));
			linhaMapeada.put("Valor_Líquido_da_Parcela", quebrarLinha(11));
			linhaMapeada.put("Banco", quebrarLinha(3));
			linhaMapeada.put("Agência", quebrarLinha(6));
			linhaMapeada.put("Conta", quebrarLinha(11));
			linhaMapeada.put("Código_Autorização", quebrarLinha(12));
			linhaMapeada.put("Bandeira", quebrarLinha(3));
			linhaMapeada.put("Id_Produto", quebrarLinha(3));
			linhaMapeada.put("Valor_Tx_Interchange_/_Tarifa", quebrarLinha(11));
			linhaMapeada.put("Valor_taxa_administradora", quebrarLinha(11));
			linhaMapeada.put("Valor_Tx_Interchange_/_Tarifa_Parcela", quebrarLinha(11));
			linhaMapeada.put("Taxa_da_Administradora_na_Parcela", quebrarLinha(11));
			linhaMapeada.put("Valor_redutor_Multi-Fronteira", quebrarLinha(11));
			linhaMapeada.put("Valor_taxa_antecipação", quebrarLinha(11));
			linhaMapeada.put("Tipo_de_transação", quebrarLinha(2));
			linhaMapeada.put("RRN_/_Código_do_Pedido", quebrarLinha(30));
			linhaMapeada.put("Sigla_do_País", quebrarLinha(3));
			linhaMapeada.put("Id_Terminal", quebrarLinha(8));
			linhaMapeada.put("Reservado", quebrarLinha(43));
			
		} else if(linha.startsWith("AJ")) {
			linhaMapeada.put("Código_do_registro", quebrarLinha(2));
			linhaMapeada.put("Documento_do_cliente", quebrarLinha(15));
			linhaMapeada.put("NSU_Host_da_Transação_Original", quebrarLinha(12));
			linhaMapeada.put("Data_da_Transação_Original", quebrarLinha(8));
			linhaMapeada.put("Número_da_Parcela_Atual", quebrarLinha(2));
			linhaMapeada.put("NSU_Host_da_Transação", quebrarLinha(12));
			linhaMapeada.put("Data_do_Ajuste", quebrarLinha(8));
			linhaMapeada.put("Hora_do_Ajsute", quebrarLinha(6));
			linhaMapeada.put("Tipo_de_Lançamento", quebrarLinha(1));
			linhaMapeada.put("Liquidação_do_Lançamento", quebrarLinha(8));
			linhaMapeada.put("Meio_de_Caputura", quebrarLinha(1));
			linhaMapeada.put("Tipo_de_Ajuste", quebrarLinha(1));
			linhaMapeada.put("Código_do_Ajuste", quebrarLinha(3));
			linhaMapeada.put("Descrição_do_Ajsute", quebrarLinha(30));
			linhaMapeada.put("Valor_Bruto", quebrarLinha(11));
			linhaMapeada.put("Valor_Desconto_Comissão", quebrarLinha(11));
			linhaMapeada.put("Valor_Líquido", quebrarLinha(11));
			//linhaMapeada.put("Número_da_Parcela_Atual", );
			//linhaMapeada.put("Valor_Líquido_da_Parcela", );
			linhaMapeada.put("Banco", quebrarLinha(3));
			linhaMapeada.put("Agência", quebrarLinha(6));
			linhaMapeada.put("Conta", quebrarLinha(11));
			linhaMapeada.put("Número_do_Cartão", quebrarLinha(19));
			linhaMapeada.put("Código_da_Bandeira", quebrarLinha(3));
			linhaMapeada.put("Código_do_Produto", quebrarLinha(3));
			linhaMapeada.put("Valor_Bruto_da_Antecipação", quebrarLinha(11));
			linhaMapeada.put("Valor_Líquido_da_Antecipação", quebrarLinha(11));
			linhaMapeada.put("RRN_/_Código_do_Pedido", quebrarLinha(30));
		
		}
		return linhaMapeada;
	}
	
	public static String quebrarLinha(int tamanho) {
		String linhaRetorno = Teste.linhaArquivo.substring(0, tamanho);
		Teste.linhaArquivo = Teste.linhaArquivo.substring(tamanho, Teste.linhaArquivo.length());
		
		return linhaRetorno;
	}
	
	
}
