package myapplication.com.wshospital4android;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

import capaNegocio.fichamedicaDomain.ActividadVO;
import capaNegocio.fichamedicaDomain.CertificadoVO;
import capaNegocio.fichamedicaDomain.DiagnosticoVO;
import capaNegocio.fichamedicaDomain.ProcedimientoVO;
import capaNegocio.fichamedicaDomain.RceVO;
import capaNegocio.fichamedicaDomain.RecetaVO;
import util.Constantes;
import util.Transformar;

/**
 * Created by altair141 on 06-09-2015.
 */
public class Rce extends Activity {
    String NAMESPACE = Constantes.NAMESPACE;//"http://capaServicio";
    String URL = Constantes.URL;//"http://192.168.0.13:8080/WsHospital3/services/Servicio";
    String METHOD_NAME = "obtenerRceCompleto";
    String SOAP_ACTION = NAMESPACE+"/"+METHOD_NAME;//"http://capaServicio/mostrarPacientes";
    String TAG="";

    EditText txtAnamnesis;
    EditText txtAlergia;
    EditText txtexamenfisico;
    EditText txtindicacionmedica;

    EditText txtindicacioncierre;
    EditText txthipotesisDiagnostico;
    EditText txtpacienteges;
    EditText txtpatologiages;
    EditText txtpacientecronico;
    EditText txtreceta;
    EditText txttipocierreclinico;
    EditText txtdestino;
    EditText txtfechaAtencion;
    EditText txthoraatencion;
    EditText txtfechacierre;
    EditText txthoracierre;
    EditText txttiempocontrol;
    EditText txtcierreadministrativo;
    private ListView diagnostico;
    private ListView actividad;
    private ListView procedimiento;
    private ListView certificado;

    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter2;
    private ArrayList<String> arrayList2;
    private ArrayAdapter<String> adapter3;
    private ArrayList<String> arrayList3;
    private ArrayAdapter<String> adapter4;
    private ArrayList<String> arrayList4;

