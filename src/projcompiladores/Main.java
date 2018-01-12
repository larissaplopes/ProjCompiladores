/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projcompiladores;

import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Larissa
 */
public class Main {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      
//      String comandoUsuario = JOptionPane.showInputDialog("Digite um comando:");
      Comandos[] listaComando = new Comandos[5];
      LinkedList<String> sinonimo = new LinkedList<String>();
      LinkedList<Palavra> comando = new LinkedList<Palavra>();
      String palavra;
      boolean valido = false;
      int validoInt = 0;
      
      //1
      palavra = "ligar";
      sinonimo.add("ligacao");
      sinonimo.add("telefonar");
      sinonimo.add("chamar");
      comando.add(new Palavra(palavra, sinonimo));
      listaComando[0] = new Comandos(comando);
      //2
      comando = new LinkedList<Palavra>();
      sinonimo = new LinkedList<String>();
      palavra = "mandar";
      sinonimo.add("enviar");
      sinonimo.add("transmitir");
      sinonimo.add("remeter");
      sinonimo.add("comunicar");
      comando.add(new Palavra(palavra, sinonimo));
      
      sinonimo = new LinkedList<String>();
      palavra = "mensagem";
      sinonimo.add("texto");
      sinonimo.add("sms");
      sinonimo.add("recado");
      comando.add(new Palavra(palavra, sinonimo));
      listaComando[1] = new Comandos(comando);
      //3
      comando = new LinkedList<Palavra>();
      sinonimo = new LinkedList<String>();
      palavra = "abrir";
      sinonimo.add("acionar");
      comando.add(new Palavra(palavra, sinonimo));
      listaComando[2] = new Comandos(comando);
      //4
      comando = new LinkedList<Palavra>();
      sinonimo = new LinkedList<String>();
      palavra = "aumentar";
      sinonimo.add("subir");
      sinonimo.add("ampliar");
      sinonimo.add("amplificar");
      comando.add(new Palavra(palavra, sinonimo));
      
      sinonimo = new LinkedList<String>();
      palavra = "volume";
      sinonimo.add("som");
      sinonimo.add("audio");
      comando.add(new Palavra(palavra, sinonimo));
      listaComando[3] = new Comandos(comando);
      //5
      comando = new LinkedList<Palavra>();
      sinonimo = new LinkedList<String>();
      palavra = "diminuir";
      sinonimo.add("baixar");
      sinonimo.add("decrescer");
      sinonimo.add("encolher");
      comando.add(new Palavra(palavra, sinonimo));
      
      sinonimo = new LinkedList<String>();
      palavra = "volume";
      sinonimo.add("som");
      sinonimo.add("audio");
      comando.add(new Palavra(palavra, sinonimo));
      listaComando[4] = new Comandos(comando);
      //fim comando     
//      Lexico lex = new Lexico(comandoUsuario);
      LinkedList<Tokens> tabela = new LinkedList<Tokens>();
      String comandoUsuario = "";
      tabela.add(new Tokens("eu", "pronome"));
      tabela.add(new Tokens("desejar", "verbo"));
      tabela.add(new Tokens("poder", "verbo"));
      tabela.add(new Tokens("aumentar", "verbo"));
      tabela.add(new Tokens("som", "substantivo"));
      Sintatico sint = new Sintatico(tabela);
//      Sintatico sint = new Sintatico(lex.getTabela());
      
      for(Tokens t : tabela){
         comandoUsuario += t.getPalavra() + " ";
      }
      System.out.println(comandoUsuario);
//      if(sint.AnalisadorSint()){
//         //1
//         
//         if(comandoUsuario.contains(listaComando[0].getComando().get(0).getPalavra())){
//            System.out.println("Comando aceito"); System.exit(0);
//         }
//      }
//      
         
         
      
      if(sint.AnalisadorSint()){
         System.out.println("oiS");
         validade:
         for(int i = 0; i < listaComando.length; i++){
            if(listaComando[i].getComando().size() > 1){
               if(comandoUsuario.contains(listaComando[i].getComando().get(0).getPalavra())){
                  if (comandoUsuario.contains(listaComando[i].getComando().get(1).getPalavra())) {
                     valido = true;
                     break validade;
                  }else{
                     for(int j = 0; j < listaComando[i].getComando().get(1).getSinonimo().size(); j++){
                        if(comandoUsuario.contains(listaComando[i].getComando().get(1).getSinonimo().get(j))){
                           valido = true;
                           break validade;
                        }
                     }
                  }
               }else{
                  System.out.println("oiE");
                  for(int k = 0; k < listaComando[i].getComando().get(0).getSinonimo().size(); k++){
                     if(comandoUsuario.contains(listaComando[i].getComando().get(0).getSinonimo().get(k))){
                        if(comandoUsuario.contains(listaComando[i].getComando().get(1).getPalavra())){
                           valido = true;
                           break validade;
                        }else{
                           for(int l = 0; l < listaComando[i].getComando().get(1).getSinonimo().size(); l++){
                              if(comandoUsuario.contains(listaComando[i].getComando().get(1).getSinonimo().get(l))){
                                 valido = true;
                                 break validade;
                              }
                           }
                        }
                     }
                  }
               }
            }else{//if tamanho
               if(comandoUsuario.contains(listaComando[i].getComando().get(0).getPalavra())){
                  valido = true;
                  break validade;
               }else{
                  for(int m = 0; m < listaComando[i].getComando().get(0).getSinonimo().size(); m++){
                     if(comandoUsuario.contains(listaComando[i].getComando().get(0).getSinonimo().get(m))){
                        valido = true;
                        break validade;
                     }
                  }
               }
            }
         }//for
            /*
         for(int i = 0; i < listaComando.length; i++){
            if(comandoUsuario.contains(listaComando[i].getComando().get(0).getPalavra())){
               if(listaComando[i].getComando().get(1) != null && comandoUsuario.contains(listaComando[i].getComando().get(1).getPalavra())){
                  valido = true;
                  break validade;
               }else if(listaComando[i].getComando().get(1) != null){
                  for(int j = 0; j < listaComando[i].getComando().get(1).getSinonimo().size(); j++){
                     if (comandoUsuario.contains(listaComando[i].getComando().get(1).getSinonimo().get(j))) {
                        valido = true;
                        break validade;
                     }
                  }
               }
            }else{
               for(int k = 0; k < listaComando[i].getComando().get(0).getSinonimo().size(); k++){
                  if(comandoUsuario.contains(listaComando[i].getComando().get(0).getSinonimo().get(k))){
                     if(listaComando[i].getComando().get(1) != null && listaComando[i].getComando().get(1) != null && comandoUsuario.contains(listaComando[i].getComando().get(1).getPalavra())){
                        valido = true;
                        break validade;
                     }else if(listaComando[i].getComando().get(1) != null){
                        for(int l = 0;l < listaComando[i].getComando().get(1).getSinonimo().size(); l++){
                           if(comandoUsuario.contains(listaComando[i].getComando().get(1).getSinonimo().get(l))){
                              valido = true;
                              break validade;
                           }
                        }
                     }
                  }
               }
            }//else
         }//for listaComando
         */
         if(valido){
            System.out.println("Comando aceito");
         }
      }//if Sintatico 
   }
}
