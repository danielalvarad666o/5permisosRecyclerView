package com.gasca1234.a5permisos.Adaptrpermiso;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.gasca1234.a5permisos.Modelo.Permiso;
import com.gasca1234.a5permisos.R;

import java.util.List;

public class Adaptadorpermiso extends RecyclerView.Adapter<Adaptadorpermiso.viewholder> {
List<Permiso> lp;
    int request_code = 200;
public Adaptadorpermiso(List<Permiso>lp){this.lp=lp;}
    @NonNull
    @Override
    public Adaptadorpermiso.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.itempersimso,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptadorpermiso.viewholder holder, int position) {
holder.setData(lp.get(position));

    }

    @Override
    public int getItemCount() {
        return lp.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
    TextView txtpermiso;
    Permiso permisoholder;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtpermiso=(TextView) itemView.findViewById(R.id.txtname);
            itemView.setOnClickListener(this::onClick);
        }

        private void onClick(View view) {
            if(txtpermiso.getText()=="llamada")
            {
llamada();
            }
            else if (txtpermiso.getText()=="mensaje")
            {
mensaje();
            }
            else if (txtpermiso.getText()=="camara")
            {
                camara();
            }
            else  if (txtpermiso.getText()=="video")
            {
                video();
            }
            else if (txtpermiso.getText()=="bluetooth")
            {
                bluetooth();
            }
        }

        private void bluetooth() {
            if (ContextCompat.checkSelfPermission(itemView.getContext(),Manifest.permission.BLUETOOTH)!=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions((Activity) itemView.getContext(),new String[]{Manifest.permission.BLUETOOTH},request_code);
            }else
            {
                Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                itemView.getContext().startActivity(intent);
            }
        }

        private void video() {
            if (ContextCompat.checkSelfPermission(itemView.getContext(),Manifest.permission.INTERNET)!=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions((Activity) itemView.getContext(),new String[]{Manifest.permission.INTERNET},request_code);
            }else
            {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                itemView.getContext().startActivity(intent);
            }
        }

        private void camara() {


if (ContextCompat.checkSelfPermission(itemView.getContext(),Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED)
{
    ActivityCompat.requestPermissions((Activity) itemView.getContext(),new String[]{Manifest.permission.CAMERA},request_code);
}else
{
    Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        itemView.getContext().startActivity(intent);
}


        }

        private void mensaje() {
            Uri uri = Uri.parse("smsto:8711340531");
            if (ContextCompat.checkSelfPermission(itemView.getContext(),Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions((Activity) itemView.getContext(),new String[]{Manifest.permission.SEND_SMS},request_code);
            }else
            {
              //  String dial=uri;
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                itemView.getContext().startActivity(intent);
            }

        }

        private void llamada() {
            Uri uri = Uri.parse("tel:8711340531");
              //  String uri="8711340531";
          //  String phone = "tel:" + uri;
            if (ContextCompat.checkSelfPermission(itemView.getContext(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) itemView.getContext(),
                        new String[]{Manifest.permission.CALL_PHONE}, request_code);
            } else {
              //  String dial = phone;
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                itemView.getContext().startActivity(intent);
            }
        }

        public void setData(Permiso permiso) {
            permisoholder =permiso;
            txtpermiso.setText(permiso.getPermiso1());
        }
    }
}
