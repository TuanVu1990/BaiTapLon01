package tutorial.freelancertraning.tuanvu.baitaplon01.Menuactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import tutorial.freelancertraning.tuanvu.baitaplon01.ActualiesActivity.ActualitesActivity;
import tutorial.freelancertraning.tuanvu.baitaplon01.AdvantagesActivity.AdvantagesActivity;
import tutorial.freelancertraning.tuanvu.baitaplon01.AgendarActivity.ProfileActivity;
import tutorial.freelancertraning.tuanvu.baitaplon01.Membres.MembresActivity;
import tutorial.freelancertraning.tuanvu.baitaplon01.R;
import tutorial.freelancertraning.tuanvu.baitaplon01.SearchActivity.SearchActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etSearch;
    Button btnAgenda;
    Button btnActualies;
    Button btnMembres;
    Button btnAdvantages;
    Button btnLeaderboard;
    Button btnMoncompte;
    Button btnDeconnexion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        initClick();
        etSearch.setOnClickListener(this);
        btnAgenda.setOnClickListener(this);
        btnDeconnexion.setOnClickListener(this);
        btnMoncompte.setOnClickListener(this);
        btnLeaderboard.setOnClickListener(this);
        btnMembres.setOnClickListener(this);
        btnActualies.setOnClickListener(this);
        btnAdvantages.setOnClickListener(this);
    }

    private void initClick() {
        etSearch = (EditText) findViewById(R.id.etSearch);
        btnAgenda = (Button) findViewById(R.id.btnAgenda);
        btnActualies = (Button) findViewById(R.id.btnActualies);
        btnAdvantages = (Button) findViewById(R.id.btnAdvantages);
        btnMembres = (Button) findViewById(R.id.btnMembres);
        btnLeaderboard = (Button) findViewById(R.id.btnLeaderboard);
        btnMoncompte = (Button) findViewById(R.id.btnMoncompte);
        btnDeconnexion = (Button) findViewById(R.id.btnDeconnexion);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.etSearch:
                goToSearchScreen();
                break;
            case R.id.btnAgenda:
                goToAgendaScreen();
                break;
            case R.id.btnActualies:
                goToActualiesScreen();
                break;
            case R.id.btnAdvantages:
                goToAdvantagesScreen();
                break;
//            case R.id.btnDeconnexion:
//                goToDeconnexionScreen();
//                break;
//            case R.id.btnLeaderboard:
//                goToLeaderboardScreen();
//                break;
            case R.id.btnMembres:
                goToMembresScreen();
//                break;
//            case R.id.btnMoncompte:
//                goToMoncompte();
//                break;
        }

    }

//    private void goToMoncompte() {
//        Intent intent = new Intent(MenuActivity.this,);
//        startActivity(intent);
//    }
//
    private void goToMembresScreen() {
        Intent intent = new Intent(MenuActivity.this, MembresActivity.class);
        startActivity(intent);
    }
//
//    private void goToLeaderboardScreen() {
//        Intent intent = new Intent(MenuActivity.this,);
//        startActivity(intent);
//    }
//
//    private void goToDeconnexionScreen() {
//        Intent intent = new Intent(MenuActivity.this,);
//        startActivity(intent);
//    }
//
    private void goToAdvantagesScreen() {
        Intent intent = new Intent(MenuActivity.this, AdvantagesActivity.class);
        startActivity(intent);
    }

    private void goToActualiesScreen() {
        Intent intent = new Intent(MenuActivity.this, ActualitesActivity.class);
        startActivity(intent);
    }

    private void goToAgendaScreen() {
        Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    private void goToSearchScreen() {
        Intent intent = new Intent(MenuActivity.this, SearchActivity.class);
        startActivity(intent);
    }
}
