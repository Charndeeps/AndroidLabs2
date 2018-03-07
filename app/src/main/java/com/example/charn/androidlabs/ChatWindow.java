package com.example.charn.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends Activity {

    ArrayList<String> list1 = new ArrayList<>();
    protected static final String ACTIVITY_NAME = "StartActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        Button btn = (Button) findViewById(R.id.button4);
        EditText edt = (EditText) findViewById(R.id.editText3);
        ListView list = (ListView) findViewById(R.id.listView1);
        ChatAdapter messageAdapter = new ChatAdapter(this);

        btn.setOnClickListener( (View e) -> {
                    list1.add(edt.getText().toString());
                    list.setAdapter(messageAdapter);
                    messageAdapter.notifyDataSetChanged(); //this restarts the process of getCount() & getView()
                    edt.setText("");

                }
        );

    }

    private class ChatAdapter extends ArrayAdapter<String> {

        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        public int getCount() {

            return list1.size();
        }

        public String getItem(int position) {

            return list1.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null;
            if (position % 2 == 0)
                result = inflater.inflate(R.layout.chat_row_incoming, null);

            else
                result = inflater.inflate(R.layout.chat_row_outgoing, null);

            TextView message = (TextView) result.findViewById(R.id.message_text);
            message.setText(getItem(position)); // get the string at position
            return result;

        }

        public long getId(int position) {

            return position;
        }
    }
}



