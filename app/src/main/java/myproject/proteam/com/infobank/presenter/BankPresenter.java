package myproject.proteam.com.infobank.presenter;

import java.util.ArrayList;
import java.util.List;

import myproject.proteam.com.infobank.model.ModelBank;
import myproject.proteam.com.infobank.model.ModelBaseBank;
import myproject.proteam.com.infobank.model.retrofit.RetrofitMain;
import myproject.proteam.com.infobank.view.BankViewInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BankPresenter {

    private BankViewInterface view;
    private List<ModelBaseBank> modelBaseBanks = new ArrayList<>();
    private List<ModelBaseBank> modelBaseBanksSearch = new ArrayList<>();


    public void attachView(BankViewInterface bankViewInterface) {
        view = bankViewInterface;
    }

    public void detachView() {
        view = null;
    }

    public void viewIsReady() {
        loadUsers();
    }

    public void loadUsers() {
        view.showProgress();
        loadDataBank();
        view.hideProgress();
    }

    public void swipeRefresh() {
        loadDataBank();
    }

    public void searchBank(String searchText) {
        if (searchText.isEmpty()) {
            view.search(modelBaseBanks);
        } else {
            modelBaseBanksSearch.clear();
            for (ModelBaseBank bank : modelBaseBanks) {
                if (bank.getTitleDb().toLowerCase().contains(searchText.toLowerCase()) || bank.getCityIdDb().toLowerCase().contains(searchText.toLowerCase())) {
                    modelBaseBanksSearch.add(bank);
                }
                view.search(modelBaseBanksSearch);
            }
        }
    }

    private void loadDataBank() {
        Call<ModelBank> getAllBank = RetrofitMain.getApiInterface().getNews();
        getAllBank.enqueue(new Callback<ModelBank>() {
            @Override
            public void onResponse(Call<ModelBank> call, Response<ModelBank> response) {
                for (int i = 0; i < response.body().getOrganizations().size(); i++) {
                    ModelBaseBank modelDataBaseBank = new ModelBaseBank();
                    modelDataBaseBank.setIdDb(response.body().getOrganizations().get(i).getIdDb());
                    modelDataBaseBank.setTitleDb(response.body().getOrganizations().get(i).getTitleDb());
                    modelDataBaseBank.setRegionIDb(response.body().getCities().get(response.body().getOrganizations().get(i).getCityIdDb()));
                    modelDataBaseBank.setCityIdDb(response.body().getRegions().get(response.body().getOrganizations().get(i).getRegionIDb()));
                    modelDataBaseBank.setPhoneDb(response.body().getOrganizations().get(i).getPhoneDb());
                    modelDataBaseBank.setAddressDb(response.body().getOrganizations().get(i).getAddressDb());
                    modelDataBaseBank.setLinkDb(response.body().getOrganizations().get(i).getLinkDb());
                    modelBaseBanks.add(modelDataBaseBank);
                }
                view.setBanks(modelBaseBanks);
            }

            @Override
            public void onFailure(Call<ModelBank> call, Throwable t) {
            }
        });
    }
}
