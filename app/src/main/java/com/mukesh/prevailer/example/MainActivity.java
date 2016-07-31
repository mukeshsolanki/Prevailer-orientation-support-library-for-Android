package com.mukesh.prevailer.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.mukesh.Prevailer;
import com.mukesh.PrevailerFactory;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

  private TextView mCountTextView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeUx();
    initializePrevailer();
  }

  private void initializePrevailer() {
    Prevailer.init(this, 23, new PrevailerFactory<MainActivityPresenter>() {
      @Override public MainActivityPresenter create() {
        return new MainActivityPresenter();
      }
    }, new Prevailer.OnInstanceReloadedAction<MainActivityPresenter>() {
      @Override public void performAction(MainActivityPresenter presenter) {
        presenter.onViewAttached(MainActivity.this);
      }
    }, new Prevailer.OnInstanceDestroyedAction() {
      @Override public void performAction() {

      }
    });
  }

  private void initializeUx() {
    mCountTextView = (TextView) findViewById(R.id.count);
  }

  @Override public void showCount(String count) {
    mCountTextView.setText(count);
  }
}
