package com.example.appfinalmovile.View.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appfinalmovile.R;
import com.example.appfinalmovile.RetroFit.Request.RequestReservacion;
import com.example.appfinalmovile.ViewModel.FormularioViewModel;


public class FormularioFragment extends Fragment {

    EditText txtnombre, txtdni, txtcorreo, txtfecha, txtcantidadPersonas, txttelefono, txtlocal, txttipoevento;
    Button btnregistrarR;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_formulario, container, false);
        enlazarControles(root);

        RequestReservacion requestReservacion = new RequestReservacion();


        btnregistrarR.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                requestReservacion.setCodigo(1004);
                requestReservacion.setNombre(txtnombre.getText().toString());
                requestReservacion.setDni(txtdni.getText().toString());
                requestReservacion.setCorreo(txtcorreo.getText().toString());
                requestReservacion.setFecha_reservacion(txtfecha.getText().toString());
                requestReservacion.setCantidad_personas(txtcantidadPersonas.getText().toString());
                requestReservacion.setTelefono(txttelefono.getText().toString());
                requestReservacion.setNombre_local(txtlocal.getText().toString());
                requestReservacion.setTipo_evento(txttipoevento.getText().toString());

                FormularioViewModel f = new ViewModelProvider(requireActivity()).get(FormularioViewModel.class);
                f.RegistrarFormulario(requestReservacion);
                Toast.makeText(getContext(),"REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();
                limpiar();

            }
        });



        return root;
    }
    void limpiar(){
        txtnombre.setText("");
        txtdni.setText("");
        txtcorreo.setText("");
        txtfecha.setText("");
        txtcantidadPersonas.setText("");
        txttelefono.setText("");
        txtlocal.setText("");
        txttipoevento.setText("");
    }

    void enlazarControles(View vista)
    {
        txtnombre = vista.findViewById(R.id.txtNombre);
        txtdni = vista.findViewById(R.id.txtDni);
        txtcorreo = vista.findViewById(R.id.txtCorreo);
        txtfecha = vista.findViewById(R.id.txtFecha);
        txtcantidadPersonas = vista.findViewById(R.id.txtAforo);
        txttelefono = vista.findViewById(R.id.txtTel);
        txtlocal = vista.findViewById(R.id.txtNomLocal);
        txttipoevento = vista.findViewById(R.id.txtEvento);
        btnregistrarR = vista.findViewById(R.id.btnResgistrarR);
    }

    String traerTexto(EditText texto)
    {
        return texto.getText().toString().trim();
    }
}