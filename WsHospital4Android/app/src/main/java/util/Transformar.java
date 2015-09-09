package util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import capaNegocio.fichamedicaDomain.DiagnosticoVO;
import capaNegocio.fichamedicaDomain.ActividadVO;
import capaNegocio.fichamedicaDomain.CertificadoVO;
import capaNegocio.fichamedicaDomain.HceVO;
import capaNegocio.fichamedicaDomain.ProcedimientoVO;
import capaNegocio.fichamedicaDomain.RecetaVO;
import capaNegocio.personasDomain.PacienteVO;
import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaNegocio.fichamedicaDomain.RceVO;
/**
 * Created by altair141 on 06-09-2015.
 */
public class Transformar {
    public static List<RceVO> jsonToRce3(String json) {
        List<RceVO> lista = new ArrayList<RceVO>();
        try {
            JsonElement jelement = new JsonParser().parse(json);
            JsonObject jobject = jelement.getAsJsonObject();
            JsonArray jarray = jobject.getAsJsonArray("results");
            for (int j = 0; j < jarray.size(); j++) {
                jobject = jarray.get(j).getAsJsonObject();
                RceVO rce = new RceVO();
                String tipoEncuentro = jobject.get("tipoEncuentro")
                        .getAsString();
                System.out.println("0 " + tipoEncuentro);
                rce.setTipoEncuentro(tipoEncuentro);
                int idRce = jobject.get("idRce").getAsInt();
                rce.setIdRce(idRce);
                JsonObject hceJson = jobject.get("idHce").getAsJsonObject();
                String idHce = hceJson.get("id").getAsString();
                System.out.println("2 " + idHce);
                HceVO hce = new HceVO(stringToInt(idHce));

                JsonObject pacienteJson= hceJson.get("paciente").getAsJsonObject();
                PacienteVO paciente=new PacienteVO();
                paciente.setNombre(pacienteJson.get("nombre").getAsString());
                paciente.setApellidos(pacienteJson.get("apellidos").getAsString());
                hce.setPaciente(paciente);
                rce.setIdHce(hce);
                JsonObject horaMedicaJson = jobject.get("idHoraMedica")
                        .getAsJsonObject();
                String idHoraMedica = horaMedicaJson.get("id").getAsString();
                System.out.println("3 " + idHoraMedica);
                HoraMedicaVO horaMedica = new HoraMedicaVO(
                        stringToInt(idHoraMedica));
                rce.setIdHoraMedica(horaMedica);

                String anamnesis = jobject.get("anamnesis").getAsString();
                System.out.println("4 " + anamnesis);
                rce.setAnamnesis(anamnesis);

                String alergia = jobject.get("alergia").getAsString();
                System.out.println("5 " + alergia);
                rce.setAlergia(alergia);

                String examenFisico = jobject.get("examenFisico").getAsString();
                System.out.println("6 " + examenFisico);
                rce.setExamenFisico(examenFisico);

                String indicacionMedica = jobject.get("indicacionMedica")
                        .getAsString();
                System.out.println("7 " + indicacionMedica);
                rce.setIndicacionMedica(indicacionMedica);

                String indicacionCasocierre = jobject.get(
                        "indicacionCierreCaso").getAsString();
                System.out.println("8 " + indicacionCasocierre);
                rce.setIndicacionCierreCaso(indicacionCasocierre);

                String hipotesisDiagnos = jobject.get("hipotesisDiagnostico")
                        .getAsString();
                System.out.println("9 " + hipotesisDiagnos);
                rce.setHipotesisDiagnostico(hipotesisDiagnos);

                String pacienteGes = jobject.get("pacienteGes").getAsString();
                System.out.println("10 " + pacienteGes);
                rce.setPacienteGes(pacienteGes);

                String patologiaGes = jobject.get("patologiaGes").getAsString();
                System.out.println("11 " + patologiaGes);
                rce.setPatologiaGes(patologiaGes);

                String pacienteCroni = jobject.get("pacienteCronico")
                        .getAsString();
                System.out.println("12 " + pacienteCroni);
                rce.setPacienteCronico(pacienteCroni);

                String tipoCierre = jobject.get("tipoCierre").getAsString();
                System.out.println("17 " + tipoCierre);
                rce.setTipoCierre(tipoCierre);

                String destino = jobject.get("destino").getAsString();
                System.out.println("18 " + destino);
                rce.setDestino(destino);

                String fecha = jobject.get("fechaAtencion").getAsString();
                System.out.println("19 " + fecha);
                Date fechaAten = stringToDate(fecha);
                rce.setFechaAtencion(fechaAten);

                String horaInicio = jobject.get("horaInicioAtencion")
                        .getAsString();
                System.out.println("20" + horaInicio);
                rce.setHoraInicioAtencion(horaInicio);

                String fechaFin = jobject.get("fechaCierreClinico")
                        .getAsString();
                System.out.println("21 " + fechaFin);
                Date fechaCierre = stringToDate(fechaFin);
                rce.setFechaCierreClinico(fechaCierre);

                String horaFin = jobject.get("horaCierreClienico")
                        .getAsString();
                System.out.println("22 " + horaFin);
                rce.setHoraCierreClienico(horaFin);
                String tiempoControl = jobject.get("tiempoControl")
                        .getAsString();
                System.out.println("23 " + tiempoControl);
                rce.setTiempoControl(tiempoControl);
                JsonArray listaCertificadosjson = jobject
                        .getAsJsonArray("listaCertificados");

                for (int i = 0; i < listaCertificadosjson.size(); i++) {
                    JsonObject certificadosJson = listaCertificadosjson.get(i)
                            .getAsJsonObject();
                    String idCertificado = certificadosJson.get("id")
                            .getAsString();
                    System.out.println((24 + i) + " " + idCertificado);
                    CertificadoVO certificado = new CertificadoVO(
                            stringToInt(idCertificado));
                    rce.agregarCertificado(certificado);

                }
                JsonArray listaDiagnosticosjson = jobject
                        .getAsJsonArray("listaDiagnostico");
                for (int i = 0; i < listaDiagnosticosjson.size(); i++) {
                    JsonObject diagnosticoJson = listaDiagnosticosjson.get(i)
                            .getAsJsonObject();
                    String idDiagnostico = diagnosticoJson.get("id")
                            .getAsString();
                    System.out.println((24 + i) + " " + idDiagnostico);
                    DiagnosticoVO diagnostico = new DiagnosticoVO(
                            stringToInt(idDiagnostico));
                    rce.agregarDiagnostico(diagnostico);
                }

                JsonArray listaActividadjson = jobject
                        .getAsJsonArray("listaActividad");
                for (int i = 0; i < listaActividadjson.size(); i++) {
                    JsonObject actividadjson = listaActividadjson.get(i)
                            .getAsJsonObject();
                    String idActividad = actividadjson.get("id").getAsString();
                    System.out.println((24 + i) + " " + idActividad);
                    ActividadVO actividad = new ActividadVO(
                            stringToInt(idActividad));
                    rce.agregarActividad(actividad);
                }

                JsonArray listaProcedimientojson = jobject
                        .getAsJsonArray("listaProcedimiento");
                for (int i = 0; i < listaProcedimientojson.size(); i++) {
                    JsonObject procedimientojson = listaProcedimientojson
                            .get(i).getAsJsonObject();
                    String idProcedimiento = procedimientojson.get("id")
                            .getAsString();
                    System.out.println((24 + i) + " " + idProcedimiento);
                    ProcedimientoVO procedimiento = new ProcedimientoVO(
                            stringToInt(idProcedimiento));
                    rce.agregarProcedimiento(procedimiento);
                }
                lista.add(rce);
            }
            return lista;
        } catch (NullPointerException e) {
            return null;
        } catch (IllegalStateException e) {
            return null;
        }
    }

