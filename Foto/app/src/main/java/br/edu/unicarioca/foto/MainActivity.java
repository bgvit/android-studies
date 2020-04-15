package br.edu.unicarioca.foto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void dispararFoto(){
        Intent tirar = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(tirar.resolveActivity(getPackageManager())!=null){
            startActivityForResult(tirar, REQUEST_IMAGE_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            b = imageBitmap;
            ImageView canvas = (ImageView)findViewById(R.id.canvas);
            canvas.setImageBitmap(imageBitmap);
        }
    }
    public void acaoFoto(View v){
        dispararFoto();
    }

    public void fotoSalvar(View v) throws IOException {
        FileOutputStream outStream = new FileOutputStream(createImageFile());
        b.compress(Bitmap.CompressFormat.PNG, 100, outStream);
        outStream.close();
        Toast.makeText(this, "Foto Salva com Sucesso", Toast.LENGTH_SHORT).show();
    }

    private File createImageFile() throws IOException {
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String nomeArquivo = ( (EditText) findViewById(R.id.nomeFoto)).getText().toString();
        File image = new File(storageDir, nomeArquivo + ".png");
        return image;
    }

}
