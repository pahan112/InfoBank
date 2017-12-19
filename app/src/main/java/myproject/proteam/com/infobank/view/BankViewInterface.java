package myproject.proteam.com.infobank.view;


import java.util.List;

import myproject.proteam.com.infobank.model.ModelBaseBank;


public interface BankViewInterface {
    void showProgress();

    void hideProgress();

    void setBanks(List<ModelBaseBank> modelBaseBankList);

    void search(List<ModelBaseBank> modelBaseBankList);

}
