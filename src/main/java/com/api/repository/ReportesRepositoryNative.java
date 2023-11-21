package com.api.repository;

import com.api.models.http.request.ResumenRequest;
import com.api.models.http.response.EstadoResponse;
import com.api.models.http.response.TiempoAtencionResponse;
import com.api.models.http.response.TramiteResponse;
import com.api.util.Util;
import jakarta.persistence.EntityManager;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReportesRepositoryNative {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private Util util;

    public List<TramiteResponse> findByCountTramite(ResumenRequest request) {

        String qry = "SELECT COALESCE(tramite, 'Desconocido') AS tramite, COUNT(*) AS cantidad " +
                "FROM reportes " +
                "WHERE fecha_creacion BETWEEN :fechaInicial AND :fechaFinal " +
                "GROUP BY tramite " +
                "ORDER BY COUNT(*) DESC;";

        NativeQuery query = (NativeQuery) entityManager.createNativeQuery(qry);
        query.setParameter("fechaInicial", request.getFechaInicial());
        query.setParameter("fechaFinal", request.getFechaFinal());

        List<Object[]> resultados = query.getResultList();
        List<TramiteResponse> response = new ArrayList<>();

        for (Object[] data : resultados) {
            TramiteResponse tramite = new TramiteResponse();
            tramite.setTramite((String) data[0]);
            tramite.setCantidad((Long) data[1]);
            response.add(tramite);
        }
        return response;
    }

    public List<EstadoResponse> findByCountEstado(ResumenRequest request) {

        String qry = "SELECT COALESCE(estado, 'Desconocido') AS tramite, COUNT(*) AS estado " +
                "FROM reportes " +
                "WHERE fecha_creacion BETWEEN :fechaInicial AND :fechaFinal " +
                "GROUP BY estado " +
                "ORDER BY COUNT(*) DESC;";

        NativeQuery query = (NativeQuery) entityManager.createNativeQuery(qry);
        query.setParameter("fechaInicial", request.getFechaInicial());
        query.setParameter("fechaFinal", request.getFechaFinal());

        List<Object[]> resultados = query.getResultList();
        List<EstadoResponse> response = new ArrayList<>();

        for (Object[] data : resultados) {
            EstadoResponse estado = new EstadoResponse();
            estado.setEstado((String) data[0]);
            estado.setCantidad((Long) data[1]);
            response.add(estado);
        }
        return response;
    }

    public List<TiempoAtencionResponse> findByAllTiempoAtencion(ResumenRequest request) {

        String qry = "SELECT num_turno," +
                "tipo_cliente," +
                "identificacion," +
                "nombre_cliente," +
                "(hora_fin_atencion - hora_llamado) AS tiempo_gestion, " +
                "oficina," +
                "region," +
                "sala," +
                "ser_mensaje_de_respuesta," +
                "ser_numero_formulario," +
                "ser_resultado_del_tramite," +
                "tramite," +
                "usuario " +
                "FROM reportes " +
                "WHERE estado = 'Finalizado' " +
                "AND (hora_fin_atencion - hora_llamado) > '00:05:50' " +
                "AND fecha_creacion BETWEEN :fechaInicial AND :fechaFinal " +
                "ORDER BY (hora_fin_atencion - hora_llamado) DESC; ";

        NativeQuery query = (NativeQuery) entityManager.createNativeQuery(qry);
        query.setParameter("fechaInicial", request.getFechaInicial());
        query.setParameter("fechaFinal", request.getFechaFinal());

        List<Object[]> resultados = query.getResultList();
        List<TiempoAtencionResponse> response = new ArrayList<>();

        for (Object[] data : resultados) {
            TiempoAtencionResponse estado = new TiempoAtencionResponse();
            estado.setNumTurno((String) data[0]);
            estado.setTipoCliente((String) data[1]);
            estado.setIdentificacion((String) data[2]);
            estado.setNombreCliente((String) data[3]);
            estado.setTiempoGestion((Integer) util.formatearTiempoEnMinutos(data[4].toString()));
            estado.setTiempoGestionHoras((String) util.formatearTiempo(data[4].toString()));
            estado.setOficina((String) data[5]);
            estado.setRegion((String) data[6]);
            estado.setSala((String) data[7]);
            estado.setSerMensajeDeRespuesta((String) data[8]);
            estado.setSerNumeroFormulario((Long) data[9]);
            estado.setSerResultadoDelTramite((String) data[10]);
            estado.setTramite((String) data[11]);
            estado.setUsuario((String) data[12]);
            response.add(estado);
        }
        return response;
    }

}
