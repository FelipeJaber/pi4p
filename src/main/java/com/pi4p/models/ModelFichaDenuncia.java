package com.pi4p.models;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tabela_ficha_denuncia")
public class ModelFichaDenuncia {

    SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String latitude;
    String longitude;
    String textoDenuncia;
    Date data;

    public ModelFichaDenuncia(UUID id, String latitude, String longitude, String textoDenuncia, String data) throws ParseException {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.textoDenuncia = textoDenuncia;
        this.data = formatadorData.parse(data);
    }

    public ModelFichaDenuncia(UUID id, String latitude, String longitude, String textoDenuncia, Date data) throws ParseException {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.textoDenuncia = textoDenuncia;
        this.data = data;
    }

    public ModelFichaDenuncia(SimpleDateFormat formatadorData) {
        this.formatadorData = formatadorData;
    }

    public SimpleDateFormat getFormatadorData() {
        return formatadorData;
    }

    public void setFormatadorData(SimpleDateFormat formatadorData) {
        this.formatadorData = formatadorData;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTextoDenuncia() {
        return textoDenuncia;
    }

    public void setTextoDenuncia(String textoDenuncia) {
        this.textoDenuncia = textoDenuncia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setData(String data) throws ParseException {
        this.data = formatadorData.parse(data);
    }
}
