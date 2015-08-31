package myapplication.com.wshospital3android;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

import capaNegocio.fichamedicaDomain.RceVO;
import util.Constantes;
import util.Transformar;

/**
 * Created by altair141 on 31-08-2015.
 */
public class Rce  extends Activity {
    String NAMESPACE = Constantes.NAMESPACE;//"http://capaServicio";
    String URL = Constantes.URL;//"http://192.168.0.13:8080/WsHospital3/services/Servicio";
    String METHOD_NAME = "obtenerRcePorId";
    String SOAP_ACTION = NAMESPACE+"/"+METHOD_NAME;//"http://capaServicio/mostrarPacientes";
    String TAG="";
    private ListView list2;
    private ListView list3;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter2;
    private ArrayList<String> arrayList2;
    TextView txtSaludo;
    String listaHce="";
    String fichaMedi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rce);
        list2 = (ListView) findViewById(R.id.listView5);
        list3 = (ListView) findViewById(R.id.listView4);
        //Localizar los controles
        txtSaludo = (TextView) findViewById(R.id.textView);

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
            arrayList = new ArrayList<String>();
            arrayList2 = new ArrayList<String>();
            String resul=listaHce;
           RceVO rcevo= Transformar.jsonToRce3(resul);

                arrayList.add("Tipo encuentro:");
                arrayList2.add(rcevo.getTipoEncuentro());

            arrayList.add("Alergia:");
            arrayList2.add(rcevo.getAlergia());
            arrayList.add("Anamnesis:");
            arrayList2.add(rcevo.getAnamnesis());
            arrayList.add("Destino:");
            arrayList2.add(rcevo.getDestino());
            arrayList.add("Examen Fisico:");
            arrayList2.add(rcevo.getExamenFisico());
            arrayList.add("Hipotesis diagnostico:");
            arrayList2.add(rcevo.getHipotesisDiagnostico());
            arrayList.add("Inficacion cierre caso:");
            arrayList2.add(rcevo.getIndicacionCierreCaso());
            arrayList.add("Paciente Cronico:");
            arrayList2.add(rcevo.getPacienteCronico());
            arrayList.add("Paciente GES:");
            arrayList2.add(rcevo.getPacienteGes());
            arrayList.add("Patologia GGES:");
            arrayList2.add(rcevo.getPatologiaGes());
            arrayList.add("Receta:");
            arrayList2.add(rcevo.getReceta());


            adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.lista, arrayList);
            list2.setAdapter(adapter);
            adapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.lista2, arrayList2);
            list3.setAdapter(adapter2);
            adapter.notifyDataSetChanged();
            adapter2.notifyDataSetChanged();
            txtSaludo.setText("informacion RCE");


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