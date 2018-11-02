/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package br.com.seconci.converter;


import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.seconci.model.Relatoriotipo;

/**
 *
 * @author Wolverine
 */

@FacesConverter(value = "RelatorioTipoConverter")
public class RelatorioTipoConverter implements Converter<Object> {

    @SuppressWarnings("unchecked")
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Relatoriotipo> listaRelatorioTipo = (List<Relatoriotipo>) component.getAttributes().get("listaRelatorioTipo");
        if (listaRelatorioTipo != null) {
            for (Relatoriotipo relatorioTipo : listaRelatorioTipo) {
                if (relatorioTipo.getTitulo().equalsIgnoreCase(value)) {
                    return relatorioTipo;
                }
            }
        } else {
            return new Relatoriotipo();
        }
        return new Relatoriotipo();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value.toString().equalsIgnoreCase("0")) {
            return "Selecione";
        } else {
            Relatoriotipo relatorioTipo =  (Relatoriotipo) value;
            if (relatorioTipo.getIdrelatoriotipo() != null) {
                return relatorioTipo.getTitulo();
            } else {
                return "";
            }
        }
    }
}