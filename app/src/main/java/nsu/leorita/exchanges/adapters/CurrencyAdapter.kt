package nsu.leorita.exchanges.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nsu.leorita.exchanges.databinding.ItemCurrencyBinding
import nsu.leorita.exchanges.domain.model.Currency

class CurrencyAdapter(private val onClick: (Currency) -> Unit) : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {
    var data: ArrayList<Currency> = ArrayList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class CurrencyViewHolder(
        private val binding: ItemCurrencyBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(currency: Currency, onClick: (Currency) -> Unit) {
            binding.nameTextView.text = currency.name
            binding.symbolTextView.text = currency.code
            binding.nominalTextView.text = currency.getRange().toString()
            binding.root.setOnClickListener {
                onClick(currency)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCurrencyBinding.inflate(inflater, parent, false)

        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) =
        holder.bind(data[position], onClick)

    override fun getItemCount(): Int = data.size
}