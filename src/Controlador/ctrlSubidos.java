/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Subidos;
import Vista.jpSubidos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author edeni
 */


public class ctrlSubidos implements MouseListener  {
    
  private jpSubidos Vista;
  private Subidos Modelo;
    
    public ctrlSubidos(jpSubidos vista, Subidos modelo) {
        this.Vista = vista;
        this.Modelo = modelo;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