    TextView txtSaludo;
    String listaHce="";
    String fichaMedi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rce);

        //Localizar los controles
        txtSaludo = (TextView) findViewById(R.id.tv_result);
         txtAnamnesis = (EditText) findViewById(R.id.anamnesis);
         txtAlergia= (EditText) findViewById(R.id.alergias);
         txtexamenfisico= (EditText) findViewById(R.id.examenfisico);
        txtindicacionmedica= (EditText) findViewById(R.id.indicacionmedica);

        txtindicacioncierre= (EditText) findViewById(R.id.indicacioncierrecaso);
         txthipotesisDiagnostico= (EditText) findViewById(R.id.hipotesisdiagnostico);
         txtpacienteges= (EditText) findViewById(R.id.pacienteges);
         txtpatologiages= (EditText) findViewById(R.id.patologiages);
         txtpacientecronico= (EditText) findViewById(R.id.pacientecronico);
         txtreceta= (EditText) findViewById(R.id.receta);
         txttipocierreclinico= (EditText) findViewById(R.id.tipocierreclinico);
         txtdestino= (EditText) findViewById(R.id.destino);
         txtfechaAtencion= (EditText) findViewById(R.id.fechaatencion);
        txthoraatencion= (EditText) findViewById(R.id.horaatencion);
        txtfechacierre= (EditText) findViewById(R.id.fechacierreclinico);
         txthoracierre= (EditText) findViewById(R.id.horacierreclinico);
         txttiempocontrol= (EditText) findViewById(R.id.tiempocontrol);
         txtcierreadministrativo= (EditText) findViewById(R.id.cierreadministrativo);
         diagnostico= (ListView) findViewById(R.id.diagnostico);
         actividad= (ListView) findViewById(R.id.actividades);
         procedimiento= (ListView) findViewById(R.id.procedimientos);
        certificado= (ListView) findViewById(R.id.certificados);



        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        txtSaludo.setText("Hola " + bundle.getString("NOMBRE"));
        fichaMedi=bundle.getString("NOMBRE");
        funciona();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void funciona(){
        //Creacion de instancia AsyncCallWS
        AsyncCallWS task = new AsyncCallWS();
        //ejecuta
        task.execute();

    }

    public void getFahrenheit(String idRce) {
        //Crea el request
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        //Crea un objeto con los datos que van a ser enviados
        PropertyInfo rce = new PropertyInfo();
        //Set Name
        rce.setName("idRce");
        //Set Value
        rce.setValue(idRce);
        //Set tipo de dato
        rce.setType(String.class);
        //Agrega el objeto al request
        request.addProperty(rce);
        //Crea envelope (sobre)
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        //Set output SOAP object (salida objeto)
        envelope.setOutputSoapObject(request);
        //Crea HTTP call object (transporte)
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        try {
            //Invocar el Servicio
            androidHttpTransport.call(SOAP_ACTION, envelope);
            //Respuesta234
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            //Asigna valor a la variable
            listaHce = response.toString();


            System.out.println("asdasadsads"+response.toString());

        } catch (Exception e) {
            e.printStackTrace();
            listaHce = "{\"results\":[]}";
        }
    }
    //Crea tarea Asincronica (2 plano)
    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            Log.i(TAG, "doInBackground");


            getFahrenheit(fichaMedi);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
            System.out.println(listaHce);
            RceVO rce = Transformar.jsonToRceCompleto(listaHce);
            arrayList = new ArrayList<String>();
            arrayList2 = new ArrayList<String>();
            arrayList3 = new ArrayList<String>();
            arrayList4 = new ArrayList<String>();

            txtAnamnesis.setText(rce.getAnamnesis());
           txtAlergia.setText(rce.getAlergia());
            txtexamenfisico.setText(rce.getExamenFisico());
            txtindicacionmedica.setText(rce.getIndicacionMedica());

            txtindicacioncierre.setText(rce.getIndicacionCierreCaso());
            txthipotesisDiagnostico.setText(rce.getHipotesisDiagnostico());
            txtpacienteges.setText(rce.getPacienteGes());
            txtpatologiages.setText(rce.getPatologiaGes());
            txtpacientecronico.setText(rce.getPacienteCronico());

            txttipocierreclinico.setText(rce.getTipoCierre());
            txtdestino.setText(rce.getDestino());
           txtfechaAtencion.setText(Transformar.datetoString(rce.getFechaAtencion()));
            txthoraatencion.setText(rce.getHoraInicioAtencion());
            txtfechacierre.setText(Transformar.datetoString(rce.getFechaCierreClinico()));
            txthoracierre.setText(rce.getHoraCierreClienico());
            txttiempocontrol.setText(rce.getTiempoControl());
            txtcierreadministrativo.setText(rce.getTipoEncuentro());


            List<ActividadVO> listaActi=rce.getListaActividad();
            for(ActividadVO acti:listaActi){
                System.out.println("provando wa " + acti.getNombreActividad());
                arrayList.add(acti.getNombreActividad());
            }
            System.out.println("provando wa " + rce.getListaProcedimiento().get(0).getNombre());
           List<ProcedimientoVO> listaProce=rce.getListaProcedimiento();
            for(ProcedimientoVO proce: listaProce){
                System.out.println("provando wa " + proce.getNombre());
                arrayList2.add(proce.getNombre());
            }
             List<DiagnosticoVO> listaDiag=rce.getListaDiagnostico();
            for(DiagnosticoVO diag: listaDiag){
                arrayList3.add(diag.getNombre());
            }
            List<CertificadoVO>listaCerti=rce.getListaCertificados();
            for(CertificadoVO certi:listaCerti){
                arrayList4.add(certi.getNombre());
            }
            List<RecetaVO> listaReceta=rce.getListaReceta();
            String texto="";
            for(RecetaVO rece: listaReceta){
                texto+=rece.getContenido()+"\n";
            }
            txtreceta.setText(texto);
            adapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.lista2, arrayList2);
            procedimiento.setAdapter(adapter2);
            adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.lista, arrayList);
            adapter3 = new ArrayAdapter<String>(getApplicationContext(), R.layout.lista2, arrayList3);
            adapter4= new ArrayAdapter<String>(getApplicationContext(), R.layout.lista, arrayList4);
            diagnostico.setAdapter(adapter3);
            actividad.setAdapter(adapter);
            certificado.setAdapter(adapter4);
            txtSaludo.setText("RCE nro: "+fichaMedi);

    //txtreceta= (EditText) findViewById(R.id.receta);
        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
            txtSaludo.setText("buscando...");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }
}
