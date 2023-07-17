package com.example.appfinalmovile.RetroFit.Response;

public class ResponseReservacion {

    private Boolean rptR;
    private String mensajeR;
    private Integer codigo;
    private String nombre;

    private String dni;
    private String correo;

    private String fecha_reservacion;

    private String cantidad_personas;

    private String telefono;

    private String nombre_local;

    private String tipo_evento;

    public Boolean getRptR() {
        return rptR;
    }

    public void setRptR(Boolean rptR) {
        this.rptR = rptR;
    }

    public String getMensajeR() {
        return mensajeR;
    }

    public void setMensajeR(String mensajeR) {
        this.mensajeR = mensajeR;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha_reservacion() {
        return fecha_reservacion;
    }

    public void setFecha_reservacion(String fecha_reservacion) {
        this.fecha_reservacion = fecha_reservacion;
    }

    public String getCantidad_personas() {
        return cantidad_personas;
    }

    public void setCantidad_personas(String cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre_local() {
        return nombre_local;
    }

    public void setNombre_local(String nombre_local) {
        this.nombre_local = nombre_local;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }
}

