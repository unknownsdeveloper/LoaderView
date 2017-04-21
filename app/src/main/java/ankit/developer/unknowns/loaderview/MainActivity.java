package ankit.developer.unknowns.loaderview;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.elyeproj.loaderviewlibrary.LoaderImageView;
import com.elyeproj.loaderviewlibrary.LoaderTextView;

public class MainActivity extends AppCompatActivity {
    LoadDataHelper myLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();



        Button btnReset = (Button)findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                resetLoader();

            }

        });
    }
    private void resetLoader() {

        ((LoaderTextView)findViewById(R.id.txtName)).resetLoader();

        ((LoaderTextView)findViewById(R.id.txtTitle)).resetLoader();

        ((LoaderImageView)findViewById(R.id.image_icon)).resetLoader();



        ((LoaderTextView)findViewById(R.id.txtName1)).resetLoader();

        ((LoaderTextView)findViewById(R.id.txtTitle1)).resetLoader();

        ((LoaderImageView)findViewById(R.id.image_icon1)).resetLoader();



        //

        loadData();

    }



    private void loadData() {

        if(myLoader != null)

            myLoader.cancel(true);

        myLoader = new LoadDataHelper();

        myLoader.execute();

    }



    private class LoadDataHelper extends AsyncTask<Void,Void,Void> {

        @Override

        protected Void doInBackground(Void... voids) {

            try{

                Thread.sleep(3000); // wait for 3 secs

            }

            catch (InterruptedException e){

                e.printStackTrace();

            }



            return null;

        }



        @Override

        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);

            setData();

        }

    }



    private void setData() {

        ((TextView)findViewById(R.id.txtName)).setText("Batman");

        ((TextView)findViewById(R.id.txtTitle)).setText("D.C Comic");

        ((ImageView)findViewById(R.id.image_icon)).setImageResource(R.mipmap.ic_launcher);



        ((TextView)findViewById(R.id.txtName1)).setText("Iron man");

        ((TextView)findViewById(R.id.txtTitle1)).setText("Marvel Comic");

        ((ImageView)findViewById(R.id.image_icon1)).setImageResource(R.mipmap.ic_launcher);

    }
}
