package shared_preferences.elvis.almacenamiento_shart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button Guardar;
    private EditText etUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario=(EditText) findViewById(R.id.etUsuario);
        Guardar = findViewById(R.id.guardar);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        etUsuario.setText(preferences.getString("usuarios",""));
        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(v);
            }
        });



    }

    public void guardar(View view)
    {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString("usuarios", etUsuario.getText().toString());
        obj_editor.commit();
        finish();
    }
}
