/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universidades.dao;

/**
 *
 * @author Josue
 */
public class Universidad {

    /**
     * @return the _id
     */
    public double getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(double _id) {
        this._id = _id;
    }

    /**
     * @return the _siglas
     */
    public String getSiglas() {
        return _siglas;
    }

    /**
     * @param _siglas the _siglas to set
     */
    public void setSiglas(String _siglas) {
        this._siglas = _siglas;
    }

    /**
     * @return the _nombrecomple
     */
    public String getNombrecomple() {
        return _nombrecomple;
    }

    /**
     * @param _nombrecomple the _nombrecomple to set
     */
    public void setNombrecomple(String _nombrecomple) {
        this._nombrecomple = _nombrecomple;
    }

    /**
     * @return the _rector
     */
    public String getRector() {
        return _rector;
    }

    /**
     * @param _rector the _rector to set
     */
    public void setRector(String _rector) {
        this._rector = _rector;
    }
    
    
    
    private double _id;
    private String _siglas;
    private String _nombrecomple;
    private String _rector;

  
            
    
}
