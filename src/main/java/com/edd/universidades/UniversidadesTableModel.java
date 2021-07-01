/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edd.universidades;

import com.universidades.dao.Universidad;
import java.util.Arrays;

/**
 *
 * @author Josue
 */
public class UniversidadesTableModel extends GenericDomainTableModel<Universidad> {
    
    public UniversidadesTableModel(){
     super( Arrays.asList( new Object[]{"Código", "Siglas", "Nombre", "Rector"} ));
    
    }
    
    @Override
    public Class<?> getColumnClass(int colIndex){
        switch(colIndex){
            case 0:
                return Double.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
        }
        throw new ArrayIndexOutOfBoundsException(colIndex);
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Universidad item = getDomainObject(rowIndex);
        switch(colIndex){
            case 0:
                return item.getId();
            case 1:
                return item.getSiglas();
            case 2:
                return item.getNombrecomple();
            case 3:
                return item.getRector();
        }
        throw new ArrayIndexOutOfBoundsException(colIndex);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int colIndex){
       // return rowIndex>0 && colIndex > 1;
       return false;
    }
   
    @Override
    public void setValueAt(Object valor, int rowIndex, int colIndex){
        ///Implementación
        
        //Dispanara un Evento de Notificacion
        notifyTableCellUpdated(rowIndex, colIndex);
    } 
    
}
