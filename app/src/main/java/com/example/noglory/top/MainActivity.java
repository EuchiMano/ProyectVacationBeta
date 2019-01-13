package com.example.noglory.top;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.containerMain)
    CoordinatorLayout containerMain;

    private ProplayerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configToolbar();
        configAdapter();
        configRecyclerView();
        generateProplayer();
    }

    private void generateProplayer() {
        String[] nombres = {"Amer", "Salehi", "Lasse", "Maroun"};
        String[] apellidos = {"Al-Barkawi", "Takhasomi", "Aukusti", "Merhej"};
        long[] nacimientos = {864086400000L, 720230400000L, 794188800000L, 800668800000L};
        String[] lugares = {"Jordan", "Germany", "Finland", "Lebanon"};
        short[] estaturas = {175, 170, 175, 160};
        String[] notas = {"Miracle- joined Balkan Bears at the beginning of 2015, only to be removed from the team about four months later. While he was teamless, he began gaining recognition in the European scene by climbing the matchmaking rating leaderboards in pub games. Miracle- eventually became the #1 player by MMR in the European division and the world, surpassing w33.", "KuroKy played for a few German DotA teams before joining his first international team, mousesports, where he played with players such as Drayich. This mousesports lineup attended DreamHack Winter 2008 with Puppey acting as stand-in; this was to be the beginning of a long relationship between KuroKy and Puppey. KuroKy then joined Ks.int, which at one point had a total number of 9 players and looked more like a mix than an actual team. Some well known players in the DotA scene were on the team, such as Puppey, Vigoss and LevenT.", "MATUMBAMAN made a name for himself by winning the Assembly Summer 2014 LAN tournament with the team Veni,Vidi,Vici, in the process defeating Trixi's team FINSTACK in the finals and the team seppo13 (previously known as Team Menace) in the semi-finals. Throughout the games, MATUMBAMAN showed off his extreme mechanical skill on heroes such as Tinker and Ember Spirit and caught the eye of many Dota 2 fans. MATUMBAMAN later had the opportunity to try out for Fnatic with Trixi, but was not picked up as Fnatic disbanded shortly after. Instead Trixi formed the all-Finnish stack 4 Anchors + Sea Captain with MATUMBAMAN, JerAx, Vaalix, and Buugi in late September 2014. Shortly after in the beginning of 2015, JerAx left the team to join Team Tinker.", "GH was originally part of Wired Gaming, who gained notoriety for winning the MSI BEAT IT 2014 Middle Eastern Qualifiers. After this achievement, the team was picked up by the E-LAB organization who are often considered to be the first Middle Eastern organization to sponsor a Dota 2 team."};
        String[] fotoUrl = {"https://liquipedia.net/commons/images/f/f2/Miracle_SL_i-League.jpg", "https://liquipedia.net/commons/images/d/db/Kuroky_profile.jpg", "https://liquipedia.net/commons/images/4/4b/Matumba_profile.jpg","https://liquipedia.net/commons/images/6/67/GH_SL_i-League.jpg"};

        for (int i = 0; i<4; i++){
          ProPlayer proplayer = new ProPlayer(i+1, nombres[i], apellidos[i], nacimientos[i], lugares[i], estaturas[i], notas[i], i+1, fotoUrl[i]);
            adapter.add(proplayer);
        }
    }

    private void configToolbar() {
        setSupportActionBar(toolbar);
    }

    private void configAdapter() {
        adapter = new ProplayerAdapter(new ArrayList<ProPlayer>(),this);
    }

    private void configRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
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

    //Metodos implementados por la intefaz OnItemClickListener
    //

    @Override
    public void OnItemClick(ProPlayer proPlayer) {

    }

    @Override
    public void onLongItemClick(ProPlayer proplayer) {

    }
}
