package com.example.csdn.frag;

import java.util.ArrayList;
import java.util.List;

import com.example.csdn.R;
import com.example.csdn.util.Utils;
import com.example.csdn.view.Text.AlignText;
import com.example.csdn.view.Text.BabushkaText;
import com.example.csdn.view.Text.BabushkaText.Piece;
import com.example.csdn.view.Text.MarqueeText;
import com.example.csdn.view.Text.MultipleTextView;
import com.example.csdn.view.Text.MultipleTextView.OnMultipleTVItemClickListener;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class BabushikaFrag extends Fragment implements
		OnMultipleTVItemClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// return inflater.inflate(R.layout.item_align_frag, container, false);
		View view = inflater.inflate(R.layout.item_babushika_frag, container,
				false);

		// Display "9.5 excellent!"

		BabushkaText babushka = (BabushkaText) view.findViewById(R.id.text);

		// Add the first piece "Central Park"
		babushka.addPiece(new BabushkaText.Piece.Builder("Central Park, NY\n")
				.textColor(Color.parseColor("#414141")).build());

		// Add the second piece "1.2 mi"
		babushka.addPiece(new BabushkaText.Piece.Builder("1.2 mi ")
				.textColor(Color.parseColor("#0081E2")).textSizeRelative(0.9f)
				.build());

		// Add the third piece "from here"
		babushka.addPiece(new BabushkaText.Piece.Builder("from here")
				.textColor(Color.parseColor("#969696")).textSizeRelative(0.9f)
				.build());
		Piece piece = babushka.getPiece(1);

		piece.setText("1.9 km ");

		// Display the final, styled text
		babushka.display();

		return view;
	}

	@Override
	public void onMultipleTVItemClick(View view, int position) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "位置：" + position, Toast.LENGTH_SHORT)
				.show();
	}
}
