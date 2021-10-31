package com.example.spinnerex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    TextView details;
    ListView listclass;
    Spinner class_pick;
    Kita art, biology, cyber, electronics;
    String[] kitot = {"Choose class:", "Art", "Biology", "Cyber", "Electronics"};
    String[] empty_class;

    String[] first_names = {"Sanya","Bertha","Ashwin","Ines","Emily","Jamie","Izik","Eyal","Edna","Dorit","Yotam","Jules","Shiloh","Katherine","Johnathan","Esther","Shea","Indigo","Lynn","Ryley","Laurence","Everly","Jude","Faizaan","Yuval","Keegan","Harel","Etay","Paz","Yakir","Amit","Shon","Roni","Hila","Dorin","Shaked","Chloe","Serjo","Hanan","Albert"};
    String[] last_names = {"Hadar" , "Trachtenberg" , "Josephs" , "Wassermann" , "Gold" , "Beit" , "Jung" , "Jacobson" , "Tschkenow" , "Isaaman" , "Greenberg" , "Daiches" , "Meldola" , "Yakobovitch" , "Spiro" , "Katz" , "Levitsky" , "Mandebaum" , "Breuer" , "Dobias" , "Ben-Shahar" , "Gould" , "Zedner" , "Kedar" , "Dresner" , "Meninsky" , "Liberman" , "Gottesman" , "Levitch" , "Navon", "Malul", "Sabag", "Leibovitch", "Levi", "Shimoni", "Toledano", "Veintraub", "Yani", "Netanyahu", "Pahima"};
    String[] phone_numbers = {"972-52-3194444" , "972-3-6443535" , "972-3-5786476" , "972-50-5294184" , "972-4-6402029" , "972-3-6829295" , "972-077700-3020" , "972-52-6914747" , "972-77-2348881" , "972-2-6540178" , "972-3-9317980" , "972-3-9516404" , "972-2-6482326" , "972-3-9037366" , "972-3-6833275" , "972-52-2595365" , "972-54-5455400" , "972-3-6704041" , "972-3-5019197" , "972-3-5528687" , "972-3-9508407" , "972-8-9395000" , "972-52-3464048" , "972-3-5579663" , "972-3-5174177" , "972-3-6162922" , "972-3-9667036" , "972-4-8347186" , "972-2-5380618" , "972-54-6666165" , "972-3-5610977" , "972-52-5234506" , "972-3-5191600" , "972-3-9004000" , "972-3-5045451" , "972-52-4600492" , "972-73-2111709" , "972-3-5753586" , "972-4-8320477" , "972-3-6500913"};
    String[] birth_dates = {"25/10/2005", "27/10/2005", "08/12/05", "03/10/05", "05/07/05", "08/11/05", "06/07/05", "09/02/05", "08/04/05", "11/03/05", "02/10/05", "04/05/05", "11/01/05", "05/12/05", "08/09/05", "11/11/05", "10/08/05", "23/12/05", "20/05/05", "09/09/05", "18/02/05", "11/08/05", "28/01/05", "31/03/05", "10/10/05", "22/05/05", "24/06/05", "03/07/05", "12/03/05", "14/01/05", "21/08/05", "17/04/05", "29/09/05", "14/11/05", "11/01/05", "12/02/05", "14/02/05", "30/04/05", "03/06/05", "03/06/05"};
    String[] art1, biology1, cyber1, electronics1;
    ArrayAdapter<String> adpart, adpbiology, adpcyber, adpelec, adpempty;
    String curr_kita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        details = (TextView) findViewById(R.id.details);
        class_pick = (Spinner) findViewById(R.id.spinner);
        listclass = (ListView) findViewById(R.id.listview);
        art = new Kita();
        biology = new Kita();
        cyber = new Kita();
        electronics = new Kita();
        for (int i = 0; i<10; i++)
        {
            Student stu1 = new Student(first_names[i], last_names[i], phone_numbers[i], birth_dates[i]);
            art.addStudent(stu1);
            Student stu2 = new Student(first_names[10+i], last_names[10+i], phone_numbers[10+i], birth_dates[10+i]);
            biology.addStudent(stu2);
            Student stu3 = new Student(first_names[20+i], last_names[20+i], phone_numbers[20+i], birth_dates[20+i]);
            cyber.addStudent(stu3);
            Student stu4 = new Student(first_names[30+i], last_names[30+i], phone_numbers[30+i], birth_dates[30+i]);
            electronics.addStudent(stu4);
        }
        empty_class = new String[]{"","","","","","","","","",""};
        art1 = art.getTalmidim();
        biology1 = biology.getTalmidim();
        cyber1 = cyber.getTalmidim();
        electronics1 = electronics.getTalmidim();

        class_pick.setOnItemSelectedListener(this);
        listclass.setOnItemClickListener(this);
        listclass.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adp1 = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,kitot);

        class_pick.setAdapter(adp1);
        adpart = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,art1);
        adpbiology = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,biology1);
        adpcyber = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,cyber1);
        adpelec = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,electronics1);
        adpempty = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,empty_class);



    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (curr_kita == "art")
        {
            details.setText(art.getTalmidobj(position));
        }
        if (curr_kita == "biology")
        {
            details.setText(biology.getTalmidobj(position));
        }
        if (curr_kita == "cyber")
        {
            details.setText(cyber.getTalmidobj(position));
        }
        if (curr_kita == "electronics")
        {
            details.setText(electronics.getTalmidobj(position));
        }
        if (curr_kita == "empty")
        {
            details.setText("");
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 1)
        {
            listclass.setAdapter(adpart);
            curr_kita = "art";
            details.setText("");

        }
        if (position == 2)
        {
            listclass.setAdapter(adpbiology);
            curr_kita = "biology";
            details.setText("");

        }
        if (position == 3)
        {
            listclass.setAdapter(adpcyber);
            curr_kita = "cyber";
            details.setText("");

        }
        if (position == 4) {
            listclass.setAdapter(adpelec);
            curr_kita = "electronics";
            details.setText("");

        }
       if (position == 0)
           {
             listclass.setAdapter(adpempty);
             curr_kita = "empty";
             details.setText("");

           }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}