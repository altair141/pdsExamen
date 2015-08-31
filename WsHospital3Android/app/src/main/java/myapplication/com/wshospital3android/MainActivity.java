package myapplication.com.wshospital3android;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import capaNegocio.personasDomain.PacienteVO;
import capaNegocio.personasDomain.PersonaVO;
import util.Constantes;
import util.Transformar;

public class MainActivity extends ActionBarActivity {
    String NAMESPACE = Constantes.NAMESPACE;//"http://capaServicio";
    String URL = Constantes.URL;//"http://192.168.0.13:8080/WsHospital3/services/Servicio";
    String METHOD_NAME = "mostrarPacientes";
    String SOAP_ACTION = NAMESPACE+"/"+METHOD_NAME;//"http://capaServicio/mostrarPacientes";

    List<PacienteVO> listaPacientesVO=new ArrayList<PacienteVO>();
    String listaPacientes="";
    String TAG="";
    String lista;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    TextView txtResult;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);

        txtResult=(TextView)findViewById(R.id.tv_result);

        funciona();
       /* list = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.activity_hce, arrayList);
        list.setAdapter(adapter);
*/

        //getFahrenheit();
        //txtResult.setText(listaPacientes );
       /* btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validar que no venga vacio
                if (editCelsius.getText().length() != 0 && editCelsius.getText().toString() != "") {
                    //recuperar desde edittex

                    //Creacion de instancia AsyncCallWS
                    AsyncCallWS task = new AsyncCallWS();
                    //ejecuta
                    task.execute();

                } else {
                    txtResult.setText("Ingresar ° Celsius");
                }
            }


        });*/

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               //  Toast.makeText(getApplicationContext(), "este es " + list.getItemAtPosition(position), Toast.LENGTH_LONG).show();
               String valor = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, Hce.class);
                intent.putExtra("NOMBRE", valor);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
    public void getFahrenheit() {
        //Crea el request
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        //Crea un objeto con los datos que van a ser enviados
        PropertyInfo celsiusPI = new PropertyInfo();
        //Set Name

        //Set Value

        //Set tipo de dato

        //Agrega el objeto al request

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
            listaPacientes = response.toString();


            System.out.println("asdasadsads"+response.toString());

        } catch (Exception e) {
            e.printStackTrace();
            listaPacientes = "{\"results\":[]}";
        }
    }
    //Crea tarea Asincronica (2 plano)
    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            Log.i(TAG, "doInBackground");
            getFahrenheit();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
            arrayList = new ArrayList<String>();
            String resul="{\"results\":"+listaPacientes+"}";
            JsonElement jelement = new JsonParser().parse(resul);
            JsonObject jobject = jelement.getAsJsonObject();
            JsonArray jarray = jobject.getAsJsonArray("results");
              String asd="";
              for (int i = 0; i < jarray.size(); i++) {

                jobject = jarray.get(i).getAsJsonObject();
                resul = jobject.get("nroFicha").getAsString();
                  asd+=resul;
              arrayList.add(resul);
                 /* adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.lista, arrayList);
                  list.setAdapter(adapter);
                  adapter.notifyDataSetChanged();
*/
              //adapter.notifyDataSetChanged();

           }
            adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.lista, arrayList);
            list.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            txtResult.setText("");

        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
            txtResult.setText("buscando...");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }


}
