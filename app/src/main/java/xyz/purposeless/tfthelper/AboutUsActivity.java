package xyz.purposeless.tfthelper;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUsActivity extends AppCompatActivity {

	private ImageView logoImage;
	private TextView mainText;

	private TextView disclaimerText;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);

		this.disclaimerText = findViewById(R.id.disclaimerText);
		this.disclaimerText.setText(getResources().getString(R.string.app_name) + " " + getResources().getString(R.string.disclaimerText));
	}


}
