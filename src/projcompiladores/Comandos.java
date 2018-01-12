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
public class Comandos {
   private LinkedList<Palavra> comando;
   
   public Comandos(LinkedList<Palavra> c){
      this.comando = c;
      
   }

   public LinkedList<Palavra> getComando() {
      return comando;
   }   
}
