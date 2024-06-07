/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex07pais;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author Denis
 */
public class Continente {
    
    
    String nome_continente;
    long total_dimensao;
    long total_populacao;
    long total_densidadepopulacional;
    long maior_populacao;
    long menor_populacao;
    long maior_dimensao;
    long menor_dimensao;
    int qdt_paises;
    String razao_maior_menor;

    public int getQdt_paises() {
        return qdt_paises;
    }

    public void setQdt_paises(int qdt_paises) {
        this.qdt_paises = qdt_paises;
    }
    

    public Continente(String nome_continente, long total_dimensao, long total_populacao, int qdt_paises) {
        this.nome_continente = nome_continente;
        this.total_dimensao = total_dimensao;
        this.total_populacao = total_populacao;
        this.qdt_paises = qdt_paises;
    }

    

    public String getNome_continente() {
        return nome_continente;
    }

    public void setNome_continente(String nome_continente) {
        this.nome_continente = nome_continente;
    }
    
    public long getTotal_dimensao() {
        return total_dimensao;
    }

    public void setTotal_dimensao(long total_dimensao) {
        this.total_dimensao = total_dimensao;
    }

    public long getTotal_populacao() {
        return total_populacao;
    }

    public void setTotal_populacao(long total_populacao) {
        this.total_populacao = total_populacao;
    }

    public long getTotal_densidadepopulacional() {
        return total_densidadepopulacional;
    }

    public void setTotal_densidadepopulacional(long total_densidadepopulacional) {
        this.total_densidadepopulacional = total_densidadepopulacional;
    }

    public long getMaior_populacao() {
        return maior_populacao;
    }

    public void setMaior_populacao(long maior_populacao) {
        this.maior_populacao = maior_populacao;
    }

    public long getMenor_populacao() {
        return menor_populacao;
    }

    public void setMenor_populacao(long menor_populacao) {
        this.menor_populacao = menor_populacao;
    }

    public long getMaior_dimensao() {
        return maior_dimensao;
    }

    public void setMaior_dimensao(long maior_dimensao) {
        this.maior_dimensao = maior_dimensao;
    }

    public long getMenor_dimensao() {
        return menor_dimensao;
    }

    public void setMenor_dimensao(long menor_dimensao) {
        this.menor_dimensao = menor_dimensao;
    }

    public String getRazao_maior_menor() {
        return razao_maior_menor;
    }

    public void setRazao_maior_menor(String razao_maior_menor) {
        this.razao_maior_menor = razao_maior_menor;
    }
    
    void mostrarContinentes(){
        System.out.println("Nome do Continente..:" + nome_continente );
        System.out.println("Quantidade de Paises nesse Continente..:" + qdt_paises );
       
        System.out.println("População...:" + NumberFormat.getNumberInstance().format(total_populacao));
        System.out.println("Área...: " + NumberFormat.getNumberInstance().format(total_dimensao) + "  km2");
        System.out.println("");
        
    }
}
