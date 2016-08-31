package ar.com.centroeducativo.listview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter de Usuarios para mostrar en una Lista
 */
public class UsersAdapter extends BaseAdapter {

    private final Context context;
    // Esta es la lista de objetos que voy a mostrar, en este caso son 100 numeros, pero podrian ser Usuarios, Imagenes, Animales o lo que sea
    private ArrayList<Integer> list = new ArrayList<>();

    public UsersAdapter(Context context) {
        this.context = context;
        for (int i = 0 ; i <= 100; i++) {
            list.add(i);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /*
        Este es el método magico, el que devuelve la vista, Si prestan atencion devuelve un View
        pero nosotros creamos Un TextView, Nosotros podriamos crear un UsuarioView acá y para el adapter es exactamente lo mismo
        Siempre devuelve una view, que es la que el ListView agrega en su lista
     */
    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setText("Item " + position);

        // Esto es para cuando el usuario hace click en la lista, en este caso mostramos un alert, podriamos querer eliminar el item,
        // o abrir una nueva pantalla de detall del item, o muchas otras cosas mas
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Aprendiendo List Views")
                        .setMessage("Hiciste click en el item " + position)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Hacer algo con el click
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });


        return textView;
    }
}
