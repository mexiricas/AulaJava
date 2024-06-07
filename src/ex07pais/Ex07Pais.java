/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex07pais;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Ex07Pais {
    
    final private static Scanner leia = new Scanner (System.in);
    final static private String NOME_ARQ_PAISES = "paises.txt";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ArrayList<Pais> paises = new ArrayList<>();
         ArrayList<Continente> continentes = new ArrayList<Continente>();
        int opcao=0;
        
       do{
           opcao=menu();
            switch (opcao) {
                
                case 1: IncluirContinente(continentes);break;
                case 2: ListarContinentes(continentes);break;
                case 3: incluiPais(paises); break;
                case 4: incluiVizinhos(paises); break;
                case 5: listarPaises(paises); break;
                case 6: paisesVizinhos(paises); break;
                case 7: densidadePopulacional(paises); break;
                case 8: vizinhosEmComum(paises); break;
                case 9: lerDados(paises); break;
                case 10: gravarDados(paises); break;
                case 11: System.out.println("@@@ -- OBRIGADO-- @@@");break;
            }
             
        }while (opcao!=11);
                
                    
            
    }
    static void IncluirContinente(ArrayList<Continente> continentes){
       
        
        String nome_continente;
        long total_dimensao;
        long total_populacao;
        long total_densidadepopulacional;
        long maior_populacao;
        long menor_populacao;
        long maior_dimensao;
        long menor_dimensao;
        String razao_maior_menor;
        int qdt_paises;
        
        
        System.out.println("Continente Incluido..:");
         while(true) {
            System.out.println();
            System.out.println("----------------------------------------------");
            System.out.println("           Inclusão de Continentes..:         ");
            System.out.print("   Nome do Continente (ou 'Fim' para encerrar): ");
            nome_continente = leia.next();
            
            if (nome_continente.equalsIgnoreCase("fim"))
                break;
            
             System.out.println("Digite a dimensão do continente");
             total_dimensao = leia.nextLong();
             
             System.out.println("Digite a população do continente");
             total_populacao = leia.nextLong();
             
             System.out.println("Digite a quantidade de paises do continente");
             qdt_paises = leia.nextInt();
             
             Continente novo;
             
             novo = new Continente(nome_continente,  total_dimensao,  total_populacao, qdt_paises);
             
             continentes.add(novo);
             
         }
    }
    
    static void ListarContinentes(ArrayList<Continente>continentes){
        
    
      for(Continente p: continentes){
          p.mostrarContinentes();
          }
      System.out.println(continentes);
            if(continentes.isEmpty()){
              System.out.println("+=========Lista Vazia===========+" +"\n");
              System.out.println();
            }
    }
    
    private static int menu(){
        System.out.println();
        System.out.println("+============================+");
        System.out.println("|        O P Ç Õ E S         |");
        System.out.println("+============================+");
        System.out.println("+============menu============+");
        System.out.println("| 1. Inserir um Continente   |");
        System.out.println("| 2. Listar Continente       |");
        System.out.println("| 3. Inserir País            |");
        System.out.println("| 4. incluiVizinhos          |");
        System.out.println("| 5. Listar País             |");
        System.out.println("| 6. Países são Vizinhos?    |");
        System.out.println("| 7. Densidade Populacional  |");
        System.out.println("| 8. Vizinhos em Comum       |");
        System.out.println("| 9. Ler Dados em Arquivo    |");
        System.out.println("| 10. Gravar Dados em Arquivo|");
        System.out.println("| 11. Encerrar o Programa    |");
        System.out.println("+============================+");
        
        int opcao;
         do {
            try {
                System.out.print("Digite a sua opção (1 a 11): ");
                opcao = leia.nextInt();
            }
            catch (InputMismatchException e){ 
             opcao=0;
              System.out.print("Digite a sua opção (1 a 11): ");
                
            }
            
            }while (opcao < 1 || opcao > 11);
         return opcao; 
    }
    
    // verificar se país já foi inserido na lista
    private static Pais buscaPais (ArrayList<Pais> paises, String codigo) {
        for (Pais p: paises) {
            if (p.getCodigo().compareToIgnoreCase(codigo) == 0) {
                return p;
            }
        }

        return null;
    }
    
    private static void incluiPais (ArrayList<Pais> paises) {
        Pais novo;
        String codigo;
        String nome;
        String capital;
        long populacao;
        long area;

        while(true) {
            System.out.println();
            System.out.println("----------------");
            System.out.println("Inclusão de País:");
            System.out.print("   Código ISO (ou 'Fim' para encerrar): ");
            codigo = leia.next();
            
            if (codigo.equalsIgnoreCase("fim"))
                break;

            // verificar se país já foi inserido na lista
            if (buscaPais (paises, codigo) != null) {
                System.out.println("ERRO: País já cadastrado.");
                continue;
            }
            System.out.print("   Nome.....: ");
            do {
                nome = leia.nextLine();
            }while (nome.isEmpty());
            
            System.out.print("   Capital..: ");
            do {
                capital = leia.nextLine();
            }while (capital.isEmpty());
            
            System.out.print("   População: ");
            populacao = leia.nextLong();
            
            System.out.print("   Área.....: ");
            area = leia.nextLong();
            
            novo = new Pais (codigo, nome, capital, populacao, area);
            paises.add(novo);
        }
    }
    
    private static void listarPaises (ArrayList<Pais> paises) {
        for (Pais p: paises) {
            p.mostraDados();
            System.out.println();
        }
    }
    
    private static void incluiVizinhos (ArrayList<Pais> paises) {
        String codigo;
        
        while (true) {
            System.out.println();
            System.out.println("----------------");
            System.out.println("Inclusão de Vizinhos:");

            System.out.print("   Código ISO do País(ou 'Fim' para encerrar): ");
            codigo = leia.next();
            if (codigo.equalsIgnoreCase("fim"))
                break;

            // verificar se país já foi inserido na lista
            Pais p = buscaPais (paises, codigo);
            if (p == null) {
                System.out.println("ERRO: País não encontrado.");
                continue;
            }
            
            // inclusao dos vizinhos
            while (true) {
                System.out.print("   Código ISO do Vizinho(ou 'Fim' para encerrar): ");
                codigo = leia.next();
                if (codigo.equalsIgnoreCase("fim"))
                    break;
                
                if (codigo.equalsIgnoreCase(p.getCodigo())){
                    System.out.println("ERRO: país não pode ser vizinho dele mesmo.");
                    continue;
                }
                
                // verifica se código do vizinho é válido
                if(buscaPais (paises, codigo) == null){
                    System.out.println("ERRO: Vizinho não encontrado.");
                }
                else {
                    // adiciona vizinho
                    p.addVizinho(codigo);
                }
            }
        }
    }
    
    private static void densidadePopulacional(ArrayList<Pais> paises) {
        String codigo;
        
        while (true) {
            System.out.println();
            System.out.println("----------------");
            System.out.println("Densidade Populacional:");

            System.out.print("   Código ISO do País(ou 'Fim' para encerrar): ");
            codigo = leia.next();
            if (codigo.equalsIgnoreCase("fim"))
                break;

            // verificar se país já foi inserido na lista
            Pais p = buscaPais (paises, codigo);
            if (p == null) {
                System.out.println("ERRO: País não encontrado.");
                continue;
            }
            
            // mostra a densidade populacional do país
            System.out.println ("Densidade Populacional: " +
                    NumberFormat.getNumberInstance().format(p.densidade()) +
                    " habitantes / Km2");
            
        }
    }
    
    private static void lerDados(ArrayList<Pais> paises) {
        File arquivo = new File(NOME_ARQ_PAISES);
        Pais p;
        String linha;
        String[] vet;
        int i;

        if (!arquivo.exists())
                return;

        try
        {
            //faz a leitura do arquivo
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            // leitura dos dados dos paises (enquanto houver linhas)
            while (br.ready())
            {
                //lê a proxima linha
                linha = br.readLine();
                vet = linha.split(";");

                p = new Pais (vet[0], vet[1], vet[2],
                              Long.parseLong(vet[3]),
                              Long.parseLong(vet[4]));
                paises.add (p);
                
                // adiciona vizinhos
                for (i = 5; i < vet.length; ++i) {
                    p.addVizinho(vet[i]);
                }
            }

            br.close();
            fr.close();
            
            System.out.println ("Dados lidos com sucesso!");
            System.out.println ("Total de países lidos: " + paises.size());

        } catch (IOException ex) {
            System.out.println ("ERRO: leitura do arquivo de dados!");
        }
    }
    
    private static void gravarDados(ArrayList<Pais> paises) {
        File arquivo = new File(NOME_ARQ_PAISES);
        ArrayList<String> vizinhos;

        try
        {
            // cria o arquivo (caso ele não exista)
            arquivo.createNewFile();

            // variáveis para manipulação do arquivo
            FileWriter fw = new FileWriter(arquivo, false);
            BufferedWriter bw = new BufferedWriter(fw);

            // grava dados das contas
            String linha;   // dados a serem gravados no arquivo
            Pais p;
            int j;
            for (int i = 0; i < paises.size(); ++i)
            {
                p = paises.get(i);
                linha = p.getCodigo() + ";" + p.getNome() + ";" +
                        p.getCapital() + ";" +
                        Long.toString(p.getPopulacao()) + ";" +
                        Long.toString(p.getArea());
                
                // adiciona vizinhos
                vizinhos = p.getVizinhos();
                for (j = 0; j < vizinhos.size(); ++j) {
                    linha += ";" + vizinhos.get(j);
                }
                
                bw.write(linha);
                bw.newLine();
            }

            bw.close();
            fw.close();
            
            System.out.println ("Dados gravados com sucesso!");
            System.out.println ("Total de países gravados: " + paises.size());

        } catch (IOException ex) {
            System.out.println("ERRO: gravação do arquivo de dados!");
        }    
    }
    
    // dados dois países, indicam se eles são vizinhos
    private static void paisesVizinhos(ArrayList<Pais> paises){
        String codigo;
        int i;
        boolean bFim = false;
        Pais p, p1 = null, p2 = null;
        
        while (true) {
            System.out.println();
            System.out.println("----------------");
            System.out.println("Indica se dois países são vizinhos:");

            i = 0;
            while (i < 2) {
                System.out.print("   Código ISO do " + (i + 1) + "o. País(ou 'Fim' para encerrar): ");
                codigo = leia.next();
                if (codigo.equalsIgnoreCase("fim"))
                {
                    bFim = true;
                    break;
                }

                // verificar se país já foi inserido na lista
                p = buscaPais (paises, codigo);
                if (p == null) {
                    System.out.println("ERRO: País não encontrado.");
                    continue;
                }
                
                if (i == 0)
                    p1 = p;
                else
                    p2 = p;
                ++i;
            }
            if (bFim)
                break;
            
            // verifica se paises sao vizinhos
            System.out.print (p1.getCodigo() + " e " + p2.getCodigo());
            if (p1.seVizinho (p2))
                System.out.println (" são vizinhos!");
            else
                System.out.println (" não são vizinhos!");
            
        }
    }

    // dados dois países, lista os vizinhos em comum entre os dois países
    private static void vizinhosEmComum(ArrayList<Pais> paises){
        String codigo;
        int i, j;
        boolean bFim = false, bAchou;
        Pais p;
        ArrayList<String> v1 = null, v2 = null;
        
        while (true) {
            System.out.println();
            System.out.println("----------------");
            System.out.println("Lista vizinhos em comum entre dois países:");

            i = 0;
            while (i < 2) {
                System.out.print("   Código ISO do " + (i + 1) + "o. País(ou 'Fim' para encerrar): ");
                codigo = leia.next();
                if (codigo.equalsIgnoreCase("fim"))
                {
                    bFim = true;
                    break;
                }

                // verificar se país já foi inserido na lista
                p = buscaPais (paises, codigo);
                if (p == null) {
                    System.out.println("ERRO: País não encontrado.");
                    continue;
                }
                
                if (i == 0)
                    v1 = p.getVizinhos();
                else
                    v2 = p.getVizinhos();
                ++i;
            }
            if (bFim)
                break;
            
            // lista vizinhos em comum
            bAchou = false;
            System.out.print ("Vizinhos em comum:");
            for (i = 0; i < v1.size(); ++i){
                if (v2.indexOf(v1.get(i)) >= 0)
                {
                    bAchou = true;
                    System.out.print (" " + v1.get(i));
                }
            }
            if (bAchou)
                System.out.println ("");
            else
                System.out.println (" nenhum.");

        }
    }
    
}
