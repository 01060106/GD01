package com.tqc.gdd01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class GDD01 extends Activity
{
  private EditText etheight;
  private EditText etweight;
  private RadioButton rb1;
  private RadioButton rb2;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Button b1 = (Button) findViewById(R.id.button1);
    rb1 =findViewById(R.id.rb_M);
    rb2 =findViewById(R.id.rb_F);


    b1.setOnClickListener(new Button.OnClickListener()
    {
      public void onClick(View v)
      {
        //從輸入介面中取出了的身高、體重值，要將身高、體重值傳送給 child_Activity 後作計算
          etheight = findViewById(R.id.tv_Height);
          etheight = findViewById(R.id.tv_Weight);


          Bundle bundle =new Bundle();
          bundle.putString("h",etheight.getText().toString());
          bundle.putString("w",etweight.getText().toString());
          if(rb1.isChecked()){
            bundle.putString("Sex","M");

          }else{
            bundle.putString("Sex","F");

          }

        //這些附加在 Intent 上的訊息都儲存在 Bundle 物件中
          Intent intent =new Intent(GDD01.this,GDD01_child.class);
          intent.putExtras(intent);
        //透過「intent.putExtras(bundle)」敘述，將「bundle」 物件附加在 Intent 上，隨著 Intent 送出而送出

      }
    });
  }

}
