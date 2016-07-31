package com.mukesh.prevailer.example;

public interface MainActivityContract {
  interface View {
    void showCount(String count);
  }

  interface Presenter<View> {
    void onViewAttached(View v);
  }
}
