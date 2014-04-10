/**
 * HoraServidorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.beco.consumoservicio;


public interface HoraServidorService extends javax.xml.rpc.Service {
    public java.lang.String getHoraServidorAddress();

    public com.beco.consumoservicio.HoraServidor getHoraServidor() throws javax.xml.rpc.ServiceException;

    public com.beco.consumoservicio.HoraServidor getHoraServidor(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
