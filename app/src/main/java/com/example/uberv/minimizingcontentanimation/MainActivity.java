package com.example.uberv.minimizingcontentanimation;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements ContentFragment.OnFragmentInteractionListener, View.OnClickListener {

    RelativeLayout mRootLayout;
    FrameLayout mContainer;
    ContentFragment mContentFragment;
    boolean isMinimized=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootLayout= (RelativeLayout) findViewById(R.id.activity_main);
        mContainer = (FrameLayout) findViewById(R.id.container);
        mContainer.setOnClickListener(this);

        mContentFragment = ContentFragment.newInstance(null,null);
        getSupportFragmentManager().beginTransaction().add(R.id.container,mContentFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_animate:
                animate();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void animate() {
        if(isMinimized){
            // reverse animation
            mRootLayout.animate().translationX(0).scaleX(1).scaleY(1);
            //mContainer.animate().translationX(0).scaleX(1).scaleY(1);
        }else{
            // minmize
            mRootLayout.animate().translationX(600).scaleX(0.9f).scaleY(0.9f);
            //mContainer.animate().translationX(600).scaleX(0.9f).scaleY(0.9f);
        }
        isMinimized=!isMinimized;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Fragment clicked", Toast.LENGTH_SHORT).show();
    }
}
