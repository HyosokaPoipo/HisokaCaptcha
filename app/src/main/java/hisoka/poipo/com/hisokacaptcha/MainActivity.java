package hisoka.poipo.com.hisokacaptcha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView captchaImage;
    Button refreshBtn, cekBtn;
    RadioButton numRB;
    EditText userCaptcha;
    TextView result;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing variables
        numRB = (RadioButton)findViewById(R.id.aritmatika_rb);
        cekBtn = (Button)findViewById(R.id.cek_btn);
        refreshBtn = (Button) findViewById(R.id.refresh_btn);
        captchaImage = (ImageView) findViewById(R.id.captcha_im);
        userCaptcha = (EditText) findViewById(R.id.insertedCaptca_et);
        result = (TextView) findViewById(R.id.result_tv);


        //Initializing our first captcha....
        MainCaptchaHyosoka c = new MathOperationCaptchaHyosoka(300, 100, MathOperationCaptchaHyosoka.MathOptions.PLUS_MINUS_MULTIPLY);
        captchaImage.setImageBitmap(c.image);
        answer = c.answer;


        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numRB.isChecked())
                {
                    MainCaptchaHyosoka c = new MathOperationCaptchaHyosoka(300, 100, MathOperationCaptchaHyosoka.MathOptions.PLUS_MINUS_MULTIPLY);
                    captchaImage.setImageBitmap(c.image);
                    answer = c.answer;
                }else
                {
                    MainCaptchaHyosoka c = new TextCaptchaHyosoka(300, 100, 5, TextCaptchaHyosoka.TextOptions.NUMBERS_AND_LETTERS);
                    captchaImage.setImageBitmap(c.image);
                    answer = c.answer;
                }
            }
        });

        cekBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = userCaptcha.getText().toString();
                if(userAnswer.equalsIgnoreCase(answer))
                {
                    result.setText("Your answer was soo coool... :D " + "-->" + answer);
                }else
                {
                    result.setText("Sorry... You were wrong...! Please try again... :v");
                    if(numRB.isChecked())
                    {
                        MainCaptchaHyosoka c = new MathOperationCaptchaHyosoka(300, 100, MathOperationCaptchaHyosoka.MathOptions.PLUS_MINUS_MULTIPLY);
                        captchaImage.setImageBitmap(c.image);
                        answer = c.answer;
                    }else
                    {
                        MainCaptchaHyosoka c = new TextCaptchaHyosoka(300, 100, 5, TextCaptchaHyosoka.TextOptions.NUMBERS_AND_LETTERS);
                        captchaImage.setImageBitmap(c.image);
                        answer = c.answer;
                    }
                }

            }
        });
    }
}