    public static Date stringToDate(String fecha) {
        System.out.println("yyyy-MM-dd HH:mm:ss " + validarFecha(fecha));
        System.out.println("MMM dd, yyyy " + validarFecha2(fecha));
        System.out.println("yyyy-MM-dd" + validarFecha3(fecha));
        if (validarFecha3(fecha)) {
            try {

                DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str1 = fecha;
                Date date = f.parse(str1);
                return date;

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            } catch (NullPointerException c) {
                return null;
            }

        } else if (validarFecha2(fecha)) {
            try {

                DateFormat f = new SimpleDateFormat("MMM dd, yyyy");
                String str1 = fecha;
                Date date = f.parse(str1);
                return date;

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            } catch (NullPointerException c) {
                return null;
            }
        } else if (validarFecha(fecha)) {
            try {

                DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                String str1 = fecha;
                Date date = f.parse(str1);
                return date;

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            } catch (NullPointerException c) {
                return null;
            }
        }

        return null;
    }
    public static int stringToInt(String texto) {
        try {
            int numero = Integer.parseInt(texto);
            return numero;
        } catch (NumberFormatException e) {
            return -1;
        } catch (NullPointerException e) {
            return -1;
        }
    }
    public static boolean validarFecha(String fecha) {
        try {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String str1 = fecha;
            Date date = f.parse(str1);
            return true;
        } catch (ParseException e) {
            return false;
        } catch (NullPointerException c) {
            return false;
        }

    }

