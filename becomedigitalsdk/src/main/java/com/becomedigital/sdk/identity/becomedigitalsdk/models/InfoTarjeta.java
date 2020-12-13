package com.becomedigital.sdk.identity.becomedigitalsdk.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * **************************************************************
 * Copyright (c) 2016 - 2016 Avanza, All rights reserved
 * <p/>
 * -
 * Descripcion de la clase
 * -
 * Autor:		Carlos Arturo Reyes Romero
 * email:		carr900@gmail.com
 * Creado:   	25/04/2016
 * Proyecto: 	barcode-reader
 * ****************************************************************
 */
public class InfoTarjeta implements Parcelable, Serializable{

    private String primerApellido;
    private String segundoApellido="";
    private String primerNombre="";
    private String segundoNombre="";
    private String cedula="";
    private String rh="";
    private String fechaNacimiento="";
    private String sexo="";

    protected InfoTarjeta(Parcel in) {
        primerApellido = in.readString();
        segundoApellido = in.readString();
        primerNombre = in.readString();
        segundoNombre = in.readString();
        cedula = in.readString();
        rh = in.readString();
        fechaNacimiento = in.readString();
        sexo = in.readString();
    }

    public InfoTarjeta(){

    }

    public static final Creator<InfoTarjeta> CREATOR = new Creator<InfoTarjeta>() {
        @Override
        public InfoTarjeta createFromParcel(Parcel in) {
            return new InfoTarjeta(in);
        }

        @Override
        public InfoTarjeta[] newArray(int size) {
            return new InfoTarjeta[size];
        }
    };

    @Override
    public String toString() {
        return "InfoTarjeta{" +
                "primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", rh='" + rh + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(primerApellido);
        parcel.writeString(segundoApellido);
        parcel.writeString(primerNombre);
        parcel.writeString(segundoNombre);
        parcel.writeString(cedula);
        parcel.writeString(rh);
        parcel.writeString(fechaNacimiento);
        parcel.writeString(sexo);
    }
}
