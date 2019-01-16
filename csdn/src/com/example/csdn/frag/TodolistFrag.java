package com.example.csdn.frag;

import java.util.ArrayList;

import com.example.csdn.R;
import com.example.csdn.util.Utils;
import com.example.csdn.view.Text.AlignText;
import com.example.csdn.view.Text.TodoListItemView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TodolistFrag extends BaseFrag {
	private ListView myListView;
	private ArrayList<String> toDoItems = new ArrayList<String>();



	@Override
	public void onResume() {
		toDoItems.add(0, "a");
		toDoItems.add(0, "b");
		toDoItems.add(0, "c");
		toDoItems.add(0, "d");
		final ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
				R.layout.item_tolist_item, R.id.todo, toDoItems);
		myListView.setAdapter(aa);
		super.onResume();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// return inflater.inflate(R.layout.item_align_frag, container, false);
		View view = inflater.inflate(R.layout.item_tolist_frag, container,
				false);
		myListView = (ListView) view.findViewById(R.id.todo_list);
		return view;
	}
}
