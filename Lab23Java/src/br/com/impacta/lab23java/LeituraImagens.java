package br.com.impacta.lab23java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LeituraImagens {
	public static final String PATH_IMAGEM = "C://Windows";
	public static final String UNIDADE = "c:";
	public static final String DIRETORIO = "frutas";
	public static final String DADOS = "_catalogo";
	public static final String ARQUIVO = "frutas.html";

	// ---------------------------------------------------------------
	/**
	 * M�todo construtor da classe LeituraImagens
	 */
	public LeituraImagens() {
		File diretorio = new File(UNIDADE + File.separator + DIRETORIO);

		try {
			String diretorio_principal = UNIDADE + File.separator + DIRETORIO + File.separator + DADOS;
			
			System.out.println(diretorio_principal);

			File dp = new File(diretorio_principal);

			// Se o diret�rio n�o existir, cria ele
			if (!dp.exists()) {
				dp.mkdirs();
			}

			String diretorio_principal_arquivo = diretorio_principal
					+ File.separator + ARQUIVO;

			File dpa = new File(diretorio_principal_arquivo);

			// Se n�o existir o arquivo
			if (!dpa.exists()) {
				
				FileWriter fw = new FileWriter(dpa);
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write("<html><body><center><table>");
				bw.newLine();

				// Listar os arquivos dentro da pasta
				for (File imagem : diretorio.listFiles()) {

					if (imagem.isFile()) {
						// Obt�m o nome do arquivo, sem a extens�o e converte para ma�usculo
						String nome = imagem.getName().split("\\.")[0].toUpperCase();

						// Cria um arquivo html com o nome dos arquivos
						bw.write("<tr><td>");
						bw.write("<font face=verdada size=12");
						bw.write(nome);
						bw.write("</tr></td>");
						bw.newLine();

						System.out.println(nome);
					}
				}
				
				bw.write("</table></center></body></html>");
				bw.flush();
				bw.close();
				fw.close();
				System.out.println("Arquivo criado com sucesso");

			} else {
				System.out.println("Arquivo j� existe");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ---------------------------------------------------------------

	// ---------------------------------------------------------------
	/**
	 * Listar pastas e arquivos
	 * 
	 * @param diretorio
	 */
	private void listarPastasArquivos(File diretorio) {

		try {
			System.out.println(diretorio.getAbsolutePath());
			System.out.println(diretorio.getCanonicalPath());
			System.out.println(diretorio.getFreeSpace());
			System.out.println(diretorio.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Listar diret�rios e arquivos dentro da pasta
		for (File file : diretorio.listFiles()) {
			System.out.print(file);

			if (file.isDirectory()) {
				System.out.println("--> � um diret�rio");
			} else if (file.isFile()) {
				System.out.println("--> � um arquivo");
			}
		}
	}
	// ---------------------------------------------------------------
}