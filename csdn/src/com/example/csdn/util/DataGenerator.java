package com.example.csdn.util;

import java.util.ArrayList;
import java.util.List;

import com.example.csdn.bean.Child;
import com.example.csdn.bean.Group;
import com.example.csdn.bean.Type;

public class DataGenerator {

	public String[] groupNames = { "TextView的自定义", "EditText的自定义",
			"Button的自定义", "ListView的自定义", "ImageView的自定义", "ProgressBar自定义",
			"Layout自定义","View的自定义" };
	public String[][] childNames = {
			{ "FontTextView", "AlignText", "MarqueeText", "MultipleTextView",
					"BabushkaText", "TodoListItemView", "BorderTextView",
					"ScrollTextView", "ClockText", "ArrowTextView",
					"VerticalScrollTextView" ,"MoreTextView","NewsTitleTextView"},
			{ "EditTextWithDel", "BoderEdit", "Note", "PatternedEditText" },
			{ "SlipButton", "CircularProgressButton", "CircleButton",
					"CustomFAB", "WaterButton", "BerdyButton" },
			{ "CornerListView" },
			{ "RoundImageView" ,"GifView"},
			{ "NodeProgressBar","ZebraProgressBar" ,"RoundProgressBar", "PieProgress",
					"CustomClipLoading" } ,{"CircleLayout","ThreeTable","CardUI"},{"XCGuaguakaView","StepView","SlidingTab"}};
	public String[][] types = {
			{ Type.Font_TEXT, Type.ALIGN_TEXT, Type.MARQUEE_TEXT,
					Type.MULTIPLE_TEXT, Type.BABUSHKA_TEXT, Type.TODOLIST_TEXT,
					Type.BORDER_TEXT, Type.SCROLL_TEXT, Type.CLOCK_TEXT,
					Type.ARROW_TEXT, Type.VERTICAL_SCROLL_TEXT,Type.MORE_TEXT ,Type.NEWSTAB_TEXT},
			{ Type.DEL_EDIT, Type.BORDDER_EDIT, Type.NOTE_EDIT,
					Type.PATTERN_EDIT },
			{ Type.SLIP_BUTTON, Type.CIRCLE_PRO_BUTTON, Type.CIRCLE_BUTTON,
					Type.FAB_BUTTON, Type.WATER_BUTTON, Type.BERDY_BUTTON },
			{ Type.CORNOR_LISTVIEW },
			{ Type.ROUND_IMAGEVIEW ,Type.GIF_IMAGEVIEW},
			{Type.NODE_PROGRESSBAT, Type.ZEBRA_PROGRESSBAT, Type.ROUND_PROGRESSBAT,
					Type.PIE_PROGRESSBAT, Type.CUSTOM_PROGRESSBAT },{Type.CIRCLE_LAYOUT,Type.THREE_LAYOUT,Type.CARD_LAYOUT
						} ,{Type.GUGUKA_VIEW,Type.STEP_VIEW,Type.SLIDING}};

	public List<Group> getGroups() {
		List<Group> groups = new ArrayList<Group>();
		for (int i = 0; i < groupNames.length; i++) {
			Group g = new Group();
			List<Child> children = new ArrayList<Child>();
			for (int j = 0; j < childNames[i].length; j++) {
				Child c = new Child();
				c.setName(childNames[i][j]);
				c.setType(types[i][j]);
				children.add(c);
			}
			g.setName(groupNames[i]);
			g.setChildren(children);
			groups.add(g);
		}
		return groups;
	}
}
