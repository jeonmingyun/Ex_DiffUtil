package com.example.ex_diffutils;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserAdapter mAdapter;
    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = findViewById(R.id.recycler);

        findViewById(R.id.update_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.updateItems(new UserVo().getTestList(mAdapter.getItemCount()+1));
            }
        });

        initRecycler(new UserVo().getTestList(3));
    }

    private void initRecycler(ArrayList<UserVo> itemList) {
        mAdapter = new UserAdapter(this, itemList);
        LinearLayoutManager lm = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(this, lm.getOrientation());
        divider.setDrawable(this.getDrawable(R.drawable.divider));
        mRecycler.setLayoutManager(lm);
        mRecycler.addItemDecoration(divider);
        mRecycler.setAdapter(mAdapter);
    }
}