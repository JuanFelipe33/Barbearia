/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barbearia;

import java.util.Random;

/**
 *
 * @author Juan
 */
public class Barbearia implements Runnable{
    private int cadeiraEspera;
    private boolean cadeiraOcupada =  false;
    private int[] clientes;
    private boolean barbeiroDorme =  false;
    private String nome;
    private int cliNovos;
    private int nCli = 0;

    public Barbearia(int cadeiraEspera,int cliNovos, String nome) {//construtor da barbearia
        this.cadeiraEspera = cadeiraEspera;
        this.cliNovos =cliNovos;
        this.nome = nome;
        System.out.println(" O barbeiro " + nome + " abriu o salão!" );
    }
    
   public void Cliente(){
       Random r = new Random();//gera o numero aleatorio
       nCli = r.nextInt(cliNovos);//gera o total de clientes
       clientes = new int[nCli];//tamanho do vetor
       for(int i = 0; nCli < clientes.length; i++){//povoa o array  de clientes
           clientes[i] = i;
       }
   } 
    
   public void BarbeiroDorme()throws InterruptedException{
       System.out.println("Não existe clientes na barbearia de " + nome + ".");
       System.out.println("Como não existe clientes o barbeiro " + nome + " está esperando.");
       Thread.sleep(2000);//espera por 2 segundos
       System.out.println("A cadeira do barbeiro " + nome + " está livre.");
       //cria novos clientes
       Cliente();
   }
   
   public void BarbeiroAtende() throws InterruptedException{
       
       if(nCli != 0 ){
           if(nCli > 1 && cadeiraOcupada == false){//SE TIVER MAIS DE UM E A CADEIRA ESTIVER VAGA
               System.out.println("Mais " + nCli + " para ser antendido(s).");
           }
           else{
               System.out.println("Existem " + nCli + " na espera do atendimento.");
           }
       
       System.out.println("Um cliente ocupou a cadeira do barbeiro " +  nome + ".");
       nCli--;
       System.out.println("Um cliente está sendo atendido pelo barbeiro " + nome);
       cadeiraOcupada = true;
       Thread.sleep(1000);
       if(nCli > this.cadeiraEspera){
           int c = nCli - this.cadeiraEspera;
           this.nCli = this.nCli - c;
           for(int i = 0; i < this.clientes.length-1;i++){
               clientes[i] = 0;
           }
           for(int j = 0; j < nCli; j++){
               clientes[j] = j + 1;
           }
           System.out.println(c + " clientes foram embora.");
           System.out.println("Tem " + nCli + " esperando atendimento.");
       }
                   
           System.out.println("Um cliente foi atendido no na barbearia pelo " + nome + ".");
       } else if(nCli == 1){
           System.out.println("a cadeira do barbeiro " + nome + " está livre.");
           System.out.println("A cadeira do barbeiro " + nome + " está ocupada, e não existem clientes esperando.");
           Thread.sleep(1000);
           nCli --;
           System.out.println("Um cliente foi atendido pelo " + nome + ".");
   }
       else{
           System.out.println("A cadeira do barbeiro " + nome +  " está livre");
           this.cadeiraOcupada = false;
       }
   }
        
   
   
    @Override
    public void run() {
       while(true){
           if(nCli <= 0){
           try{
               BarbeiroDorme();
           }catch(InterruptedException ex){
               System.out.println(ex);
           }
           }
           else{
           try{
               BarbeiroAtende();
           }catch(InterruptedException ex){
               System.out.println(ex);
            }
           }
       }
    }
    
}
