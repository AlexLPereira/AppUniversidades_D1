package br.usjt.ads20.appuniversidadesd1.Presenter;


import br.usjt.ads20.appuniversidadesd1.Model.Universidade;
import br.usjt.ads20.appuniversidadesd1.View.MainView;

/**
 * Nome: Alex Lopes Pereira
 * RA: 818143852
 */


public class MainPresenter implements Presenter {
    private Universidade model;
    MainView view;

    public MainPresenter(MainView view){
        this.view = view;
        model = new Universidade(); //Para realizar os testes
    }

    @Override
    public void onCreate() { model = new Universidade();

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }




}
