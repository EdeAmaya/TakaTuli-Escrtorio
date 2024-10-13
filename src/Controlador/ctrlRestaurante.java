/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Restaurante;
import Vista.jpRestaurante;

/**
 *
 * @author jluis
 */
public class ctrlRestaurante {
     private jpRestaurante Vista;
    private Restaurante Modelo;
    
    public ctrlRestaurante(jpRestaurante vista, Restaurante modelo){
    
        this.Vista = vista;
        this.Modelo = modelo;
        
    }
}