    public static boolean validarFecha3(String fecha) {
        try {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str1 = fecha;
            Date date = f.parse(str1);
            return true;
        } catch (ParseException e) {
            return false;
        } catch (NullPointerException c) {
            return false;
        }

    }
    public static boolean validarFecha2(String fecha) {
        try {
            DateFormat f = new SimpleDateFormat("MMM dd, yyyy");
            String str1 = fecha;
            Date date = f.parse(str1);
            return true;
        } catch (ParseException e) {
            return false;
        } catch (NullPointerException c) {
            return false;
        }

    }
    public static String datetoString(Date fecha) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate = df.format(fecha);
        return reportDate;
    }

    public static RceVO jsonToRceCompleto(String json) {

        try {
            JsonElement jelement = new JsonParser().parse(json);
            JsonObject jobject = jelement.getAsJsonObject();
            JsonArray jarray = jobject.getAsJsonArray("results");

                jobject = jarray.get(0).getAsJsonObject();
                RceVO rce = new RceVO();
                String tipoEncuentro = jobject.get("tipoEncuentro")
                        .getAsString();
                System.out.println("0 " + tipoEncuentro);
                rce.setTipoEncuentro(tipoEncuentro);
                int idRce = jobject.get("idRce").getAsInt();
                rce.setIdRce(idRce);
                JsonObject hceJson = jobject.get("idHce").getAsJsonObject();
                String idHce = hceJson.get("id").getAsString();
                System.out.println("2 " + idHce);
                HceVO hce = new HceVO(stringToInt(idHce));
                rce.setIdHce(hce);

                JsonObject horaMedicaJson = jobject.get("idHoraMedica")
                        .getAsJsonObject();
                String idHoraMedica = horaMedicaJson.get("id").getAsString();
                System.out.println("3 " + idHoraMedica);
                HoraMedicaVO horaMedica = new HoraMedicaVO(
                        stringToInt(idHoraMedica));
                rce.setIdHoraMedica(horaMedica);

                String anamnesis = jobject.get("anamnesis").getAsString();
                System.out.println("4 " + anamnesis);
                rce.setAnamnesis(anamnesis);

                String alergia = jobject.get("alergia").getAsString();
                System.out.println("5 " + alergia);
                rce.setAlergia(alergia);

                String examenFisico = jobject.get("examenFisico").getAsString();
                System.out.println("6 " + examenFisico);
                rce.setExamenFisico(examenFisico);

                String indicacionMedica = jobject.get("indicacionMedica")
                        .getAsString();
                System.out.println("7 " + indicacionMedica);
                rce.setIndicacionMedica(indicacionMedica);

                String indicacionCasocierre = jobject.get(
                        "indicacionCierreCaso").getAsString();
                System.out.println("8 " + indicacionCasocierre);
                rce.setIndicacionCierreCaso(indicacionCasocierre);

                String hipotesisDiagnos = jobject.get("hipotesisDiagnostico")
                        .getAsString();
                System.out.println("9 " + hipotesisDiagnos);
                rce.setHipotesisDiagnostico(hipotesisDiagnos);

                String pacienteGes = jobject.get("pacienteGes").getAsString();
                System.out.println("10 " + pacienteGes);
                rce.setPacienteGes(pacienteGes);

                String patologiaGes = jobject.get("patologiaGes").getAsString();
                System.out.println("11 " + patologiaGes);
                rce.setPatologiaGes(patologiaGes);

                String pacienteCroni = jobject.get("pacienteCronico")
                        .getAsString();
                System.out.println("12 " + pacienteCroni);
                rce.setPacienteCronico(pacienteCroni);

                String tipoCierre = jobject.get("tipoCierre").getAsString();
                System.out.println("17 " + tipoCierre);
                rce.setTipoCierre(tipoCierre);

                String destino = jobject.get("destino").getAsString();
                System.out.println("18 " + destino);
                rce.setDestino(destino);

                String fecha = jobject.get("fechaAtencion").getAsString();
                System.out.println("19 " + fecha);
                Date fechaAten = stringToDate(fecha);
                rce.setFechaAtencion(fechaAten);

                String horaInicio = jobject.get("horaInicioAtencion")
                        .getAsString();
                System.out.println("20" + horaInicio);
                rce.setHoraInicioAtencion(horaInicio);

                String fechaFin = jobject.get("fechaCierreClinico")
                        .getAsString();
                System.out.println("21 " + fechaFin);
                Date fechaCierre = stringToDate(fechaFin);
                rce.setFechaCierreClinico(fechaCierre);

                String horaFin = jobject.get("horaCierreClienico")
                        .getAsString();
                System.out.println("22 " + horaFin);
                rce.setHoraCierreClienico(horaFin);
                String tiempoControl = jobject.get("tiempoControl")
                        .getAsString();
                System.out.println("23 " + tiempoControl);
                rce.setTiempoControl(tiempoControl);
                JsonArray listaCertificadosjson = jobject
                        .getAsJsonArray("listaCertificados");

                for (int i = 0; i < listaCertificadosjson.size(); i++) {
                    JsonObject certificadosJson = listaCertificadosjson.get(i)
                            .getAsJsonObject();
                    String idCertificado = certificadosJson.get("id")
                            .getAsString();
                    System.out.println((24 + i) + " " + idCertificado);
                    CertificadoVO certificado = new CertificadoVO(
                            stringToInt(idCertificado));
                            certificado.setNombre(certificadosJson.get("nombre").getAsString());
                    rce.agregarCertificado(certificado);

                }
                JsonArray listaDiagnosticosjson = jobject
                        .getAsJsonArray("listaDiagnostico");
                for (int i = 0; i < listaDiagnosticosjson.size(); i++) {
                    JsonObject diagnosticoJson = listaDiagnosticosjson.get(i)
                            .getAsJsonObject();
                    String idDiagnostico = diagnosticoJson.get("id")
                            .getAsString();
                    System.out.println((24 + i) + " " + idDiagnostico);
                    DiagnosticoVO diagnostico = new DiagnosticoVO(
                            stringToInt(idDiagnostico));
                    diagnostico.setNombre(diagnosticoJson.get("nombre").getAsString());
                    rce.agregarDiagnostico(diagnostico);
                }

                JsonArray listaActividadjson = jobject
                        .getAsJsonArray("listaActividad");
                for (int i = 0; i < listaActividadjson.size(); i++) {
                    JsonObject actividadjson = listaActividadjson.get(i)
                            .getAsJsonObject();
                    String idActividad = actividadjson.get("id").getAsString();
                    System.out.println((24 + i) + " " + idActividad);
                    ActividadVO actividad = new ActividadVO(
                            stringToInt(idActividad));
                    actividad.setNombreActividad(actividadjson.get("nombreActividad").getAsString());
                    rce.agregarActividad(actividad);
                }

                JsonArray listaRecetajson = jobject
                        .getAsJsonArray("listaReceta");
                for (int i = 0; i < listaRecetajson.size(); i++) {
                    JsonObject recetaJson = listaRecetajson.get(i)
                            .getAsJsonObject();
                    String idReceta = recetaJson.get("id")
                            .getAsString();
                    System.out.println((24 + i) + " " + idReceta);
                    RecetaVO receta = new RecetaVO(
                            stringToInt(idReceta));
                    receta.setContenido(recetaJson.get("contenido").getAsString());
                    rce.agregarReceta(receta);
                }




                JsonArray listaProcedimientojson = jobject
                        .getAsJsonArray("listaProcedimiento");
                for (int i = 0; i < listaProcedimientojson.size(); i++) {
                    JsonObject procedimientojson = listaProcedimientojson
                            .get(i).getAsJsonObject();
                    String idProcedimiento = procedimientojson.get("id").getAsString();
                    System.out.println((24 + i) + " " + idProcedimiento);
                    ProcedimientoVO procedimiento = new ProcedimientoVO(
                            stringToInt(idProcedimiento));
                    procedimiento.setNombre(procedimientojson.get("nombre").getAsString());
                    rce.agregarProcedimiento(procedimiento);
                }

            return rce;
        } catch (NullPointerException e) {
            return null;
        } catch (IllegalStateException e) {
            return null;
        }
    }
}
