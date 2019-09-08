package xyz.purposeless.tfthelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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

		if(getSupportActionBar() != null) {
			getSupportActionBar().hide();
		}

		this.disclaimerText = findViewById(R.id.aboutUsDisclaimerText);
		this.disclaimerText.setText("\"" + getResources().getString(R.string.app_name) + "\" " + getResources().getString(R.string.disclaimerText));
	}

	public void sendMailButton(View v) {
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(Intent.EXTRA_EMAIL  ,  new String[] {"tiystw@gmail.com"});
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "TFT Guide app suggestion");
		emailIntent.putExtra(Intent.EXTRA_TEXT   , "Hello\n\n,My suggestion is:\n");
		emailIntent.setType("text/plain");
		startActivity(emailIntent);
	}

	public void supportUsButton(View v) {
		startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.ko-fi.com/tiystw")));

	}


}
