/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projcompiladores;

import java.util.LinkedList;

/**
 *
 * @author Larissa
 */
public class Lexico {
   private String comandoUsuario;
   private LinkedList<Tokens> tabela;
   
   public Lexico(String c){
      this.comandoUsuario = c;
      String[] token;
      token = comandoUsuario.split(" ");
      for(String s : token){
         ;
      }
      
   }

   public LinkedList<Tokens> getTabela() {
      return tabela;
   }
   
   
}
