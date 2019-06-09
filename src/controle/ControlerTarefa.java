/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JPanel;
import tela.InternoJfTelaTarefa;

/**
 *
 * @author Diana
 */
public class ControlerTarefa {
     private final InternoJfTelaTarefa view;

    public ControlerTarefa(InternoJfTelaTarefa view) {
        this.view = view;
    }
    
  
  public void TrocaTarefas(JPanel tela){
      view.getjLayeredPaneGereTarefa().removeAll();
         view.getjLayeredPaneGereTarefa().add(tela);
        view.getjLayeredPaneGereTarefa().repaint();
        view.getjLayeredPaneGereTarefa().revalidate();
  }

}
