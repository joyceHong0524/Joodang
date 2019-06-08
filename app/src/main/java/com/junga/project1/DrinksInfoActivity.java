package com.junga.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintHelper;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import static com.junga.project1.CardPagerAdatper.SOJU;

public class DrinksInfoActivity extends AppCompatActivity implements View.OnClickListener{

    Placeholder placeHolder;
    private ConstraintLayout layout;
    Button button1;
    Button button2;
    Button button3;
    ImageView titleImage;
    TextView drinkName,historyTitle,historyContent,howTo,howToContent,foodTitle,foodContent;

    int type;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_info);

        layout= (ConstraintLayout) findViewById(R.id.layout);



        Intent intent = getIntent();
        type = intent.getIntExtra("type",0);

        drinkName = (TextView) findViewById(R.id.drink_name);
        historyTitle = (TextView)findViewById(R.id.title_history);
        historyContent=(TextView)findViewById(R.id.content_history);
        howTo =(TextView)findViewById(R.id.how_title);
        howToContent=(TextView)findViewById(R.id.how_content);
        foodTitle=(TextView)findViewById(R.id.food_title);
        foodContent=(TextView)findViewById(R.id.food_content);

        titleImage = (ImageView) findViewById(R.id.imageView);
        ImageView overlay = (ImageView)findViewById(R.id.imageView3);


        setView(type);
        Glide.with(this).load(R.drawable.overlay).into(overlay);

        button1 =(Button) findViewById(R.id.button5);
        button2 =(Button) findViewById(R.id.button6);
        button3 =(Button) findViewById(R.id.button7);

        if(type==CardPagerAdatper.CHEONGJU) {button3.setText("brand");}
        if(type==CardPagerAdatper.MAKGEOLLI) {button3.setText("When?");}



        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");

        setSupportActionBar(toolbar);


        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu1,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return true;

        }
    }

    public void swapView(View v){
        TransitionManager.beginDelayedTransition(layout);
        placeHolder.setContentId(v.getId());

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button5){
            generateSnackBar(1);
        }else if(view.getId() ==R.id.button6){
            generateSnackBar(2);
        }else if (view.getId() == R.id.button7){
            generateSnackBar(3);
        }
    }

    public void generateSnackBar(int id){

        switch (type){
            case CardPagerAdatper.SOJU:
                if(id ==1) {
                    Snackbar snackbar = Snackbar.make(layout, "It is about 1 dollor/bottle :D", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else if(id==2){
                    Snackbar snackbar = Snackbar.make(layout,"Almost 18%, Slow dowon when you drink",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else if(id==3){
                    Snackbar snackbar = Snackbar.make(layout,"There are a lot of fruit flavors !!",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                break;
            case CardPagerAdatper.CHEONGJU:
                if(id ==1) {
                    Snackbar snackbar = Snackbar.make(layout, "It is about 4 dollor/bottle :D", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else if(id==2){
                    Snackbar snackbar = Snackbar.make(layout,"13%, Still pretty high! ",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else if(id==3){
                    Snackbar snackbar = Snackbar.make(layout,"Cheong-ha is most popular brand!",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                break;
            case CardPagerAdatper.MAKGEOLLI:
                if(id ==1) {
                    Snackbar snackbar = Snackbar.make(layout, "It is about 1 dollor/bottle :D", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else if(id==2){
                    Snackbar snackbar = Snackbar.make(layout,"6-8%, It is like strong beer!",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else if(id==3){
                    Snackbar snackbar = Snackbar.make(layout,"You should drink this on rainy day with pajeon!!",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                break;
            default:
                break;

        }

    }

    private void setView(int type){
        switch (type){
            case CardPagerAdatper.SOJU:
                drinkName.setText(R.string.name_soju);
                historyTitle.setText(R.string.history_title_soju);
                historyContent.setText(R.string.history_content_soju);
                howTo.setText(R.string.how_to);
                howToContent.setText(R.string.how_to_soju);
                foodTitle.setText(R.string.food_with);
                foodContent.setText(R.string.food_with_soju);

                Glide.with(this).load(R.drawable.info_soju).into(titleImage);

                break;
            case CardPagerAdatper.CHEONGJU:
                drinkName.setText(R.string.name_cheongju);
                historyTitle.setText(R.string.history_title_cheongju);
                historyContent.setText(R.string.history_content_cheongju);
                howTo.setText(R.string.how_to);
                howToContent.setText(R.string.how_to_cheongju);
                foodTitle.setText(R.string.variety_cheongju_title);
                foodContent.setText(R.string.variety_cheongju_content);

                Glide.with(this).load(R.drawable.info_choengju).into(titleImage);

                break;
            case CardPagerAdatper.MAKGEOLLI:

                drinkName.setText(R.string.name_makgeolli);
                historyTitle.setText(R.string.history_title_makgeoli);
                historyContent.setText(R.string.history_content_makgeolli);
                howTo.setText(R.string.how_to_drink_makgeolli);
                howToContent.setText(R.string.how_to_makgeolli);
                foodTitle.setText(R.string.food_with);
                foodContent.setText(R.string.food_with_makgeolli);

                Glide.with(this).load(R.drawable.info_makgeolli).into(titleImage);

                break;
            default:
                break;






        }
    }

}
