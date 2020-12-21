/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.jaumebalmes.pguitart.excepcionsmain;

/**
 *
 * @author pere
 */
public class NoMajorQue10Exception extends Exception {

    public NoMajorQue10Exception(String no_es_mes_gran_que_10) {
        super(no_es_mes_gran_que_10);
    }
    
}
