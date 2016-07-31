package com.mukesh.prevailer.example;

public class MainActivityPresenter
    implements MainActivityContract.Presenter<MainActivityContract.View> {
  private MainActivityContract.View mView;
  private int counter = 0;

  @Override public void onViewAttached(MainActivityContract.View view) {
    mView = view;
    mView.showCount(String.valueOf(counter++));
  }
}
