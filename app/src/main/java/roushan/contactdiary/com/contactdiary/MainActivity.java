package roushan.contactdiary.com.contactdiary;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nameTxt, phoneTxt, emailTxt, addressTxt, dateTxt;
    List<Contact> Contacts = new ArrayList<Contact>();
    ListView contactListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTxt = (EditText) findViewById(R.id.name);
        nameTxt = (EditText) findViewById(R.id.phone);
        nameTxt = (EditText) findViewById(R.id.email);
        nameTxt = (EditText) findViewById(R.id.address);
        nameTxt = (EditText) findViewById(R.id.dob);
        contactListView = (ListView) findViewById(R.id.ListView);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Add");
        tabSpec.setContent(R.id.add);
        tabSpec.setIndicator("Add");
        tabHost.addTab(tabSpec);

        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Saved");
        tabSpec1.setContent(R.id.saved);
        tabSpec1.setIndicator("Saved");
        tabHost.addTab(tabSpec1);

        final Button addBtn = (Button) findViewById(R.id.button);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContact(nameTxt.getText().toString(), phoneTxt.getText().toString(), emailTxt.getText().toString(), addressTxt.getText().toString(), dateTxt.getText().toString());
                populatedList();
                Toast.makeText(getApplicationContext(),nameTxt.getText().toString() + "has been Saved!",Toast.LENGTH_LONG).show();

            }
        });


        nameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                addBtn.setEnabled(!nameTxt.getText().toString().trim().isEmpty());


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void populatedList(){
        ArrayAdapter<Contact> adaptor = new ContactListAdaptor();
        contactListView.setAdapter(adaptor);
    }

    private void addContact(String name, String phone, String email, String address, String dob){
        Contacts.add(new Contact(name, phone, email, address, dob));
    }

    private class ContactListAdaptor extends ArrayAdapter<Contact>{

        public ContactListAdaptor(){
            super(MainActivity.this, R.layout.listview_item, Contacts);
        }

        @NonNull
        @Override
        public View getView (int position, View view, ViewGroup parent) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item,parent, false);

            Contact currentContact = Contacts.get(position);
            TextView name = (TextView) view.findViewById(R.id.contact1);
            name.setText(currentContact.getName());

            TextView phone = (TextView) view.findViewById(R.id.phone1);
            phone.setText(currentContact.getPhone());

            TextView email = (TextView) view.findViewById(R.id.email1);
            email.setText(currentContact.getEmail());

            TextView address = (TextView) view.findViewById(R.id.address1);
            address.setText(currentContact.getAddress());

            TextView dob = (TextView) view.findViewById(R.id.dob1);
            dob.setText(currentContact.getDob());

            return view;

        }
    }
}

