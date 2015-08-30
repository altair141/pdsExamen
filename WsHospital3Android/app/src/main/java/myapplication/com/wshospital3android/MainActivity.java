package myapplication.com.wshospital3android;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class MainActivity extends ActionBarActivity {
    String NAMESPACE = "http://capaServicio";
    String URL = "http://192.168.0.13:8080/WsHospital3/services/Servicio";
    String SOAP_ACTION = "http://capaServicio/mostrarPacientes";
    String METHOD_NAME = "mostrarPacientes";

    String listaPacientes="";
    String TAG="";

    EditText editCelsius;
    TextView txtResult;
    Button btnEnviar;
    String lista=getFahrenheit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCelsius= (EditText)findViewById(R.id.editCelsius);
        txtResult=(TextView)findViewById(R.id.tv_result);
        btnEnviar=(Button)findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
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

    public String getFahrenheit() {
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
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
            txtResult.setText(listaPacientes + "5g° F");
        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
            txtResult.setText("Calculando...");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }


}
