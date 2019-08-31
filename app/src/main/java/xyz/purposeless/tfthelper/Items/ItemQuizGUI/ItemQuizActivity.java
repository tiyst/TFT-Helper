package xyz.purposeless.tfthelper.Items.ItemQuizGUI;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import xyz.purposeless.tfthelper.Items.ItemGUIElements.ItemBaseFragment;
import xyz.purposeless.tfthelper.Items.TFTItemBaseEnum;
import xyz.purposeless.tfthelper.Items.TFTItemEnum;
import xyz.purposeless.tfthelper.R;
import xyz.purposeless.tfthelper.Utils.Exception.TFTRuntimeException;

public class ItemQuizActivity extends AppCompatActivity implements ItemBaseFragment.TFTItemListener {

	private enum INTERACTION_STATUS {
		START("Start"),
		CORRECT("Correct"),
		WRONG("Wrong"),
		DEFEAT("Defeat");

		public final String statusName;

		INTERACTION_STATUS(String name) {
			statusName = name;
		}
	}

	private INTERACTION_STATUS interactionStatus;

	private int health;
	private int score;
	private List<TFTItemEnum> itemsToGuess; //All items

	private TFTItemEnum requiredItem;
	private List<TFTItemBaseEnum> baseItems; //Guessed items

	//GUI Stuff
	private TextView  scoreText;
	private TextView  requiredItemNameText;
	private ImageView requiredItemImage;
	private ImageView baseItemOneImage;
	private ImageView baseItemTwoImage;
	private Button interactionButton;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_quiz);

		this.itemsToGuess = TFTItemEnum.getActualValues();
		this.health = 3;
		this.score = 0;
		this.baseItems = new ArrayList<>();

		this.requiredItemNameText = findViewById(R.id.combinedItemName);
		this.scoreText 		   = findViewById(R.id.scoreText);
		this.requiredItemImage = findViewById(R.id.combinedItemImage);
		this.baseItemOneImage  = findViewById(R.id.baseItemOneImage);
		this.baseItemTwoImage  = findViewById(R.id.baseItemTwoImage);
		this.interactionButton = findViewById(R.id.interactionButton);
		this.interactionButton.setVisibility(View.INVISIBLE);

		populateBaseItems();
		getNewResultItem();
		updateScore(0);
	}

	@Override
	public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
		return super.onCreateView(parent, name, context, attrs);
	}

	private void populateBaseItems() {
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();

		for (TFTItemBaseEnum item: TFTItemBaseEnum.values()) {
			transaction.add(R.id.baseItemsLayout, ItemBaseFragment.newInstance(item));
		}

		transaction.commit();
	}

	private void fail() {
		switch (--health) {
			case 2:	findViewById(R.id.heartImage3).setAlpha(0.5f);
				break;
			case 1: findViewById(R.id.heartImage2).setAlpha(0.5f);
				break;
			case 0: findViewById(R.id.heartImage1).setAlpha(0.5f);
					setInteractionStatus(INTERACTION_STATUS.DEFEAT);
				break;
		}
	}

	public void startAgain() {
		findViewById(R.id.heartImage3).setAlpha(1.0f);
		findViewById(R.id.heartImage2).setAlpha(1.0f);
		findViewById(R.id.heartImage1).setAlpha(1.0f);
		findViewById(R.id.interactionButton).setVisibility(View.INVISIBLE);
		updateScore(0);
		getNewResultItem();
	}


	private void getNewResultItem() {
		this.requiredItem = itemsToGuess.remove(new Random().nextInt(itemsToGuess.size() - 2));
		this.requiredItemNameText.setText(this.requiredItem.getItemName());
		this.requiredItemImage.setImageResource(this.requiredItem.getItemImageID());
		this.baseItems.clear();

		this.baseItemOneImage.setImageResource(R.drawable.question_mark);
		this.baseItemTwoImage.setImageResource(R.drawable.question_mark);
	}

	private void updateScore() {
		updateScore(++this.score);
	}

	private void updateScore(int score) {
		this.score = score;
		this.scoreText.setText(getResources().getString(R.string.score) + this.score);
	}

	@Override
	public void onBaseItemInteraction(TFTItemBaseEnum item) {
		baseItems.add(item);

		if (baseItems.size() == 1) { //first item added
			this.baseItemOneImage.setImageResource(item.getItemImageID());
		} else {
			this.baseItemTwoImage.setImageResource(item.getItemImageID());
		}

		if (baseItems.size() == 2) {
			List<TFTItemBaseEnum> componentItems = new ArrayList<>(Arrays.asList(this.requiredItem.getBaseItems()));
			if (componentItems.remove(baseItems.get(0)) && componentItems.remove(baseItems.get(1))) {
				setInteractionStatus(INTERACTION_STATUS.CORRECT);
			} else {
				setInteractionStatus(INTERACTION_STATUS.WRONG);
			}
//			baseItems.clear();
		}
	}

	private void setInteractionButtonText(String text) {
		this.interactionButton.setText(text);
	}

	private void setInteractionStatus(INTERACTION_STATUS status) {
		this.interactionStatus = status;
		this.interactionButton.setVisibility(View.VISIBLE);

		switch (interactionStatus) {
			case START: startAgain();
				break;
			case CORRECT: //getNewResultItem();
				updateScore();
				Toast.makeText(this, R.string.itemQuizCorrect, Toast.LENGTH_SHORT).show();
				setInteractionButtonText(getResources().getString(R.string.itemQuizNextItem));
				break;
			case WRONG: fail();
				setInteractionButtonText(getResources().getString(R.string.itemQuizNextItem));
				showCorrectItems();
				break;
			case DEFEAT: //defeat();
				Toast.makeText(this, R.string.itemQuizOutOfLives, Toast.LENGTH_SHORT).show();
				setInteractionButtonText(getResources().getString(R.string.itemQuizTryAgain));
				break;

			default:
				throw new TFTRuntimeException("Interaction status not defined: " + this.interactionStatus);
		}

	}

	private void showCorrectItems() {
		TFTItemBaseEnum[] baseItems = this.requiredItem.getBaseItems();
		this.baseItemOneImage.setImageResource(baseItems[0].getItemImageID());
		this.baseItemTwoImage.setImageResource(baseItems[1].getItemImageID());

	}

	public void interactionButtonPressed(View v) {
		switch (this.interactionStatus) {
			case CORRECT:
			case WRONG:
				getNewResultItem();
				break;

			case DEFEAT:
				this.health = 3;
			case START:
				startAgain();
				break;

			default:
				throw new TFTRuntimeException("Interaction status not defined" + this.interactionStatus);
		}
		this.interactionButton.setVisibility(View.INVISIBLE);
	}
}
