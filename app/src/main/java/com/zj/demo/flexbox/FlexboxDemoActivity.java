package com.zj.demo.flexbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.flexbox.AlignContent;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

public class FlexboxDemoActivity extends AppCompatActivity {

    private String ROW;

    private String COLUMN;

    private String ROW_REVERSE;

    private String COLUMN_REVERSE;

    private String NOWRAP;

    private String WRAP;

    private String WRAP_REVERSE;

    private String FLEX_START;

    private String FLEX_END;

    private String CENTER;

    private String BASELINE;

    private String STRETCH;

    private String SPACE_BETWEEN;

    private String SPACE_AROUND;


    private FlexboxLayout flexboxLayout;
    Spinner direction, wrap, justifyContent, alignItem, alignContent;
    List<String> directionList = new ArrayList<>();
    List<String> wrapList = new ArrayList<>();
    List<String> justifyList = new ArrayList<>();
    List<String> alignItemList = new ArrayList<>();
    List<String> alignContentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flexbox_demo_layout);
        initializeStringResources();
        initView();
    }

    void initView() {
        flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox);
        direction = (Spinner) findViewById(R.id.direction);
        justifyContent = (Spinner) findViewById(R.id.justify_content);
        alignItem = (Spinner) findViewById(R.id.align_item);
        wrap = (Spinner) findViewById(R.id.wrap);
        alignContent = (Spinner) findViewById(R.id.align_content);
        initDirectionSpinner();
        initJustifySpinner();
        initWrapSpinner();
        initAlignItemSpinner();
        initAlignContentSpinner();
    }

    private void initializeStringResources() {
        ROW = getString(R.string.row);
        COLUMN = getString(R.string.column);
        ROW_REVERSE = getString(R.string.row_reverse);
        COLUMN_REVERSE = getString(R.string.column_reverse);

        NOWRAP = getString(R.string.nowrap);
        WRAP = getString(R.string.wrap);
        WRAP_REVERSE = getString(R.string.wrap_reverse);

        FLEX_START = getString(R.string.flex_start);
        FLEX_END = getString(R.string.flex_end);
        CENTER = getString(R.string.center);
        BASELINE = getString(R.string.baseline);
        STRETCH = getString(R.string.stretch);
        SPACE_BETWEEN = getString(R.string.space_between);
        SPACE_AROUND = getString(R.string.space_around);
    }

    private void initDirectionSpinner() {
        directionList.add(ROW);
        directionList.add(COLUMN);
        directionList.add(ROW_REVERSE);
        directionList.add(COLUMN_REVERSE);

        direction.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, directionList));
        direction.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                int flexDirection = FlexDirection.ROW;
                if (selected.equals(ROW)) {
                    flexDirection = FlexDirection.ROW;
                } else if (selected.equals(COLUMN)) {
                    flexDirection = FlexDirection.COLUMN;
                } else if (selected.equals(ROW_REVERSE)) {
                    flexDirection = FlexDirection.ROW_REVERSE;
                } else if (selected.equals(COLUMN_REVERSE)) {
                    flexDirection = FlexDirection.COLUMN_REVERSE;
                }
                flexboxLayout.setFlexDirection(flexDirection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initWrapSpinner() {
        wrapList.add(NOWRAP);
        wrapList.add(WRAP);
        wrapList.add(WRAP_REVERSE);

        wrap.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, wrapList));
        wrap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                int flexDirection = FlexWrap.NOWRAP;
                if (selected.equals(NOWRAP)) {
                    flexDirection = FlexWrap.NOWRAP;
                } else if (selected.equals(WRAP)) {
                    flexDirection = FlexWrap.WRAP;
                } else if (selected.equals(WRAP_REVERSE)) {
                    flexDirection = FlexWrap.WRAP_REVERSE;
                }
                flexboxLayout.setFlexWrap(flexDirection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initJustifySpinner() {
        justifyList.add(FLEX_START);
        justifyList.add(FLEX_END);
        justifyList.add(CENTER);
        justifyList.add(SPACE_BETWEEN);
        justifyList.add(SPACE_AROUND);

        justifyContent.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, justifyList));
        justifyContent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                int flexDirection = JustifyContent.FLEX_START;
                if (selected.equals(FLEX_START)) {
                    flexDirection = JustifyContent.FLEX_START;
                } else if (selected.equals(FLEX_END)) {
                    flexDirection = JustifyContent.FLEX_END;
                } else if (selected.equals(CENTER)) {
                    flexDirection = JustifyContent.CENTER;
                } else if (selected.equals(SPACE_BETWEEN)) {
                    flexDirection = JustifyContent.SPACE_BETWEEN;
                } else if (selected.equals(SPACE_AROUND)) {
                    flexDirection = JustifyContent.SPACE_AROUND;
                }
                flexboxLayout.setJustifyContent(flexDirection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void initAlignItemSpinner() {
        alignItemList.add(FLEX_START);
        alignItemList.add(FLEX_END);
        alignItemList.add(CENTER);
        alignItemList.add(BASELINE);
        alignItemList.add(STRETCH);

        alignItem.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, alignItemList));
        alignItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                int flexDirection = AlignItems.FLEX_START;
                if (selected.equals(FLEX_START)) {
                    flexDirection = AlignItems.FLEX_START;
                } else if (selected.equals(FLEX_END)) {
                    flexDirection = AlignItems.FLEX_END;
                } else if (selected.equals(CENTER)) {
                    flexDirection = AlignItems.CENTER;
                } else if (selected.equals(BASELINE)) {
                    flexDirection = AlignItems.BASELINE;
                } else if (selected.equals(STRETCH)) {
                    flexDirection = AlignItems.STRETCH;
                }
                flexboxLayout.setAlignItems(flexDirection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initAlignContentSpinner() {
        alignContentList.add(FLEX_START);
        alignContentList.add(FLEX_END);
        alignContentList.add(CENTER);
        alignContentList.add(SPACE_BETWEEN);
        alignContentList.add(SPACE_AROUND);
        alignContentList.add(STRETCH);

        alignContent.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, alignContentList));
        alignContent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                int flexDirection = AlignContent.FLEX_START;
                if (selected.equals(FLEX_START)) {
                    flexDirection = AlignContent.FLEX_START;
                } else if (selected.equals(FLEX_END)) {
                    flexDirection = AlignContent.FLEX_END;
                } else if (selected.equals(CENTER)) {
                    flexDirection = AlignContent.CENTER;
                } else if (selected.equals(SPACE_BETWEEN)) {
                    flexDirection = AlignContent.SPACE_BETWEEN;
                } else if (selected.equals(SPACE_AROUND)) {
                    flexDirection = AlignContent.SPACE_AROUND;
                } else if (selected.equals(STRETCH)) {
                    flexDirection = AlignContent.STRETCH;
                }
                flexboxLayout.setAlignContent(flexDirection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                int viewIndex = flexboxLayout.getChildCount();
                TextView textView = createBaseFlexItemTextView(viewIndex);
                textView.setLayoutParams(createDefaultLayoutParams());
                flexboxLayout.addView(textView);
                break;
            case R.id.menu_minus:
                if (flexboxLayout.getChildCount() == 0) {
                    return false;
                }
                flexboxLayout.removeViewAt(flexboxLayout.getChildCount() - 1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private TextView createBaseFlexItemTextView(int index) {
        TextView textView = new TextView(this);
        textView.setBackgroundResource(R.drawable.test_bg);
        textView.setText(String.valueOf(index + 1));
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    /**
     * Creates a new {@link FlexboxLayout.LayoutParams} based on the stored default values in
     * the SharedPreferences.
     *
     * @return a {@link FlexboxLayout.LayoutParams} instance
     */
    private FlexboxLayout.LayoutParams createDefaultLayoutParams() {
        int ran = 50 + Math.round(50);
        FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(Util.dpToPixel(this, ran), Util.dpToPixel(this, 30));
        return lp;
    }
}
