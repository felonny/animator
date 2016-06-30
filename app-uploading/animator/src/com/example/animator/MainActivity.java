package com.example.animator;

import java.util.ArrayList;
import java.util.List;


import android.support.v7.app.ActionBarActivity;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity implements OnClickListener{

	private int[] res = {R.id.imageView_a,R.id.imageView_b,R.id.imageView_c,R.id.imageView_d,R.id.imageView_e,R.id.imageView_f,
			R.id.imageView_g,R.id.imageView_h};
	private List<ImageView> imageList = new ArrayList<ImageView>();
	private boolean flag = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for(int i = 0;i<res.length;i++){
			ImageView imageView = (ImageView) findViewById(res[i]);
			imageView.setOnClickListener(this);
			imageList.add(imageView);
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imageView_a:
			if(flag){
				startAnimate();
			}else{
				closeAnimate();
			}
			
			break;

		default:
			Toast.makeText(MainActivity.this, "clicked"+v.getId(), Toast.LENGTH_SHORT).show();
			break;
		}
		
	}
	@SuppressLint("NewApi")
	private void closeAnimate() {
		// TODO Auto-generated method stub
		for(int i = 1;i<res.length;i++){
			ObjectAnimator animator = ObjectAnimator.ofFloat(imageList.get(i), "translationY", i*150,0F);
			animator.setDuration(500);
			animator.setStartDelay(i*300);
			animator.start();
			flag = true;
		}
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	private void startAnimate() {
		// TODO Auto-generated method stub
		for(int i = 1;i<res.length;i++){
			ObjectAnimator animator = ObjectAnimator.ofFloat(imageList.get(i), "translationY", 0F,i*150);
			animator.setDuration(500);
			animator.setInterpolator(new BounceInterpolator());
			animator.setStartDelay(i*300);
			animator.start();
			flag = false;
		}
	}

	
}
