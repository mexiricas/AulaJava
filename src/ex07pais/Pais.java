/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex07pais;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class Pais {
    private String codigo;
    private String nome;
    private String capital;
    private long populacao;
    private long area;
    private ArrayList<String> vizinhos;
    
    Pais (String codigo, String nome, String capital,
            long populacao, long area)
    {
        this.codigo = codigo.toUpperCase();
        this.nome = nome;
        this.capital = capital;
        this.populacao = populacao;
        this.area = area;
        
        // inciar a lista de paises vizinhos
        vizinhos = new ArrayList<String>();
    }
    
    public void addVizinho(String codigo) {
        if (vizinhos.indexOf(codigo) < 0)
            vizinhos.add(codigo.toUpperCase());
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo.toUpperCase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public ArrayList<String> getVizinhos() {
        return vizinhos;
    }

    public boolean equals(Pais p) {
        return codigo.equals(p.codigo);
    }

    public boolean seVizinho (Pais p){
        for (int i = 0; i < vizinhos.size(); ++i){
            if (p.codigo.equals(vizinhos.get(i)))
                return true;
        }
        
        return false;
    }
    
    public float densidade () {
        if (area == 0.0f)
            return 0.0f;
        else
            return (float)populacao / area;
    }
    
    public ArrayList<String> vizinhosEmComum(Pais p) {
        ArrayList<String> emComum = new ArrayList<String>();
        
        int i;
        String cod1;
        for (i = 0; i < vizinhos.size(); ++i) {
            cod1 = vizinhos.get(i);
            if (p.vizinhos.indexOf(cod1) >= 0)
                emComum.add(cod1);
        }
        
        return emComum;
    }
    
    public void mostraDados () {
        System.out.println (codigo + " - " + nome);
        System.out.println ("    Capital: " + capital);
        
        System.out.println ("    Populacao: " +
                NumberFormat.getNumberInstance().format(populacao));
        
        System.out.println ("    Área: " +
                NumberFormat.getNumberInstance().format(area) + " Km2");
        
        if (vizinhos.size() > 0)
        {
            System.out.print ("    Vizinhos:");
            for (String str : vizinhos) {
                System.out.print(" " + str);
            }
            System.out.println();
        }
    }
}

