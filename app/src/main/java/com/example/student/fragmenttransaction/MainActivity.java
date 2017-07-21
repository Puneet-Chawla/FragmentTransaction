package com.example.student.fragmenttransaction;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener{

    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=getFragmentManager();
        manager.addOnBackStackChangedListener(this);
    }

    @Override
    public void onBackStackChanged() {
        int length=manager.getBackStackEntryCount();
        StringBuilder msg=new StringBuilder("");
        for(int i=length-1;i>=0;i--)
        {
            msg.append("Index:").append(i).append(":");
            msg.append(manager.getBackStackEntryAt(i).getName()).append("\n");
        }

    }
    public void AddFragmentA(View v)
    {FragmentA fragmentA=new FragmentA();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.container,fragmentA,"fragA");
        transaction.addToBackStack("AddfragA");
        transaction.commit();
    }
    public void removeFragmentA(View v)
    {
        FragmentA fragmentA=(FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction=manager.beginTransaction();
        if(fragmentA !=null)
        {
            transaction.remove(fragmentA);
            transaction.addToBackStack("removefragA");
            transaction.commit();
        }
    }
}
