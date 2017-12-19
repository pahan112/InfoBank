package myproject.proteam.com.infobank.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myproject.proteam.com.infobank.R;
import myproject.proteam.com.infobank.model.ModelBaseBank;


public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder> {

    private List<ModelBaseBank> modelDataBaseBanks = new ArrayList<>();

    public BankAdapter(List<ModelBaseBank> modelDataBaseBanks) {
        this.modelDataBaseBanks = modelDataBaseBanks;
    }

    @Override
    public BankAdapter.BankViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bank, parent, false));
    }

    @Override
    public void onBindViewHolder(BankAdapter.BankViewHolder holder, int position) {
        holder.bind(modelDataBaseBanks.get(position));
    }

    @Override
    public int getItemCount() {
        return modelDataBaseBanks.size();
    }


    public class BankViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title_bank)
        TextView titleBankTextView;
        @BindView(R.id.tv_address_bank)
        TextView addressBankTextView;
        @BindView(R.id.tv_city_bank)
        TextView cityBankTextView;
        @BindView(R.id.tv_phone_bank)
        TextView phoneBankTextView;
        @BindView(R.id.tv_region_bank)
        TextView regionBankTextView;

        @BindView(R.id.iv_browser)
        ImageView imageViewBrowser;
        @BindView(R.id.iv_call)
        ImageView imageViewCall;
        @BindView(R.id.iv_map)
        ImageView imageViewMap;
        @BindView(R.id.iv_setting)
        ImageView imageViewSetting;

        public BankViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final ModelBaseBank modelDataBaseBanks) {
            titleBankTextView.setText(modelDataBaseBanks.getTitleDb());
            addressBankTextView.setText(itemView.getContext().getString(R.string.address) + " " + modelDataBaseBanks.getAddressDb());
            cityBankTextView.setText(modelDataBaseBanks.getCityIdDb());
            phoneBankTextView.setText(itemView.getContext().getString(R.string.phone) + " " + modelDataBaseBanks.getPhoneDb());
            regionBankTextView.setText(modelDataBaseBanks.getRegionIDb());
        }
    }
}
