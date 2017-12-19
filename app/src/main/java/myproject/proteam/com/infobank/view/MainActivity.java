package myproject.proteam.com.infobank.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myproject.proteam.com.infobank.R;
import myproject.proteam.com.infobank.model.ModelBaseBank;
import myproject.proteam.com.infobank.model.adapter.BankAdapter;
import myproject.proteam.com.infobank.presenter.BankPresenter;


public class MainActivity extends AppCompatActivity implements BankViewInterface {

    @BindView(R.id.rv_bank_list)
    RecyclerView mRecyclerViewBank;
    @BindView(R.id.pb_bank)
    ProgressBar mProgressBar;
    @BindView(R.id.sr_bank)
    SwipeRefreshLayout mBankSwipeRefreshLayout;
    @BindView(R.id.sv_bank)
    SearchView mSearchViewBank;

    private BankAdapter mBankAdapter;
    private BankPresenter bankPresenter;
    private List<ModelBaseBank> modelBaseBanks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mBankAdapter = new BankAdapter(modelBaseBanks);
        mRecyclerViewBank.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewBank.setAdapter(mBankAdapter);

        bankPresenter = new BankPresenter();
        bankPresenter.attachView(this);
        bankPresenter.viewIsReady();
        initSwipeRefreshLayout();
        initSearch();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setBanks(List<ModelBaseBank> modelBaseBankList) {
        modelBaseBanks.clear();
        modelBaseBanks.addAll(modelBaseBankList);
        mBankAdapter.notifyDataSetChanged();
    }

    private void initSwipeRefreshLayout() {
        mBankSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                bankPresenter.swipeRefresh();
                mBankSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void search(List<ModelBaseBank> modelBaseBankList) {
        modelBaseBanks.clear();
        modelBaseBanks.addAll(modelBaseBankList);
        mBankAdapter.notifyDataSetChanged();
    }

    private void initSearch() {
        mSearchViewBank.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                bankPresenter.searchBank(newText);
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bankPresenter.detachView();
    }
}
