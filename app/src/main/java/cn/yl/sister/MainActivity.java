package cn.yl.sister;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import cn.yl.loader.PictureLoader;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button showBtn;
    private ImageView showImg;
    private ArrayList<String> urls;
    private int curPos = 0;
    private PictureLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loader = new PictureLoader();
        initData();
        initUI();
    }

    private void initData() {
        urls = new ArrayList<String>();
        urls.add("http://www.y3l.top/img/boy_1.png");
        urls.add("http://www.y3l.top/img/boy_2.png");
        urls.add("http://www.y3l.top/img/boy_3.png");
        urls.add("http://www.y3l.top/img/boy_4.png");
        urls.add("http://www.y3l.top/img/boy_5.png");
        urls.add("http://www.y3l.top/img/boy_6.png");
    }

    private void initUI() {
        showImg = (ImageView) findViewById(R.id.main_img_girl);
        showBtn = (Button) findViewById(R.id.main_btn_show_img);

        showBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.main_btn_show_img:
                if (curPos > 5){
                    curPos = 0;
                }
                loader.load(showImg,urls.get(curPos));
                curPos++;
                break;
        }
    }
}
