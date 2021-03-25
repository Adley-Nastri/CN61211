package com.u1803005.D2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.u1803005.D2.api.BungieAPI;
import com.u1803005.D2.api.models.RSDP;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BungieAPI.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BungieAPI bungie = retrofit.create(BungieAPI.class);



        Call<RSDP> call = bungie.searchPlayer();

        //Call<Response_SearchDestinyPlayer> call2 = bungo.searchPlayer();



        call.enqueue(new Callback<RSDP>() {
            @Override
            public void onResponse(Call<RSDP> call, Response<RSDP> response) {


                if (!response.isSuccessful()) {
                    textViewResult.setText("Code : "+ response.code());
                    return;
                }
                //List<Response_SearchDestinyPlayer> sdp = response.body();

                /*for (Response_SearchDestinyPlayer player : sdp){
                    String content = "";
                    content += "Response : " + player.getResponse() + "\n";

                    textViewResult.append(content);
                    Log.d("", content);
                }*/

                RSDP res = response.body();


                String content = "";
                for (int i =0 ; i <  res.response.size(); i++) {
                    content += "Display name : " + res.response.get(i).displayName + "\n";
                    content += "Icon Path : " + res.response.get(i).iconPath + "\n";
                    content += "Membership ID : " + res.response.get(i).membershipId + "\n\n";

                    
                }

                textViewResult.setText(content);

                Log.d("", ""+response.code());
            }

            @Override
            public void onFailure(Call<RSDP> call, Throwable t) {
                textViewResult.setText(t.getMessage());
                Log.d("", t.getMessage());
            }
        });





        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}