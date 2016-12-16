package com.example.csdn.inter.imp;

import android.support.v4.app.Fragment;

import com.example.csdn.R;
import com.example.csdn.bean.Type;
import com.example.csdn.frag.AlignFrag;
import com.example.csdn.frag.ArrowProFrag;
import com.example.csdn.frag.BabushikaFrag;
import com.example.csdn.frag.CardFrag;
import com.example.csdn.frag.CircleProBuFrag;
import com.example.csdn.frag.CornorLisFrag;
import com.example.csdn.frag.FontFrag;
import com.example.csdn.frag.GifFrag;
import com.example.csdn.frag.GugukaViewFrag;
import com.example.csdn.frag.MarqueeFrag;
import com.example.csdn.frag.MoreTxtFrag;
import com.example.csdn.frag.MultipleFrag;
import com.example.csdn.frag.NewFrag;
import com.example.csdn.frag.NewsTabFrag;
import com.example.csdn.frag.NodeProFrag;
import com.example.csdn.frag.SliderBuFrag;
import com.example.csdn.frag.SlidingFrag;
import com.example.csdn.frag.SlipBuFrag;
import com.example.csdn.frag.StepFrag;
import com.example.csdn.frag.TableLayoutFrag;
import com.example.csdn.frag.TodolistFrag;
import com.example.csdn.frag.VerticalScrollFrag;
import com.example.csdn.frag.WaterBuFrag;
import com.example.csdn.inter.onCreateFragListener;

public class FragFactory implements onCreateFragListener {

	@Override
	public Fragment createFrag(String type) {
		Fragment frag = null;
		if (Type.Font_TEXT.equals(type)) {
			frag = new FontFrag(R.layout.item_font_frag);
		} else if (Type.ALIGN_TEXT.equals(type)) {
			frag = new AlignFrag();
		} else if (Type.MARQUEE_TEXT.equals(type)) {
			frag = new MarqueeFrag();
		} else if (Type.MULTIPLE_TEXT.equals(type)) {
			frag = new MultipleFrag();
		} else if (Type.BABUSHKA_TEXT.equals(type)) {
			frag = new BabushikaFrag();
		} else if (Type.TODOLIST_TEXT.equals(type)) {
			frag = new TodolistFrag();
		} else if (Type.BORDER_TEXT.equals(type)) {
			frag = new FontFrag(R.layout.item_bordertext_frag);
		} else if (Type.SCROLL_TEXT.equals(type)) {
			frag = new FontFrag(R.layout.item_scrolltext_frag);
		} else if (Type.ARROW_TEXT.equals(type)) {
			frag = new FontFrag(R.layout.item_arrow_frag);
		} else if (Type.VERTICAL_SCROLL_TEXT.equals(type)) {
			frag = new VerticalScrollFrag();
		} else if (Type.DEL_EDIT.equals(type)) {
			frag = new FontFrag(R.layout.item_del_edit_frag);
		} else if (Type.BORDDER_EDIT.equals(type)) {
			frag = new FontFrag(R.layout.item_border_edit_frag);
		} else if (Type.NOTE_EDIT.equals(type)) {
			frag = new FontFrag(R.layout.item_note_edit_frag);
		}else if (Type.PATTERN_EDIT.equals(type)) {
			frag = new FontFrag(R.layout.item_pattern_edit_frag);
		}else if (Type.SLIDE_BUTTON.equals(type)) {
			frag = new SliderBuFrag();
		}else if (Type.SLIP_BUTTON.equals(type)) {
			frag = new SlipBuFrag();
		}else if (Type.CIRCLE_PRO_BUTTON.equals(type)) {
			frag = new CircleProBuFrag();
		}else if (Type.CIRCLE_BUTTON.equals(type)) {
			frag = new FontFrag(R.layout.item_circle_button_frag);
		}else if (Type.FAB_BUTTON.equals(type)) {
			frag = new FontFrag(R.layout.item_fab_button_frag);
		}else if (Type.WATER_BUTTON.equals(type)) {
			frag = new WaterBuFrag();
		}else if (Type.BERDY_BUTTON.equals(type)) {
			frag = new FontFrag(R.layout.item_berdy_button_frag);
		}else if (Type.CORNOR_LISTVIEW.equals(type)) {
			frag = new CornorLisFrag();
		}else if (Type.ROUND_IMAGEVIEW.equals(type)) {
			frag = new FontFrag(R.layout.item_round_imagview_frag);
		}else if (Type.ZEBRA_PROGRESSBAT.equals(type)) {
			frag = new FontFrag(R.layout.item_zebar_pro_frag);
		}else if (Type.ARROW_PROGRESSBAT.equals(type)) {
			frag = new ArrowProFrag();
		}else if (Type.ROUND_PROGRESSBAT.equals(type)) {
			frag = new FontFrag(R.layout.item_round_pro_frag);
		}else if (Type.PIE_PROGRESSBAT.equals(type)) {
			frag = new FontFrag(R.layout.item_pie_pro_frag);
		}else if (Type.CUSTOM_PROGRESSBAT.equals(type)) {
			frag = new FontFrag(R.layout.item_customload_pro_frag);
		}else if (Type.CIRCLE_LAYOUT.equals(type)) {
			frag = new FontFrag(R.layout.item_circle_layout_frag);
		}else if (Type.FLOAT_LAYOUT.equals(type)) {
			frag = new FontFrag(R.layout.item_floatlable_frag);
		}else if (Type.THREE_LAYOUT.equals(type)) {
			frag = new TableLayoutFrag();
		}else if (Type.MORE_TEXT.equals(type)) {
			frag = new MoreTxtFrag();
		}else if (Type.NEWSTAB_TEXT.equals(type)) {
			frag = new NewsTabFrag();
		}else if (Type.CARD_LAYOUT.equals(type)) {
			frag = new CardFrag();
		}else if (Type.GIF_IMAGEVIEW.equals(type)) {
			frag = new GifFrag();
		}else if (Type.GUGUKA_VIEW.equals(type)) {
			frag = new GugukaViewFrag();
		}else if (Type.NODE_PROGRESSBAT.equals(type)) {
			frag = new NodeProFrag();
		}else if (Type.STEP_VIEW.equals(type)) {
			frag = new StepFrag();
		}else if (Type.SLIDING.equals(type)) {
			frag = new SlidingFrag();
		}
		
		
		
		
	
		else {
			frag = new NewFrag(type);
			
		}
		return frag;
	}

}
