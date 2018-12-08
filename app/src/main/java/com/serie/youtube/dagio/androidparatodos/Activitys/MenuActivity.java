package com.serie.youtube.dagio.androidparatodos.Activitys;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;



import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.serie.youtube.dagio.androidparatodos.R;

import java.util.ArrayList;


public class MenuActivity extends AppCompatActivity {


private BoomMenuButton bmb;
ArrayList<Integer> imageIDList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bmb=findViewById(R.id.bmb);
        imageIDList=new ArrayList<>();
        setInitialData();



        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            SimpleCircleButton.Builder builder = new SimpleCircleButton.Builder()
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                            if (index==0){
                                Toast.makeText(MenuActivity.this, "presinaste el cero " , Toast.LENGTH_SHORT).show();
                            }else if(index==1){
                                Toast.makeText(MenuActivity.this, "presinaste el 1 " , Toast.LENGTH_SHORT).show();

                            }else if (index==2){
                                Toast.makeText(MenuActivity.this, "presinaste el 2 " , Toast.LENGTH_SHORT).show();

                            }

                        }
                    })
                    .pieceColor(Color.WHITE)
                    .normalImageRes(imageIDList.get(i));

            bmb.addBuilder(builder);

        }

    }

    private void setInitialData() {
        imageIDList.add(R.drawable.xml);
        imageIDList.add(R.drawable.java);
        imageIDList.add(R.drawable.gradlelogo);
    }
}
